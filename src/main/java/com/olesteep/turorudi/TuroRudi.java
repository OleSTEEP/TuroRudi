package com.olesteep.turorudi;

import com.olesteep.turorudi.block.*;
import com.olesteep.turorudi.fluid.TuroFluids;
import com.olesteep.turorudi.item.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
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

        BlueBerryBush.register(eventBus);
        CherryTree.register(eventBus);
        LemonBush.register(eventBus);
        OrangeTree.register(eventBus);
        TuroBlocks.register(eventBus);
        TuroFluids.register(eventBus);
        TuroItems.register(eventBus);
        Alexandrov.register(eventBus);
        Pottyos.register(eventBus);
        Svitlogorie.register(eventBus);
        Vkusnoteevo.register(eventBus);
        Vologosha.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}

