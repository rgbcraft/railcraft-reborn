package mods.railcraft.advancements;

import com.google.gson.JsonObject;
import mods.railcraft.Railcraft;
import mods.railcraft.util.JsonUtil;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import org.jetbrains.annotations.NotNull;

public class BedCartSleepTrigger extends SimpleCriterionTrigger<BedCartSleepTrigger.Instance> {

    private static final ResourceLocation ID = Railcraft.rl("bed_cart_sleep");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    protected BedCartSleepTrigger.@NotNull Instance createInstance(@NotNull JsonObject json, EntityPredicate.@NotNull Composite player, @NotNull DeserializationContext deserializationContext) {
        var predicate = JsonUtil.getAsJsonObject(json, "cart")
                .map(MinecartPredicate::deserialize)
                .orElse(MinecartPredicate.ANY);
        return new BedCartSleepTrigger.Instance(player, predicate);
    }

    /**
     * Invoked when the user sleeps on a cart.
     */
    public void trigger(ServerPlayer playerEntity, AbstractMinecart cartPredicate) {
        this.trigger(playerEntity,
                (criterionInstance) -> criterionInstance.matches(playerEntity, cartPredicate));
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        private final MinecartPredicate cartPredicate;

        private Instance(EntityPredicate.@NotNull Composite player, MinecartPredicate predicate) {
            super(BedCartSleepTrigger.ID, player);
            this.cartPredicate = predicate;
        }

        public static BedCartSleepTrigger.Instance hasSlept() {
            return new BedCartSleepTrigger.Instance(EntityPredicate.Composite.ANY, MinecartPredicate.ANY);
        }

        public boolean matches(ServerPlayer player, AbstractMinecart cartPredicate) {
            return this.cartPredicate.test(player, cartPredicate) && player.isSleeping();
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
