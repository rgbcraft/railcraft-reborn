package mods.railcraft.world.level.block.track.outfitted;

import java.util.function.Supplier;
import mods.railcraft.api.track.TrackType;
import mods.railcraft.util.FunctionalUtil;
import mods.railcraft.world.entity.vehicle.Train;
import mods.railcraft.world.entity.vehicle.locomotive.Locomotive;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class LocomotiveTrackBlock extends PoweredOutfittedTrackBlock {

  public static final Property<Locomotive.Mode> LOCOMOTIVE_MODE =
      EnumProperty.create("locomotive_mode", Locomotive.Mode.class);

  public LocomotiveTrackBlock(Supplier<? extends TrackType> trackType, Properties properties) {
    super(trackType, properties);
  }

  @Override
  protected BlockState buildDefaultState(BlockState blockState) {
    return super.buildDefaultState(blockState)
        .setValue(LOCOMOTIVE_MODE, Locomotive.Mode.SHUTDOWN);
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    super.createBlockStateDefinition(builder);
    builder.add(LOCOMOTIVE_MODE);
  }

  @Override
  public void onMinecartPass(BlockState state, Level level, BlockPos pos, AbstractMinecart cart) {
    super.onMinecartPass(state, level, pos, cart);
    if (isPowered(state)) {
      Train.streamCarts(cart)
          .flatMap(FunctionalUtil.ofType(Locomotive.class))
          .forEach(locomotive -> locomotive.setMode(state.getValue(LOCOMOTIVE_MODE)));
    }
  }

  @Override
  protected boolean crowbarWhack(BlockState state, Level level, BlockPos pos,
      Player player, InteractionHand hand, ItemStack itemStack) {
    return level.setBlockAndUpdate(pos, state.cycle(LOCOMOTIVE_MODE));
  }

  @Override
  public int getPowerPropagation(BlockState blockState, Level level, BlockPos blockPos) {
    return 8;
  }
}