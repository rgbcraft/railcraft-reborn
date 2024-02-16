package mods.railcraft.client.gui.screen.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Railcraft;
import mods.railcraft.Translations;
import mods.railcraft.client.gui.screen.IngameWindowScreen;
import mods.railcraft.client.util.GuiUtil;
import mods.railcraft.world.inventory.TrackUndercutterMenu;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class TrackUndercutterScreen extends MaintenanceMinecartScreen<TrackUndercutterMenu> {

    private static final ResourceLocation WIDGETS_TEXTURE_LOCATION =
            Railcraft.rl("textures/gui/container/track_undercutter.png");

    private static final Component UNDER = Component.translatable(Translations.Screen.UNDER);
    private static final Component SIDES = Component.translatable(Translations.Screen.SIDES);

    public TrackUndercutterScreen(TrackUndercutterMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, menu.getTrackUndercutter());
        this.imageHeight = 205;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void renderLabels(@NotNull PoseStack poseStack, int mouseX, int mouseY) {
        GuiComponent.drawString(poseStack, this.font, this.title, this.titleLabelX, this.titleLabelY,
                4210752);
        GuiComponent.drawString(poseStack, this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY,
                4210752);
        GuiComponent.drawString(poseStack, this.font, PATTERN, 8, 23, IngameWindowScreen.TEXT_COLOR);
        GuiComponent.drawString(poseStack, this.font, STOCK, 125, 21, IngameWindowScreen.TEXT_COLOR);
        GuiUtil.drawCenteredString(poseStack, this.font, UNDER, imageWidth, 23);
        GuiUtil.drawCenteredString(poseStack, this.font, SIDES, imageWidth, 65);
    }

    @Override
    public ResourceLocation getWidgetsTexture() {
        return WIDGETS_TEXTURE_LOCATION;
    }
}
