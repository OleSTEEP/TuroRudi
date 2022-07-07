package com.olesteep.turorudi.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TuroPlacedFeatures {
    public static final Holder<PlacedFeature> CHERRY_PLACED = PlacementUtils.register("cherry_placed",
            TuroConfiguredFeature.CHERRY_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(0, 0.05f, 1)));
}