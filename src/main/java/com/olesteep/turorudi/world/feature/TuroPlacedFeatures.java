package com.olesteep.turorudi.world.feature;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class TuroPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, TuroRudi.MOD_ID);

    public static final RegistryObject<PlacedFeature> APRICOT_BUSH_PLACED = PLACED_FEATURES.register("apricot_bush_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) TuroConfiguredFeatures.PATCH_APRICOT_BUSH, List.of(RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> BLBERRY_BUSH_PLACED = PLACED_FEATURES.register("blueberry_bush_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) TuroConfiguredFeatures.PATCH_BLBERRY_BUSH, List.of(RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> CHERRY_PLACED = PLACED_FEATURES.register("cherry_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) TuroConfiguredFeatures.CHERRY_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.025f, 1))));
    public static final RegistryObject<PlacedFeature> LEMON_BUSH_PLACED = PLACED_FEATURES.register("lemon_bush_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) TuroConfiguredFeatures.PATCH_LEMON_BUSH, List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> ORANGE_PLACED = PLACED_FEATURES.register("orange_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) TuroConfiguredFeatures.ORANGE_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.025f, 1))));
    public static final RegistryObject<PlacedFeature> PALM_PLACED = PLACED_FEATURES.register("palm_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) TuroConfiguredFeatures.PALM_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.5f, 1))));

    public static void register(IEventBus eventBus) {PLACED_FEATURES.register(eventBus);}
}