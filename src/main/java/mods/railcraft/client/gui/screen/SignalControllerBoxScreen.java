package mods.railcraft.client.gui.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Translations;
import mods.railcraft.api.signal.SignalAspect;
import mods.railcraft.client.util.GuiUtil;
import mods.railcraft.network.NetworkChannel;
import mods.railcraft.network.play.SetSignalControllerBoxAttributesMessage;
import mods.railcraft.world.level.block.entity.signal.SignalControllerBoxBlockEntity;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class SignalControllerBoxScreen extends IngameWindowScreen {

    private final SignalControllerBoxBlockEntity signalBox;

    private SignalAspect defaultAspect;
    private SignalAspect poweredAspect;

    public SignalControllerBoxScreen(SignalControllerBoxBlockEntity signalBox) {
        super(signalBox.getDisplayName());
        this.signalBox = signalBox;
        this.defaultAspect = signalBox.getDefaultAspect();
        this.poweredAspect = signalBox.getPoweredAspect();
    }

    @Override
    public void init() {
        int centredX = (this.width - this.windowWidth) / 2;
        int centredY = (this.height - this.windowHeight) / 2;
        this.addRenderableWidget(new Button(centredX + 10, centredY + 25, 30, 20, Component.literal("<"), button -> this.defaultAspect = this.defaultAspect.previous()));
        this.addRenderableWidget(new Button(centredX + 135, centredY + 25, 30, 20, Component.literal(">"), button -> this.defaultAspect = this.defaultAspect.next()));
        this.addRenderableWidget(new Button(centredX + 10, centredY + 60, 30, 20, Component.literal("<"), button -> this.poweredAspect = this.poweredAspect.previous()));
        this.addRenderableWidget(new Button(centredX + 135, centredY + 60, 30, 20, Component.literal(">"), button -> this.poweredAspect = this.poweredAspect.next()));
    }

    @Override
    protected void renderContent(PoseStack poseStack, int mouseX, int mouseY,
                                 float partialTicks) {
        GuiUtil.drawCenteredString(poseStack, this.font,
                Component.translatable(Translations.Screen.SINGAL_CONTROLLER_BOX_DEFAULT),
                this.windowWidth, 25);
        GuiUtil.drawCenteredString(poseStack, this.font,
                this.defaultAspect.getDisplayName(), this.windowWidth, 35);
        GuiUtil.drawCenteredString(poseStack, this.font,
                Component.translatable(Translations.Screen.SINGAL_CONTROLLER_BOX_POWERED),
                this.windowWidth, 60);
        GuiUtil.drawCenteredString(poseStack, this.font,
                this.poweredAspect.getDisplayName(), this.windowWidth, 70);
    }

    @Override
    public void removed() {
        if (this.minecraft != null && this.minecraft.level != null) {
            this.signalBox.setDefaultAspect(this.defaultAspect);
            this.signalBox.setPoweredAspect(this.poweredAspect);
            NetworkChannel.GAME.sendToServer(
                    new SetSignalControllerBoxAttributesMessage(this.signalBox.getBlockPos(),
                            this.defaultAspect, this.poweredAspect));
        }
    }
}
