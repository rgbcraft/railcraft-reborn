package mods.railcraft.advancements;

import com.google.gson.JsonObject;
import mods.railcraft.Railcraft;
import mods.railcraft.util.JsonUtil;
import mods.railcraft.util.LevelUtil;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

public class SpikeMaulUseTrigger extends SimpleCriterionTrigger<SpikeMaulUseTrigger.Instance> {

    private static final ResourceLocation ID = Railcraft.rl("spike_maul_use");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public SpikeMaulUseTrigger.@NotNull Instance createInstance(@NotNull JsonObject json,
                                                                EntityPredicate.@NotNull Composite player, @NotNull DeserializationContext deserializationContext) {
        var tag = JsonUtil.getAsJsonObject(json, "nbt")
                .map(NbtPredicate::fromJson)
                .orElse(NbtPredicate.ANY);
        var tool = JsonUtil.getAsJsonObject(json, "tool")
                .map(ItemPredicate::fromJson)
                .orElse(ItemPredicate.ANY);
        var locationPredicate = JsonUtil.getAsJsonObject(json, "location")
                .map(LocationPredicate::fromJson)
                .orElse(LocationPredicate.ANY);
        return new SpikeMaulUseTrigger.Instance(player, tag, tool, locationPredicate);
    }

    /**
     * Invoked when the user successfully uses a spike maul.
     */
    public void trigger(ServerPlayer player, ItemStack item,
                        ServerLevel serverLevel, BlockPos pos) {
        this.trigger(player, (criterionInstance) -> criterionInstance.matches(item, serverLevel, pos));
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        private final NbtPredicate nbt;
        private final ItemPredicate tool;
        private final LocationPredicate location;

        private Instance(EntityPredicate.@NotNull Composite player, NbtPredicate nbt,
                         ItemPredicate tool, LocationPredicate predicate) {
            super(SpikeMaulUseTrigger.ID, player);
            this.nbt = nbt;
            this.tool = tool;
            this.location = predicate;
        }

        public static SpikeMaulUseTrigger.Instance hasUsedSpikeMaul() {
            return new SpikeMaulUseTrigger.Instance(EntityPredicate.Composite.ANY,
                    NbtPredicate.ANY, ItemPredicate.ANY, LocationPredicate.ANY);
        }

        public boolean matches(ItemStack item, ServerLevel level, BlockPos pos) {
            return LevelUtil.getBlockEntity(level, pos)
                    .map(BlockEntity::saveWithoutMetadata)
                    .map(this.nbt::matches)
                    .orElse(false)
                    && this.tool.matches(item)
                    && this.location.matches(level, pos.getX(), pos.getY(), pos.getZ());
        }

        @Override
        public ResourceLocation getCriterion() {
            return ID;
        }

        @Override
        public JsonObject serializeToJson(SerializationContext serializer) {
            JsonObject json = new JsonObject();
            json.add("nbt", this.nbt.serializeToJson());
            json.add("tool", this.tool.serializeToJson());
            json.add("location", this.location.serializeToJson());
            return json;
        }
    }
}
