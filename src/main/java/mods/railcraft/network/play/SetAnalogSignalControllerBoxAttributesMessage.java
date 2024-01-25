package mods.railcraft.network.play;

import java.util.BitSet;
import java.util.Map;
import java.util.function.Supplier;
import mods.railcraft.api.signal.SignalAspect;
import mods.railcraft.world.level.block.entity.RailcraftBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public record SetAnalogSignalControllerBoxAttributesMessage(BlockPos blockPos,
    Map<SignalAspect, BitSet> signalAspectTriggerSignals) {

  public void encode(FriendlyByteBuf out) {
    out.writeBlockPos(this.blockPos);
    out.writeMap(this.signalAspectTriggerSignals,
        FriendlyByteBuf::writeEnum, FriendlyByteBuf::writeBitSet);
  }

  public static SetAnalogSignalControllerBoxAttributesMessage decode(FriendlyByteBuf in) {
    var blockPos = in.readBlockPos();
    var signalAspectTriggerSignals =
        in.readMap(buf -> buf.readEnum(SignalAspect.class), FriendlyByteBuf::readBitSet);
    return new SetAnalogSignalControllerBoxAttributesMessage(blockPos, signalAspectTriggerSignals);
  }

  public boolean handle(Supplier<NetworkEvent.Context> context) {
    var level = context.get().getSender().getLevel();
    level
        .getBlockEntity(this.blockPos, RailcraftBlockEntityTypes.ANALOG_SIGNAL_CONTROLLER_BOX.get())
        .ifPresent(signalBox -> {
          signalBox.setSignalAspectTriggerSignals(this.signalAspectTriggerSignals);
          signalBox.setChanged();
        });
    return true;
  }
}
