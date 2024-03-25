package com.enn3developer.railcraft_ext;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class NUtils {
    public static boolean isAirOrLike(BlockState state) {
        return state.isAir() || state.is(Blocks.SNOW) || state.is(Blocks.WATER);
    }
}
