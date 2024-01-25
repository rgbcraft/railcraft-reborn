package mods.railcraft.world.module;

import java.util.function.Predicate;
import mods.railcraft.api.container.manipulator.ContainerManipulator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public interface BlockModuleProvider extends ModuleProvider {

  BlockPos blockPos();

  @Override
  default void dropItem(ItemStack itemStack) {
    Containers.dropItemStack(this.getLevel(),
        this.blockPos().getX(),
        this.blockPos().getY(),
        this.blockPos().getZ(),
        itemStack);
  }

  default ContainerManipulator<?> findAdjacentContainers() {
    return ContainerManipulator.findAdjacent(this.getLevel(), this.blockPos());
  }

  default ContainerManipulator<?> findAdjacentContainers(Predicate<BlockEntity> filter) {
    return ContainerManipulator.findAdjacent(this.getLevel(), this.blockPos(), filter);
  }
}
