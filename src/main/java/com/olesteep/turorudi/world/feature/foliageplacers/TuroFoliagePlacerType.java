package com.olesteep.turorudi.world.feature.foliageplacers;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TuroFoliagePlacerType {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, TuroRudi.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<?>> PALM_FOLIAGE_PLACER = FOLIAGE.register("palm_foliage", () -> new FoliagePlacerType(PalmFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE.register(eventBus);
    }
}
