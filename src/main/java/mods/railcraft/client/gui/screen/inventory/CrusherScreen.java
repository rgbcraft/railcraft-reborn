package mods.railcraft.client.gui.screen.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Railcraft;
import mods.railcraft.client.gui.screen.inventory.widget.AnalogGaugeRenderer;
import mods.railcraft.world.inventory.CrusherMenu;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class CrusherScreen extends RailcraftMenuScreen<CrusherMenu> {

    private static final ResourceLocation WIDGETS_TEXTURE =
            Railcraft.rl("textures/gui/container/crusher.png");

    public CrusherScreen(CrusherMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageHeight = 171;
        this.inventoryLabelY = this.imageHeight - 94;

        this.registerWidgetRenderer(new AnalogGaugeRenderer(menu.getEnergyWidget()));
    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        super.renderBg(poseStack, partialTicks, mouseX, mouseY);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        var logic = this.menu.getCrusher().getCrusherModule();
        if (logic.getProgress() > 0) {
            var progressPercent = (int) (logic.getProgressPercent() * 29 + 1);
            RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            RenderSystem.setShaderTexture(0, WIDGETS_TEXTURE);
            this.blit(poseStack, x + 73, y + 20, 176, 0, progressPercent, 38);
        }
    }

    @Override
    public ResourceLocation getWidgetsTexture() {
        return WIDGETS_TEXTURE;
    }
}
