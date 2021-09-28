package mods.railcraft.world.level.block.entity.signal;

import java.util.BitSet;
import mods.railcraft.api.signals.SignalAspect;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.Constants;

/**
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public abstract class ActionSignalBoxBlockEntity extends SecuredSignalBoxBlockEntity implements IAspectResponder {

  private BitSet powerOnAspects = new BitSet(SignalAspect.values().length);

  public ActionSignalBoxBlockEntity(TileEntityType<?> type) {
    super(type);
    setActionState(SignalAspect.GREEN, true);
  }

  @Override
  public boolean doesActionOnAspect(SignalAspect aspect) {
    return powerOnAspects.get(aspect.ordinal());
  }

  protected final void setActionState(SignalAspect aspect, boolean trigger) {
    powerOnAspects.set(aspect.ordinal(), trigger);
  }

  @Override
  public void doActionOnAspect(SignalAspect aspect, boolean trigger) {
    setActionState(aspect, trigger);
  }

  @Override
  public CompoundNBT save(CompoundNBT data) {
    super.save(data);
    data.putByteArray("powerOnAspects", powerOnAspects.toByteArray());
    return data;
  }

  @Override
  public void load(BlockState state, CompoundNBT data) {
    super.load(state, data);
    if (data.contains("powerOnAspects", Constants.NBT.TAG_BYTE_ARRAY)) {
      powerOnAspects = BitSet.valueOf(data.getByteArray("powerOnAspects"));
    }
  }

  @Override
  public void writeSyncData(PacketBuffer data) {
    super.writeSyncData(data);
    writeActionInfo(data);
  }

  @Override
  public void readSyncData(PacketBuffer data) {
    super.readSyncData(data);
    powerOnAspects = BitSet.valueOf(data.readByteArray(data.readVarInt()));
  }

  private void writeActionInfo(PacketBuffer data) {
    byte[] bytes = powerOnAspects.toByteArray();
    data.writeVarInt(bytes.length);
    data.writeByteArray(bytes);
  }
}
