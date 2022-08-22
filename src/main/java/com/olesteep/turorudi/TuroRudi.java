package com.olesteep.turorudi;

import com.olesteep.turorudi.block.*;
import com.olesteep.turorudi.fluid.TuroFluids;
import com.olesteep.turorudi.item.*;
import com.olesteep.turorudi.world.feature.foliageplacers.TuroFoliagePlacerType;
import com.olesteep.turorudi.world.feature.treedecorators.TuroTreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("turorudi")
public class TuroRudi {
    public static final String MOD_ID = "turorudi";

    public TuroRudi() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Blocks
        CherryTree.register(eventBus);
        OrangeTree.register(eventBus);
        PalmTree.register(eventBus);
        TuroBlocks.register(eventBus);

        // Bushes
        ApricotBush.register(eventBus);
        BlueBerryBush.register(eventBus);
        LemonBush.register(eventBus);
        LimeBush.register(eventBus);

        //Decorators
        TuroTreeDecoratorType.register(eventBus);

        //Fluids
        TuroFluids.register(eventBus);

        //Foliage placers
        TuroFoliagePlacerType.register(eventBus);

        //Items
        TuroItems.register(eventBus);

        //TuroRudies
        Alexandrov.register(eventBus);
        Corenovka.register(eventBus);
        Pottyos.register(eventBus);
        Preobrajenskiy.register(eventBus);
        Svitlogorie.register(eventBus);
        Vkusnoteevo.register(eventBus);
        Vologosha.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}

