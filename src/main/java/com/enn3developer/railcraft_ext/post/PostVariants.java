package com.enn3developer.railcraft_ext.post;

import net.minecraft.util.StringRepresentable;

public enum PostVariants implements StringRepresentable {
    WOOD("wood"),
    STONE("stone");

    private final String name;

    PostVariants(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
