package mods.railcraft.client.gui.screen.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Railcraft;
import mods.railcraft.Translations;
import mods.railcraft.client.gui.screen.inventory.widget.AnalogGaugeRenderer;
import mods.railcraft.world.inventory.SteamTurbineMenu;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class SteamTurbineScreen extends RailcraftMenuScreen<SteamTurbineMenu> {

    private static final ResourceLocation WIDGETS_TEXTURE_LOCATION =
            Railcraft.rl("textures/gui/container/steam_turbine.png");

    public SteamTurbineScreen(SteamTurbineMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.registerWidgetRenderer(new AnalogGaugeRenderer(menu.getTurbineWidget()));
        this.registerWidgetRenderer(new AnalogGaugeRenderer(menu.getChargeWidget()));

        this.imageHeight = SteamTurbineMenu.GUI_HEIGHT;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    public ResourceLocation getWidgetsTexture() {
        return WIDGETS_TEXTURE_LOCATION;
    }

    @Override
    protected void renderLabels(@NotNull PoseStack poseStack, int mouseX, int mouseY) {
        super.renderLabels(poseStack, mouseX, mouseY);
        GuiComponent.drawString(poseStack, this.font,
                Component.translatable(Translations.Screen.STEAM_TURBINE_ROTOR), 20, 29, 0x404040);
        GuiComponent.drawString(poseStack, this.font,
                Component.translatable(Translations.Screen.STEAM_TURBINE_OUTPUT), 93, 24, 0x404040);
        GuiComponent.drawString(poseStack, this.font,
                Component.translatable(Translations.Screen.STEAM_TURBINE_USAGE), 95, 43, 0x404040);
    }
}
