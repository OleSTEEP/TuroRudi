package com.olesteep.turorudi.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class TuroPlacedFeatures {
    public static final Holder<PlacedFeature> APRICOT_BUSH_PLACED = PlacementUtils.register("apricot_bush_placed", TuroConfiguredFeatures.PATCH_APRICOT_BUSH, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BLBERRY_BUSH_PLACED = PlacementUtils.register("blueberry_bush_placed", TuroConfiguredFeatures.PATCH_BLBERRY_BUSH, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> CHERRY_PLACED = PlacementUtils.register("cherry_placed", TuroConfiguredFeatures.CHERRY_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.015f, 1)));
    public static final Holder<PlacedFeature> LEMON_BUSH_PLACED = PlacementUtils.register("lemon_bush_placed", TuroConfiguredFeatures.PATCH_LEMON_BUSH, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> ORANGE_PLACED = PlacementUtils.register("orange_placed", TuroConfiguredFeatures.ORANGE_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.025f, 1)));
    public static final Holder<PlacedFeature> PALM_PLACED = PlacementUtils.register("palm_placed", TuroConfiguredFeatures.PALM_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.5f, 1)));
}