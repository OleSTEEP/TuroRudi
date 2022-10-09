package com.olesteep.turorudi;

import com.olesteep.turorudi.block.*;
import com.olesteep.turorudi.fluid.TuroFluidCondensedMilkHolder;
import com.olesteep.turorudi.item.*;
import com.olesteep.turorudi.villager.TuroVillagers;
import com.olesteep.turorudi.world.biomemods.TuroBiomeModifiers;
import com.olesteep.turorudi.world.feature.TuroPlacedFeatures;
import com.olesteep.turorudi.world.feature.foliageplacers.TuroFoliagePlacerType;
import com.olesteep.turorudi.world.feature.treedecorators.TuroTreeDecoratorType;
import com.olesteep.turorudi.world.village.TuroVillagePools;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("turorudi")
public class TuroRudi {
    public static final String MOD_ID = "turorudi";

    public TuroRudi() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Biome modifiers
        TuroBiomeModifiers.register((eventBus));

        //Blocks
        CherryTree.register(eventBus);
        OrangeTree.register(eventBus);
        PalmTree.register(eventBus);
        TuroBlocks.register(eventBus);

        //Decorators
        TuroTreeDecoratorType.register(eventBus);

        //Fluids
        TuroFluidCondensedMilkHolder.register(eventBus);

        //Foliage placers
        TuroFoliagePlacerType.register(eventBus);

        //Bushes
        ApricotBush.register(eventBus);
        BlueBerryBush.register(eventBus);
        LemonBush.register(eventBus);
        LimeBush.register(eventBus);

        //Items
        TuroItems.register(eventBus);

        //Placed features
        TuroPlacedFeatures.register(eventBus);

        //TuroRudies
        Alexandrov.register(eventBus);
        Corenovka.register(eventBus);
        Pottyos.register(eventBus);
        Preobrajenskiy.register(eventBus);
        Svitlogorie.register(eventBus);
        Vkusnoteevo.register(eventBus);
        Vologosha.register(eventBus);

        //Villagers
        TuroVillagers.register(eventBus);

        eventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(TuroVillagers::registerPOIs);
        TuroVillagePools.init();
    }
}

