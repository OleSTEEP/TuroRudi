package com.olesteep.turorudi.villager;

import com.google.common.collect.ImmutableSet;
import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.block.TuroBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class TuroVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, TuroRudi.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, TuroRudi.MOD_ID);

    public static final RegistryObject<PoiType> TUROMAKER_POI = POI_TYPES.register("turomaker_poi", () -> new PoiType("turomaker_poi", PoiType.getBlockStates(TuroBlocks.TURO_BLOCK.get()), 1, 1));

    public static final RegistryObject<VillagerProfession> TUROMAKER = VILLAGER_PROFESSIONS.register("turomaker", () -> new VillagerProfession("turomaker", TUROMAKER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, TUROMAKER_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}