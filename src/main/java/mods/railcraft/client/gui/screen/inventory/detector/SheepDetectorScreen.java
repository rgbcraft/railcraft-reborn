package mods.railcraft.client.gui.screen.inventory.detector;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Railcraft;
import mods.railcraft.world.inventory.detector.SheepDetectorMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SheepDetectorScreen extends AbstractContainerScreen<SheepDetectorMenu> {
    private static final ResourceLocation BACKGROUND_TEXTURE =
            Railcraft.rl("textures/gui/container/single_slot.png");

    public SheepDetectorScreen(SheepDetectorMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageHeight = 140;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        this.renderBackground(poseStack);
        final int x = this.leftPos;
        final int y = this.topPos;
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        this.blit(poseStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }
}
