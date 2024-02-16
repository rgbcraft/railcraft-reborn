package mods.railcraft.client.gui.screen.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Railcraft;
import mods.railcraft.Translations;
import mods.railcraft.client.gui.screen.IngameWindowScreen;
import mods.railcraft.world.inventory.TrainDispenserMenu;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class TrainDispenserScreen extends RailcraftMenuScreen<TrainDispenserMenu> {

    private static final ResourceLocation WIDGETS_TEXTURE_LOCATION =
            Railcraft.rl("textures/gui/container/train_dispenser.png");

    private final static Component PATTERN =
            Component.translatable(Translations.Screen.PATTERN);
    private final static Component BUFFER =
            Component.translatable(Translations.Screen.ITEM_MANIPULATOR_BUFFER);

    public TrainDispenserScreen(TrainDispenserMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageHeight = 193;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void renderLabels(@NotNull PoseStack poseStack, int mouseX, int mouseY) {
        super.renderLabels(poseStack, mouseX, mouseY);
        GuiComponent.drawString(poseStack, this.font, PATTERN, this.titleLabelX, 18,
                IngameWindowScreen.TEXT_COLOR);
        GuiComponent.drawString(poseStack, this.font, BUFFER, this.titleLabelX, 50,
                IngameWindowScreen.TEXT_COLOR);
    }

    @Override
    public ResourceLocation getWidgetsTexture() {
        return WIDGETS_TEXTURE_LOCATION;
    }
}
