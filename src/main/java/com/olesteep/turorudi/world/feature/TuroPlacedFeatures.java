package com.olesteep.turorudi.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class TuroPlacedFeatures {
    public static final Holder<PlacedFeature> CHERRY_PLACED = PlacementUtils.register("cherry_placed",
            TuroConfiguredFeatures.CHERRY_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(0, 0.05f, 1)));

    public static final Holder<PlacedFeature> LEMON_BUSH_PLACED = PlacementUtils.register("lemon_bush_placed",
            TuroConfiguredFeatures.LEMON_BUSH, RarityFilter.onAverageOnceEvery(16),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
}