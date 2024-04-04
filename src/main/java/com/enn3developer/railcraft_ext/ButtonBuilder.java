package com.enn3developer.railcraft_ext;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class ButtonBuilder {
    private int x;
    private int y;
    private int height;
    private int width;
    private Component message;
    private Button.OnPress onPress;
    private Button.OnTooltip onTooltip = (button, poseStack, i, i1) -> {
    };

    public ButtonBuilder(Component message, Button.OnPress onPress) {
        this.message = message;
        this.onPress = onPress;
    }

    public static ButtonBuilder builder(Component message, Button.OnPress onPress) {
        return new ButtonBuilder(message, onPress);
    }

    public ButtonBuilder bounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        return this;
    }

    public ButtonBuilder onTooltip(Button.OnTooltip onTooltip) {
        this.onTooltip = onTooltip;
        return this;
    }

    public Button build() {
        return new Button(x, y, width, height, message, onPress);
    }
}
