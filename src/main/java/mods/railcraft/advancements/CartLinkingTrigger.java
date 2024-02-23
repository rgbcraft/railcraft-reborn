package mods.railcraft.advancements;

import com.google.gson.JsonObject;
import mods.railcraft.Railcraft;
import mods.railcraft.util.JsonUtil;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import org.jetbrains.annotations.NotNull;

public class CartLinkingTrigger extends SimpleCriterionTrigger<CartLinkingTrigger.Instance> {

    private static final ResourceLocation ID = Railcraft.rl("cart_linking");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public CartLinkingTrigger.@NotNull Instance createInstance(@NotNull JsonObject json, EntityPredicate.@NotNull Composite player, @NotNull DeserializationContext deserializationContext) {
        var owned = JsonUtil.getAsJsonObject(json, "owned")
                .map(MinecartPredicate::deserialize)
                .orElse(MinecartPredicate.ANY);
        var other = JsonUtil.getAsJsonObject(json, "other")
                .map(MinecartPredicate::deserialize)
                .orElse(MinecartPredicate.ANY);
        return new CartLinkingTrigger.Instance(player, owned, other);
    }

    /**
     * Invoked when the user links a cart.
     */
    public void trigger(ServerPlayer playerEntity, AbstractMinecart owned,
                        AbstractMinecart other) {
        this.trigger(playerEntity,
                (criterionInstance) -> criterionInstance.matches(playerEntity, owned, other));
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        private final MinecartPredicate owned;
        private final MinecartPredicate other;

        private Instance(EntityPredicate.@NotNull Composite player,
                         MinecartPredicate owned, MinecartPredicate other) {
            super(CartLinkingTrigger.ID, player);
            this.owned = owned;
            this.other = other;
        }

        public static CartLinkingTrigger.Instance hasLinked() {
            return new CartLinkingTrigger.Instance(EntityPredicate.Composite.ANY,
                    MinecartPredicate.ANY, MinecartPredicate.ANY);
        }

        public boolean matches(ServerPlayer player, AbstractMinecart owned,
                               AbstractMinecart other) {
            return this.owned.test(player, owned) && this.other.test(player, other);
        }

        @Override
        public ResourceLocation getCriterion() {
            return ID;
        }

        @Override
        public JsonObject serializeToJson(SerializationContext serializer) {
            JsonObject json = new JsonObject();
            json.add("owned", this.owned.serializeToJson());
            json.add("other", this.other.serializeToJson());
            return json;
        }
    }

}
