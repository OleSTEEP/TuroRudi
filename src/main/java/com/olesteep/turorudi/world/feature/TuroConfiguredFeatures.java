package com.olesteep.turorudi.world.feature;

import com.olesteep.turorudi.block.CherryTree;
import com.olesteep.turorudi.block.LemonBush;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration.TreeConfigurationBuilder;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.OptionalInt;

public class TuroConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CHERRY_TREE =
            FeatureUtils.register("cherry", Feature.TREE, new TreeConfigurationBuilder(
                            BlockStateProvider.simple(CherryTree.CHERRY_LOG.get()),
                            new FancyTrunkPlacer(3, 11, 0),
                            BlockStateProvider.simple(CherryTree.CHERRY_LEAVES.get()),
                            new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                            new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

    public static final Holder<PlacedFeature> CHERRY_CHECKED = PlacementUtils.register("cherry_checked", CHERRY_TREE,
            PlacementUtils.filteredByBlockSurvival(CherryTree.CHERRY_SAPLING.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CHERRY_SPAWN =
            FeatureUtils.register("cherry_spawn", Feature.RANDOM_SELECTOR,
                            new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(CHERRY_CHECKED,
                                    0.5F)), CHERRY_CHECKED));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> LEMON_BUSH =
            FeatureUtils.register("flower_lemon_bush", Feature.FLOWER,
                    new RandomPatchConfiguration(16, 3, 1, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(LemonBush.LEMON_BUSH.get())))));


}
