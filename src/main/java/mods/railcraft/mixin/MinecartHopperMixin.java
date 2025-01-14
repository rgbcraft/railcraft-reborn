package mods.railcraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import mods.railcraft.api.carts.RollingStock;
import mods.railcraft.api.container.manipulator.ContainerManipulator;
import net.minecraft.world.entity.vehicle.MinecartHopper;

@Mixin(MinecartHopper.class)
public class MinecartHopperMixin {

    @Unique
    private static final int PUSH_COOLDOWN_TICKS = 5;

    @Unique
    private int railcraft$pushTime = PUSH_COOLDOWN_TICKS;

    @Inject(method = "tick", at = @At("RETURN"))
    private void railcraft$pushItems(CallbackInfo callbackInfo) {
        var self = (MinecartHopper) (Object) this;
        if (!self.getLevel().isClientSide()
                && self.isAlive()
                && this.railcraft$pushTime-- == 0) {
            railcraft$tryPushItem(self);
            this.railcraft$pushTime = PUSH_COOLDOWN_TICKS;
        }
    }

    @Unique
    private static void railcraft$tryPushItem(MinecartHopper self) {
        var manipulator = ContainerManipulator.of(self);
        var rollingStock = RollingStock.getOrThrow(self);
        var full = true;
        // Push full stacks whenever possible
        for (var slot : manipulator) {
            if (slot.isFull()) {
                slot.setItem(rollingStock.pushItem(slot.item()));
            }

            if (slot.isEmpty()) {
                full = false;
            }
        }

        if (!full) {
            return;
        }

        // If all slots are occupied, try to clear one of the slots.
        for (var slot : manipulator) {
            var left = rollingStock.pushItem(slot.item());
            slot.setItem(left);
            if (left.isEmpty()) {
                return;
            }
        }
    }
}
