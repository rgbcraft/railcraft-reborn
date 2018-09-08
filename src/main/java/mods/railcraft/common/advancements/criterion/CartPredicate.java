package mods.railcraft.common.advancements.criterion;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mods.railcraft.api.carts.CartToolsAPI;
import mods.railcraft.common.carts.CartTools;
import mods.railcraft.common.carts.LinkageHandler;
import mods.railcraft.common.util.json.JsonTools;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.JsonUtils;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * A utility for testing carts or so.
 */
public final class CartPredicate {

    public static final CartPredicate ANY = new CartPredicate(null, null, null, null, MinMaxBounds.UNBOUNDED, EntityPredicate.ANY);

    @Nullable
    final Boolean highSpeed;
    @Nullable
    final Boolean launched;
    @Nullable
    final Boolean elevator;
    @Nullable
    final Boolean checksOwner;
    final MinMaxBounds speed;

    final EntityPredicate parent;

    public CartPredicate(@Nullable Boolean highSpeed, @Nullable Boolean launched, @Nullable Boolean elevator, @Nullable Boolean checkOwner, MinMaxBounds speed, EntityPredicate parent) {
        this.highSpeed = highSpeed;
        this.launched = launched;
        this.elevator = elevator;
        this.checksOwner = checkOwner;
        this.speed = speed;
        this.parent = parent;
    }

    public boolean test(EntityPlayerMP player, EntityMinecart cart) {
        if (highSpeed != null && CartTools.isTravellingHighSpeed(cart) != highSpeed) {
            return false;
        }
        if (launched != null && LinkageHandler.getInstance().isLaunched(cart) != launched) {
            return false;
        }
        if (elevator != null && LinkageHandler.getInstance().isOnElevator(cart) != elevator) {
            return false;
        }
        if (checksOwner != null && !Objects.equals(player.getGameProfile().getId(), CartToolsAPI.getCartOwner(cart).getId())) {
            return false;
        }
        if (!speed.testSquare(CartToolsAPI.getCartSpeedUncappedSquared(cart))) {
            return false;
        }
        return parent.test(player, cart);
    }

    public static CartPredicate deserialize(@Nullable JsonElement element) {
        if (element == null || element.isJsonNull()) {
            return CartPredicate.ANY;
        }
        JsonObject object = JsonUtils.getJsonObject(element, "a cart predicate");

        Boolean highSpeed = JsonTools.nullableBoolean(object, "high_speed");
        Boolean launched = JsonTools.nullableBoolean(object, "launched");
        Boolean elevator = JsonTools.nullableBoolean(object, "elevator");
        Boolean checksOwner = JsonTools.nullableBoolean(object, "check_owner");
        MinMaxBounds speed = MinMaxBounds.deserialize(object.get("speed"));
        EntityPredicate parent = EntityPredicate.deserialize(object);

        return new CartPredicate(highSpeed, launched, elevator, checksOwner, speed, parent);
    }
}
