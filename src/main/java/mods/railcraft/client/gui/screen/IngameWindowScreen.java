package mods.railcraft.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Railcraft;
import mods.railcraft.client.util.GuiUtil;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class IngameWindowScreen extends Screen {

    public static final ResourceLocation WIDGETS_TEXTURE =
            Railcraft.rl("textures/gui/widgets.png");
    public static final ResourceLocation LARGE_WINDOW_TEXTURE =
            Railcraft.rl("textures/gui/large_window.png");

    public static final int TEXT_COLOR = 0xFF404040;
    public static final int DEFAULT_WINDOW_WIDTH = 176;
    public static final int DEFAULT_WINDOW_HEIGHT = 88;
    public static final int LARGE_WINDOW_HEIGHT = 113;

    protected final int windowWidth;
    protected final int windowHeight;
    protected final ResourceLocation backgroundTexture;

    protected IngameWindowScreen(Component title) {
        this(title, WIDGETS_TEXTURE, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
    }

    protected IngameWindowScreen(Component title, ResourceLocation backgroundTexture,
                                 int windowWidth, int windowHeight) {
        super(title);
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.backgroundTexture = backgroundTexture;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        int centredX = (this.width - this.windowWidth) / 2;
        int centredY = (this.height - this.windowHeight) / 2;
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, this.backgroundTexture);
        this.blit(pPoseStack, centredX, centredY, 0, 0,
                this.windowWidth, this.windowHeight);
        pPoseStack.pushPose();
        pPoseStack.translate(centredX, centredY, 0.0F);
        GuiUtil.drawCenteredString(pPoseStack, this.font, this.title, this.windowWidth, this.font.lineHeight);
        this.renderContent(pPoseStack, pMouseX, pMouseY, pPartialTick);
        pPoseStack.popPose();
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    protected void renderContent(PoseStack pPoseStack, int mouseX, int mouseY,
                                 float partialTicks) {
    }


    @Override
    public void tick() {
        super.tick();
        if (this.minecraft != null && this.minecraft.player != null && (!this.minecraft.player.isAlive() || this.minecraft.player.isDeadOrDying())) {
            this.onClose();
        }
    }
}
