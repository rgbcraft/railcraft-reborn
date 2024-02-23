package mods.railcraft.advancements;

import net.minecraft.advancements.critereon.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.google.gson.JsonObject;
import mods.railcraft.Railcraft;
import mods.railcraft.util.Conditions;
import mods.railcraft.util.JsonUtil;
import mods.railcraft.world.level.block.entity.RailcraftBlockEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;

public class MultiBlockFormedTrigger extends
        SimpleCriterionTrigger<MultiBlockFormedTrigger.Instance> {

    private static final ResourceLocation ID = Railcraft.rl("multiblock_formed");

    @Override
    public @NotNull ResourceLocation getId() {
        return ID;
    }

    @Override
    protected MultiBlockFormedTrigger.@NotNull Instance createInstance(@NotNull JsonObject json, EntityPredicate.@NotNull Composite player, @NotNull DeserializationContext deserializationContext) {
        var type = JsonUtil.getFromRegistry(json, "type", ForgeRegistries.BLOCK_ENTITY_TYPES)
                .orElse(null);
        var nbt = JsonUtil.getAsJsonObject(json, "nbt")
                .map(NbtPredicate::fromJson)
                .orElse(NbtPredicate.ANY);
        return new MultiBlockFormedTrigger.Instance(player, type, nbt);
    }

    /**
     * Invoked when the user forms a multiblock.
     */
    public void trigger(ServerPlayer playerEntity, RailcraftBlockEntity blockEntity) {
        this.trigger(playerEntity, (criterionInstance) -> criterionInstance.matches(blockEntity));
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        @Nullable
        private final BlockEntityType<?> type;
        private final NbtPredicate predicate;

        private Instance(EntityPredicate.@NotNull Composite player,
                         @Nullable BlockEntityType<?> type, NbtPredicate predicate) {
            super(MultiBlockFormedTrigger.ID, player);
            this.type = type;
            this.predicate = predicate;
        }

        public static MultiBlockFormedTrigger.Instance formedMultiBlock(
                BlockEntityType<?> tileEntityType) {
            return formedMultiBlock(tileEntityType, NbtPredicate.ANY);
        }

        public static MultiBlockFormedTrigger.Instance formedMultiBlock(
                BlockEntityType<?> tileEntityType, NbtPredicate nbtPredicate) {
            return new MultiBlockFormedTrigger.Instance(EntityPredicate.Composite.ANY, tileEntityType,
                    nbtPredicate);
        }

        public boolean matches(RailcraftBlockEntity blockEntity) {
            return Conditions.check(this.type, blockEntity.getType())
                    && this.predicate.matches(blockEntity.saveWithoutMetadata());
        }

        @Override
        public ResourceLocation getCriterion() {
            return ID;
        }

        @Override
        public JsonObject serializeToJson(SerializationContext serializer) {
            JsonObject json = new JsonObject();
            if (this.type != null) {
                json.addProperty("type", ForgeRegistries.BLOCK_ENTITY_TYPES.getKey(this.type).toString());
            }
            json.add("nbt", this.predicate.serializeToJson());
            return json;
        }
    }

}
