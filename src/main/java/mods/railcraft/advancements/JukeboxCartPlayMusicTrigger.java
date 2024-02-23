package mods.railcraft.advancements;

import java.util.Objects;

import net.minecraft.advancements.critereon.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.google.gson.JsonObject;
import mods.railcraft.Railcraft;
import mods.railcraft.util.JsonUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.vehicle.AbstractMinecart;

public class JukeboxCartPlayMusicTrigger
        extends SimpleCriterionTrigger<JukeboxCartPlayMusicTrigger.Instance> {

    private static final ResourceLocation ID = Railcraft.rl("jukebox_cart_play_music");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public JukeboxCartPlayMusicTrigger.@NotNull Instance createInstance(@NotNull JsonObject json, EntityPredicate.@NotNull Composite player, @NotNull DeserializationContext deserializationContext) {
        var sound = JsonUtil.getAsString(json, "music")
                .map(ResourceLocation::tryParse)
                .orElse(null);
        var cart = JsonUtil.getAsJsonObject(json, "cart")
                .map(MinecartPredicate::deserialize)
                .orElse(MinecartPredicate.ANY);
        return new JukeboxCartPlayMusicTrigger.Instance(player, sound, cart);
    }

    /**
     * Invoked when the user plays music on a cart.
     */
    public void trigger(ServerPlayer playerEntity, AbstractMinecart cart,
                        ResourceLocation music) {
        this.trigger(playerEntity,
                (criterionInstance) -> criterionInstance.matches(playerEntity, cart, music));
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        @Nullable
        private final ResourceLocation music;
        private final MinecartPredicate cart;

        private Instance(EntityPredicate.@NotNull Composite player,
                         @Nullable ResourceLocation music, MinecartPredicate cart) {
            super(JukeboxCartPlayMusicTrigger.ID, player);
            this.music = music;
            this.cart = cart;
        }

        public static JukeboxCartPlayMusicTrigger.Instance hasPlayedAnyMusic() {
            return new JukeboxCartPlayMusicTrigger.Instance(EntityPredicate.Composite.ANY,
                    null, MinecartPredicate.ANY);
        }

        public static JukeboxCartPlayMusicTrigger.Instance hasPlayedMusic(ResourceLocation music) {
            return new JukeboxCartPlayMusicTrigger.Instance(EntityPredicate.Composite.ANY,
                    music, MinecartPredicate.ANY);
        }

        public boolean matches(ServerPlayer player, AbstractMinecart cart,
                               ResourceLocation sound) {
            return (music == null || Objects.equals(sound, music)) && this.cart.test(player, cart);
        }

        @Override
        public ResourceLocation getCriterion() {
            return ID;
        }

        @Override
        public JsonObject serializeToJson(SerializationContext serializer) {
            JsonObject json = new JsonObject();
            if (this.music != null) {
                json.addProperty("music", this.music.toString());
            }
            json.add("cart", this.cart.serializeToJson());
            return json;
        }
    }
}
