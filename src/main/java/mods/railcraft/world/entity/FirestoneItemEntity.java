package mods.railcraft.world.entity;

import mods.railcraft.util.LevelUtil;
import mods.railcraft.world.item.CrackedFirestoneItem;
import mods.railcraft.world.item.FirestoneItem;
import mods.railcraft.world.level.block.RailcraftBlocks;
import mods.railcraft.world.level.block.RitualBlock;
import mods.railcraft.world.level.block.entity.RitualBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FirestoneItemEntity extends ItemEntity {

  private int clock;
  private boolean refined;

  public FirestoneItemEntity(EntityType<? extends FirestoneItemEntity> type, Level level) {
    super(type, level);
    this.setExtendedLifetime();
    this.setDeltaMovement(this.random.nextDouble() * 0.2D - 0.1D, 0.2D,
        this.random.nextDouble() * 0.2D - 0.1D);
  }

  public FirestoneItemEntity(Level level, Vec3 position, ItemStack itemStack) {
    this(RailcraftEntityTypes.FIRESTONE.get(), level);
    this.setPos(position.x, position.y, position.z);
    this.setItem(itemStack);
    this.lifespan = itemStack.getEntityLifespan(level);
  }

  @Override
  public void tick() {
    super.tick();
    if (this.getLevel().isClientSide()) {
      return;
    }
    if (++this.clock % 4 == 0
        && this.getItem().getItem() instanceof FirestoneItem item
        && item.spawnsFire()
        && this.getLevel().getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
      FirestoneItem.trySpawnFire(this.getLevel(), this.blockPosition(), getItem(), this.getOwner());
    }
  }

  @Override
  public void lavaHurt() {
    if (!this.refined || !this.isAlive() || this.getLevel().isClientSide()) {
      return;
    }
    var firestoneBlock = RailcraftBlocks.RITUAL.get().defaultBlockState();
    var surface = this.blockPosition();
    if (!this.getLevel().getFluidState(surface).is(FluidTags.LAVA)
        && !this.getLevel().getFluidState(surface.above()).is(FluidTags.LAVA)) {
      return;
    }

    for (int i = 0; i < 10; i++) {
      surface = surface.above();
      if (!this.getLevel().getBlockState(surface).isAir()
          || !this.getLevel().getFluidState(surface.below()).is(FluidTags.LAVA)) {
        continue;
      }

      var cracked = getItem().getItem() instanceof CrackedFirestoneItem;
      if (LevelUtil.setBlockState(this.getLevel(), surface,
          firestoneBlock.setValue(RitualBlock.CRACKED, cracked), this.getOwner())) {
        var blockEntity = this.getLevel().getBlockEntity(surface);
        if (blockEntity instanceof RitualBlockEntity fireEntity) {
          var firestone = getItem();
          fireEntity.setCharge(firestone.getMaxDamage() - firestone.getDamageValue());
          if (firestone.hasCustomHoverName())
            fireEntity.setItemName(firestone.getDisplayName());
          this.kill();
          return;
        }
      }
    }
  }

  public boolean isRefined() {
    return this.refined;
  }

  public void setRefined(boolean refined) {
    this.refined = refined;
  }

  @Override
  public void addAdditionalSaveData(CompoundTag compound) {
    super.addAdditionalSaveData(compound);
    compound.putBoolean("refined", this.refined);
  }

  @Override
  public void readAdditionalSaveData(CompoundTag compound) {
    super.readAdditionalSaveData(compound);
    this.refined = compound.getBoolean("refined");
  }
}
