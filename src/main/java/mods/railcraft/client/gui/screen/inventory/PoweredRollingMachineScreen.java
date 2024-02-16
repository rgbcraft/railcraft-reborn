package mods.railcraft.client.gui.screen.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Railcraft;
import mods.railcraft.client.gui.screen.inventory.widget.AnalogGaugeRenderer;
import mods.railcraft.world.inventory.PoweredRollingMachineMenu;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class PoweredRollingMachineScreen extends RailcraftMenuScreen<PoweredRollingMachineMenu> {

    private static final ResourceLocation BACKGROUND_TEXTURE =
            Railcraft.rl("textures/gui/container/powered_rolling_machine.png");

    public PoweredRollingMachineScreen(PoweredRollingMachineMenu menu, Inventory inventory,
                                       Component title) {
        super(menu, inventory, title);
        this.registerWidgetRenderer(new AnalogGaugeRenderer(menu.getEnergyWidget()));
    }

    @Override
    public ResourceLocation getWidgetsTexture() {
        return BACKGROUND_TEXTURE;
    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        super.renderBg(poseStack, partialTicks, mouseX, mouseY);
        float progress = this.menu.rollingProgress();
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        this.blit(poseStack, this.leftPos + 89, this.topPos + 36, 176, 0,
                Math.round(24.00F * progress), 12);
    }
}
