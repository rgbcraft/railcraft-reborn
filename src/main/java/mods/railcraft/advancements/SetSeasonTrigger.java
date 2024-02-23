package mods.railcraft.advancements;

import net.minecraft.advancements.critereon.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.google.gson.JsonObject;
import mods.railcraft.Railcraft;
import mods.railcraft.season.Season;
import mods.railcraft.util.JsonUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.vehicle.AbstractMinecart;

public class SetSeasonTrigger extends SimpleCriterionTrigger<SetSeasonTrigger.Instance> {

    private static final ResourceLocation ID = Railcraft.rl("set_season");

    @Override
    public @NotNull ResourceLocation getId() {
        return ID;
    }

    @Override
    public @NotNull Instance createInstance(@NotNull JsonObject json,
                                            EntityPredicate.@NotNull Composite player, @NotNull DeserializationContext deserializationContext) {
        var season = JsonUtil.getAsString(json, "season")
                .map(Integer::valueOf)
                .map(x -> Season.values()[x])
                .orElse(null);
        var cartPredicate = JsonUtil.getAsJsonObject(json, "cart")
                .map(MinecartPredicate::deserialize)
                .orElse(MinecartPredicate.ANY);
        return new SetSeasonTrigger.Instance(player, season, cartPredicate);
    }

    /**
     * Invoked when the user changes the cart's season option i think?.
     */
    public void trigger(ServerPlayer playerEntity, AbstractMinecart cart,
                        Season target) {
        this.trigger(playerEntity,
                (criterionInstance) -> criterionInstance.matches(playerEntity, cart, target));
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        @Nullable
        private final Season season;
        private final MinecartPredicate cartPredicate;

        private Instance(EntityPredicate.@NotNull Composite player, @Nullable Season season,
                         MinecartPredicate predicate) {
            super(SetSeasonTrigger.ID, player);
            this.season = season;
            this.cartPredicate = predicate;
        }

        public static SetSeasonTrigger.Instance onSeasonSet() {
            return new SetSeasonTrigger.Instance(EntityPredicate.Composite.ANY,
                    null, MinecartPredicate.ANY);
        }

        public boolean matches(ServerPlayer player, AbstractMinecart cart, Season target) {
            return (this.season == null || this.season.equals(target))
                    && this.cartPredicate.test(player, cart);
        }

        @Override
        public ResourceLocation getCriterion() {
            return ID;
        }

        @Override
        public JsonObject serializeToJson(SerializationContext serializer) {
            JsonObject json = new JsonObject();
            if (this.season != null) {
                json.addProperty("season", this.season.ordinal());
            }
            json.add("cart", this.cartPredicate.serializeToJson());
            return json;
        }
    }
}
