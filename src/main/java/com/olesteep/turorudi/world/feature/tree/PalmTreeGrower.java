package com.olesteep.turorudi.world.feature.tree;

import com.olesteep.turorudi.world.feature.TuroConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class PalmTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull Random random, boolean p_204308_) {
        float probability = 0.5F;

        if (!(random.nextFloat() >= probability)) {
            return TuroConfiguredFeatures.PALM_TREE_COCO;
        }
        else {
            return TuroConfiguredFeatures.PALM_TREE_BANANA;
        }
    }
}