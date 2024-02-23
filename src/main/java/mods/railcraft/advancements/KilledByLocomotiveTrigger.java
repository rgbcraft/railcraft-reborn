package mods.railcraft.advancements;

import com.google.gson.JsonObject;
import mods.railcraft.Railcraft;
import mods.railcraft.util.JsonUtil;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import org.jetbrains.annotations.NotNull;

/**
 * I tried to fight the train. The train won.
 */
public class KilledByLocomotiveTrigger
        extends SimpleCriterionTrigger<KilledByLocomotiveTrigger.Instance> {

    private static final ResourceLocation ID = Railcraft.rl("killed_by_locomotive");

    @Override
    public @NotNull ResourceLocation getId() {
        return ID;
    }

    @Override
    protected @NotNull Instance createInstance(@NotNull JsonObject json, EntityPredicate.@NotNull Composite player, @NotNull DeserializationContext deserializationContext) {
        var predicate = JsonUtil.getAsJsonObject(json, "cart")
                .map(MinecartPredicate::deserialize)
                .orElse(MinecartPredicate.ANY);
        return new KilledByLocomotiveTrigger.Instance(player, predicate);
    }

    /**
     * Invoked when the user dies due to train tomfoolery.
     */
    public void trigger(ServerPlayer playerEntity, AbstractMinecart cart) {
        this.trigger(playerEntity, (KilledByLocomotiveTrigger.Instance criterionInstance) -> {
            return criterionInstance.matches(playerEntity, cart);
        });
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        private final MinecartPredicate cart;

        private Instance(EntityPredicate.@NotNull Composite player, MinecartPredicate cart) {
            super(KilledByLocomotiveTrigger.ID, player);
            this.cart = cart;
        }

        public boolean matches(ServerPlayer player, AbstractMinecart cart) {
            return this.cart.test(player, cart);
        }

        @Override
        public @NotNull ResourceLocation getCriterion() {
            return ID;
        }

        @Override
        public JsonObject serializeToJson(SerializationContext serializer) {
            JsonObject json = new JsonObject();
            json.add("cart", this.cart.serializeToJson());
            return json;
        }
    }
}
