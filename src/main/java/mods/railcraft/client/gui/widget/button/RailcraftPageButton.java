package mods.railcraft.client.gui.widget.button;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class RailcraftPageButton extends PageButton {

    private final boolean isForward;
    private final ResourceLocation atlasLocation;

    public RailcraftPageButton(int x, int y, boolean isForward, ResourceLocation atlasLocation,
                               OnPress onPress) {
        super(x, y, isForward, onPress, true);
        this.isForward = isForward;
        this.atlasLocation = atlasLocation;
    }

    @Override
    public void renderButton(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        int i = 0;
        int j = 192;
        if (this.isHoveredOrFocused()) {
            i += 23;
        }

        if (!this.isForward) {
            j += 13;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, this.atlasLocation);
        this.blit(poseStack, this.x, this.y, i, j, 23, 13);
    }
}
