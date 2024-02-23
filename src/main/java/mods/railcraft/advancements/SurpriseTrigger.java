package mods.railcraft.advancements;

import com.google.gson.JsonObject;
import mods.railcraft.Railcraft;
import mods.railcraft.util.JsonUtil;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import org.jetbrains.annotations.NotNull;

public class SurpriseTrigger extends SimpleCriterionTrigger<SurpriseTrigger.Instance> {

    private static final ResourceLocation ID = Railcraft.rl("surprise");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public SurpriseTrigger.@NotNull Instance createInstance(@NotNull JsonObject json, EntityPredicate.@NotNull Composite player, @NotNull DeserializationContext deserializationContext) {
        var predicate = JsonUtil.getAsJsonObject(json, "cart")
                .map(MinecartPredicate::deserialize)
                .orElse(MinecartPredicate.ANY);
        return new SurpriseTrigger.Instance(player, predicate);
    }

    /**
     * Invoked when the user explodes a cart.
     */
    public void trigger(ServerPlayer playerEntity, AbstractMinecart cart) {
        this.trigger(playerEntity,
                (criterionInstance) -> criterionInstance.matches(playerEntity, cart));
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        private final MinecartPredicate cartPredicate;

        private Instance(EntityPredicate.@NotNull Composite player, MinecartPredicate predicate) {
            super(SurpriseTrigger.ID, player);
            this.cartPredicate = predicate;
        }

        public static SurpriseTrigger.Instance hasExplodedCart() {
            return new SurpriseTrigger.Instance(EntityPredicate.Composite.ANY, MinecartPredicate.ANY);
        }

        public boolean matches(ServerPlayer player, AbstractMinecart cart) {
            return cartPredicate.test(player, cart);
        }

        @Override
        public ResourceLocation getCriterion() {
            return ID;
        }

        @Override
        public JsonObject serializeToJson(SerializationContext serializer) {
            JsonObject json = new JsonObject();
            json.add("cart", this.cartPredicate.serializeToJson());
            return json;
        }
    }
}
