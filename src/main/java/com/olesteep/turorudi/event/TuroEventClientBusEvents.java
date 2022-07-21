package com.olesteep.turorudi.event;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.block.*;
import com.olesteep.turorudi.fluid.TuroFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = TuroRudi.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TuroEventClientBusEvents {

    @SubscribeEvent
    public static void clientSetup(final FMLCommonSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ApricotBush.APRICOT_BUSH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlueBerryBush.BLBERRY_BUSH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(TuroBlocks.COCONUT_BLOCK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(CherryTree.CHERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CherryTree.CHERRY_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(LemonBush.LEMON_BUSH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(OrangeTree.ORANGE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(OrangeTree.ORANGE_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(PalmTree.PALM_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PalmTree.PALM_SAPLING.get(), RenderType.cutout());
    }
}
