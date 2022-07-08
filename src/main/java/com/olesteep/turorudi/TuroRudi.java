package com.olesteep.turorudi;

import com.olesteep.turorudi.block.CherryTree;
import com.olesteep.turorudi.block.LemonBush;
import com.olesteep.turorudi.block.TuroBlocks;
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

        CherryTree.register(eventBus);
        LemonBush.register(eventBus);
        TuroBlocks.register(eventBus);
        TuroFluids.register(eventBus);
        TuroItems.register(eventBus);
        Alexandrov.register(eventBus);
        Svitlogorie.register(eventBus);
        Vkusnoteevo.register(eventBus);
        Vologosha.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLCommonSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CherryTree.CHERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CherryTree.CHERRY_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(LemonBush.LEMON_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LemonBush.POTTED_LEMON_BUSH.get(), RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(LemonBush.LEMON_BUSH.getId(), LemonBush.POTTED_LEMON_BUSH);
        });
    }
}

