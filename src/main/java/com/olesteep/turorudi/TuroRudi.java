package com.olesteep.turorudi;

import com.mojang.logging.LogUtils;
import com.olesteep.turorudi.block.*;
import com.olesteep.turorudi.event.TuroHW;
import com.olesteep.turorudi.fluid.TuroFluids;
import com.olesteep.turorudi.item.*;
import com.olesteep.turorudi.villager.TuroVillagers;
import com.olesteep.turorudi.world.feature.foliageplacers.TuroFoliagePlacerType;
import com.olesteep.turorudi.world.feature.treedecorators.TuroTreeDecoratorType;
import com.olesteep.turorudi.world.village.TuroVillagePools;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mod("turorudi")
public class TuroRudi {
    public static final String MOD_ID = "turorudi";

    public TuroRudi() {
        DateTimeFormatter dtf_day = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter dtf_month = DateTimeFormatter.ofPattern("MM");
        Logger LOGGER = LogUtils.getLogger();
        LocalDateTime now = LocalDateTime.now();

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

        //Halloween stuff
        if(Integer.parseInt(dtf_day.format(now)) >= 20 && Integer.parseInt(dtf_month.format(now)) == 10) {
            LOGGER.info("// It seems like halloween coming...");
            TuroHW.register(eventBus);
        }

        //TuroRudies
        Alexandrov.register(eventBus);
        Corenovka.register(eventBus);
        Pottyos.register(eventBus);
        Preobrajenskiy.register(eventBus);
        Rostagroexport.register(eventBus);
        Svitlogorie.register(eventBus);
        Vkusnoteevo.register(eventBus);
        Vologosha.register(eventBus);

        //Villagers
        TuroVillagers.register(eventBus);

        eventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DateTimeFormatter dtf_day = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter dtf_month = DateTimeFormatter.ofPattern("MM");
        LocalDateTime now = LocalDateTime.now();

        TuroVillagers.registerPOIs();
        TuroVillagePools.init();

        if (Integer.parseInt(dtf_day.format(now)) >= 20 && Integer.parseInt(dtf_month.format(now)) == 10) {
            TuroHW.registerPOIs();
        }
    }
}

