package mods.railcraft.client.gui.screen.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Translations;
import mods.railcraft.client.gui.screen.IngameWindowScreen;
import mods.railcraft.client.gui.widget.button.ButtonTexture;
import mods.railcraft.client.gui.widget.button.MultiButton;
import mods.railcraft.network.NetworkChannel;
import mods.railcraft.network.play.SetMaintenanceMinecartAttributesMessage;
import mods.railcraft.world.entity.vehicle.MaintenanceMinecart;
import mods.railcraft.world.entity.vehicle.MaintenancePatternMinecart;
import mods.railcraft.world.inventory.RailcraftMenu;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public abstract class MaintenanceMinecartScreen<T extends RailcraftMenu> extends RailcraftMenuScreen<T> {

    protected static final Component PATTERN = Component.translatable(Translations.Screen.PATTERN);
    protected static final Component STOCK = Component.translatable(Translations.Screen.STOCK);
    private static final int REFRESH_INTERVAL_TICKS = 20;
    private final MaintenancePatternMinecart cart;
    private MultiButton<MaintenanceMinecart.Mode> mode;
    private int refreshTimer;

    protected MaintenanceMinecartScreen(T menu, Inventory inventory, Component title,
                                        MaintenancePatternMinecart cart) {
        super(menu, inventory, title);
        this.cart = cart;
    }

    @Override
    protected void init() {
        super.init();
        var centreX = (this.width - this.getXSize()) / 2;
        var centreY = (this.height - this.getYSize()) / 2;

        this.mode = this.addRenderableWidget(
                MultiButton
                        .builder(ButtonTexture.SMALL_BUTTON, this.cart.mode())
                        .bounds(centreX + 120, centreY + getYSize() - 100, 40, 16)
                        .stateCallback(this::setMaintenanceMode)
//                        .tooltipFactory(this::createLockTooltip)
                        .build());
        this.updateButtons();
    }

//    private Optional<Tooltip> createLockTooltip(MaintenanceMinecart.Mode mode) {
//        return Optional.of(Tooltip.create(Component.translatable(mode.getTipsKey())));
//    }

    @Override
    public void containerTick() {
        super.containerTick();
        if (this.refreshTimer++ >= REFRESH_INTERVAL_TICKS) {
            this.updateButtons();
        }
    }

    private void setMaintenanceMode(MaintenanceMinecart.Mode mode) {
        if (mode != this.cart.mode()) {
            this.cart.setMode(mode);
            this.updateButtons();
            NetworkChannel.GAME.sendToServer(
                    new SetMaintenanceMinecartAttributesMessage(this.cart.getId(), mode));
        }
    }

    private void updateButtons() {
        this.mode.setState(cart.mode());
    }

    @Override
    protected void renderLabels(@NotNull PoseStack poseStack, int mouseX, int mouseY) {
        super.renderLabels(poseStack, mouseX, mouseY);
        GuiComponent.drawString(poseStack, this.font, PATTERN, 38, 30, IngameWindowScreen.TEXT_COLOR);
        GuiComponent.drawString(poseStack, this.font, STOCK, 125, 25, IngameWindowScreen.TEXT_COLOR);
    }
}
