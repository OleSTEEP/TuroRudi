package com.olesteep.turorudi.world.gen;

import com.olesteep.turorudi.world.feature.TuroPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TuroBushGeneration {
    public static void generateBushes(final BiomeLoadingEvent event) {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(event.getName()));
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.COLD) & types.contains(BiomeDictionary.Type.FOREST)) {
            List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(TuroPlacedFeatures.BLBERRY_BUSH_PLACED);
        }

        if(types.contains(BiomeDictionary.Type.HOT)) {
            List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(TuroPlacedFeatures.LEMON_BUSH_PLACED);
            base.add(TuroPlacedFeatures.APRICOT_BUSH_PLACED);
        }
    }
}