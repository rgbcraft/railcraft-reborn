package mods.railcraft.client.gui.screen.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Railcraft;
import mods.railcraft.client.gui.screen.inventory.widget.FluidGaugeRenderer;
import mods.railcraft.world.inventory.SteamOvenMenu;
import mods.railcraft.world.module.SteamOvenModule;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class SteamOvenScreen extends RailcraftMenuScreen<SteamOvenMenu> {

    private static final ResourceLocation WIDGETS_TEXTURE =
            Railcraft.rl("textures/gui/container/steam_oven.png");
    private final SteamOvenModule steamOvenModule;

    public SteamOvenScreen(SteamOvenMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.steamOvenModule = menu.getSteamOven().getSteamOvenModule();
        this.registerWidgetRenderer(new FluidGaugeRenderer(menu.getSteamFluidGauge()));
    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        super.renderBg(poseStack, partialTicks, mouseX, mouseY);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        if (this.steamOvenModule.getProgress() > 0) {
            int scale = (int) (this.steamOvenModule.getProgressPercent() * 49);
            RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            RenderSystem.setShaderTexture(0, WIDGETS_TEXTURE);
            this.blit(poseStack, x + 65, y + 18 + 49 - scale, 176, 47 + 49 - scale, 23, scale + 1);
        }
    }

    @Override
    public ResourceLocation getWidgetsTexture() {
        return WIDGETS_TEXTURE;
    }
}
