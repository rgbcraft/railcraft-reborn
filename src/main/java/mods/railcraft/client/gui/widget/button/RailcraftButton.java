package mods.railcraft.client.gui.widget.button;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mods.railcraft.Railcraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class RailcraftButton extends Button {

    private static final ResourceLocation WIDGETS_LOCATION =
            Railcraft.rl("textures/gui/widgets.png");

    private TexturePosition texturePosition;

    protected RailcraftButton(AbstractBuilder<?, ?> builder) {
        super(builder.x, builder.y, builder.width, builder.height, builder.message, builder.onPress);
        this.texturePosition = builder.texturePosition;
    }

    public void setTexturePosition(TexturePosition texturePosition) {
        this.texturePosition = texturePosition;
    }

    protected int getYImage(boolean hovered) {
        if (!this.active) {
            return 0;
        }
        return hovered ? 2 : 1;
    }


    @Override
    public void renderButton(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        var font = Minecraft.getInstance().font;
        RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        int i = this.getYImage(this.isHoveredOrFocused());
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();

        int xOffset = this.texturePosition.x();
        int yOffset = this.texturePosition.y();
        int h = this.texturePosition.height();
        int w = this.texturePosition.width();
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);
        this.blit(poseStack, this.x, this.y, xOffset, yOffset + i * h, this.width / 2, h);
        this.blit(poseStack, this.x + this.width / 2, this.y,
                xOffset + w - this.width / 2,
                yOffset + i * h, this.width / 2, h);
        int j = getFGColor();
        GuiComponent.drawCenteredString(poseStack, font, this.getMessage(), this.x + this.width / 2,
                this.y + (this.height - 8) / 2, j | Mth.ceil(this.alpha * 255.0F) << 24);
    }

    public static Builder builder(Component message, OnPress onPress,
                                  TexturePosition texturePosition) {
        return new Builder(message, onPress, texturePosition);
    }

    public static Builder builder(String translationKey, OnPress onPress,
                                  TexturePosition texturePosition) {
        return new Builder(Component.translatable(translationKey), onPress, texturePosition);
    }

    public static class Builder extends AbstractBuilder<Builder, RailcraftButton> {

        public Builder(Component message, OnPress onPress, TexturePosition texturePosition) {
            super(RailcraftButton::new, message, onPress, texturePosition);
        }
    }

    protected static abstract class AbstractBuilder<SELF extends AbstractBuilder<SELF, T>,
            T extends RailcraftButton> {

        private final Function<SELF, T> factory;

        private final Component message;
        private final OnPress onPress;
        private final TexturePosition texturePosition;

        //        @Nullable
//        private Tooltip tooltip;
        private int x;
        private int y;
        private int width = 150;
        private int height = 20;

        public AbstractBuilder(Function<SELF, T> factory, Component message, OnPress onPress,
                               TexturePosition texturePosition) {
            this.factory = factory;
            this.message = message;
            this.onPress = onPress;
            this.texturePosition = texturePosition;
        }

        public SELF pos(int x, int y) {
            this.x = x;
            this.y = y;
            return this.self();
        }

        public SELF width(int width) {
            this.width = width;
            return this.self();
        }

        public SELF size(int width, int height) {
            this.width = width;
            this.height = height;
            return this.self();
        }

        public SELF bounds(int x, int y, int width, int height) {
            return this.pos(x, y).size(width, height);
        }

//        public SELF tooltip(@Nullable Tooltip tooltip) {
//            this.tooltip = tooltip;
//            return this.self();
//        }

        public T build() {
            var button = this.factory.apply(this.self());
//            button.setTooltip(this.tooltip);
            return button;
        }

        @SuppressWarnings("unchecked")
        protected SELF self() {
            return (SELF) this;
        }
    }
}
