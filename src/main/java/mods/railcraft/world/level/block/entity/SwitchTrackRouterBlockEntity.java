package mods.railcraft.world.level.block.entity;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Either;
import mods.railcraft.api.carts.RollingStock;
import mods.railcraft.api.track.SwitchActuator;
import mods.railcraft.util.PlayerUtil;
import mods.railcraft.util.container.AdvancedContainer;
import mods.railcraft.util.routing.RouterBlockEntity;
import mods.railcraft.util.routing.RoutingLogic;
import mods.railcraft.util.routing.RoutingLogicException;
import mods.railcraft.world.inventory.SwitchTrackRouterMenu;
import mods.railcraft.world.level.block.track.actuator.SwitchTrackActuatorBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SwitchTrackRouterBlockEntity extends LockableSwitchTrackActuatorBlockEntity
        implements RouterBlockEntity, SwitchActuator {

    private final AdvancedContainer container;
    @Nullable
    private Either<RoutingLogic, RoutingLogicException> logic;
    private RouterBlockEntity.Railway railway = RouterBlockEntity.Railway.PUBLIC;
    private boolean powered;

    public SwitchTrackRouterBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RailcraftBlockEntityTypes.SWITCH_TRACK_ROUTER.get(), blockPos, blockState);
        this.container = new AdvancedContainer(1).listener((Container) this);
    }

    @Override
    public void neighborChanged() {
        this.powered = this.level.hasNeighborSignal(this.getBlockPos());
        this.setChanged();
    }

    @Override
    public RouterBlockEntity.Railway getRailway() {
        return this.railway;
    }

    @Override
    public void setRailway(@Nullable GameProfile gameProfile) {
        this.railway = gameProfile == null ? RouterBlockEntity.Railway.PUBLIC : RouterBlockEntity.Railway.PRIVATE;
        if (!this.isLocked()) {
            this.setOwner(gameProfile);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("container", this.container.createTag());
        tag.putString("railway", this.railway.getSerializedName());
        tag.putBoolean("powered", this.powered);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.container.fromTag(tag.getList("container", Tag.TAG_COMPOUND));
        this.railway = RouterBlockEntity.Railway.fromName(tag.getString("railway"));
        this.powered = tag.getBoolean("powered");
    }

    @Override
    public void writeToBuf(FriendlyByteBuf data) {
        super.writeToBuf(data);
        data.writeEnum(this.railway);
        data.writeBoolean(this.powered);
    }

    @Override
    public void readFromBuf(FriendlyByteBuf data) {
        super.readFromBuf(data);
        this.railway = data.readEnum(RouterBlockEntity.Railway.class);
        this.powered = data.readBoolean();
    }

    @Override
    public boolean isPowered() {
        return this.powered;
    }

    @Override
    public Optional<Either<RoutingLogic, RoutingLogicException>> logicResult() {
        this.refreshLogic();
        return Optional.ofNullable(this.logic);
    }

    @Override
    public void resetLogic() {
        this.logic = null;
    }

    private void refreshLogic() {
        if (this.logic == null && !this.container.getItem(0).isEmpty()) {
            var item = this.container.getItem(0);
            if (item.getTag() != null && item.getTag().contains("pages")) {
                var content = this.loadPages(item.getTag());
                try {
                    this.logic = Either.left(RoutingLogic.parseTable(content));
                } catch (RoutingLogicException e) {
                    this.logic = Either.right(e);
                }
            }
        }
    }

    @Override
    public boolean shouldSwitch(RollingStock rollingStock) {
        var shouldSwitch = this.logic()
                .map(logic -> logic.matches(this, rollingStock))
                .orElse(false);
        if (this.railway == RouterBlockEntity.Railway.PRIVATE) {
            shouldSwitch = rollingStock.owner()
                    .filter(owner -> PlayerUtil.isSamePlayer(owner, this.getOwnerOrThrow()))
                    .isPresent();
        }
        SwitchTrackActuatorBlock.setSwitched(
                this.getBlockState(), this.level, this.getBlockPos(), shouldSwitch);
        return shouldSwitch;
    }

    @Override
    public Container container() {
        return this.container;
    }

    @Override
    public boolean stillValid(Player player) {
        return isStillValid(player);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new SwitchTrackRouterMenu(id, inventory, this);
    }
}
