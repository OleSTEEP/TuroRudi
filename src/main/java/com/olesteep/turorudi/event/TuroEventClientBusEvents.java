package com.olesteep.turorudi.event;

import com.olesteep.turorudi.block.BlueBerryBush;
import com.olesteep.turorudi.block.CherryTree;
import com.olesteep.turorudi.block.LemonBush;
import com.olesteep.turorudi.block.OrangeTree;
import com.olesteep.turorudi.fluid.TuroFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class TuroEventClientBusEvents {

    @SubscribeEvent
    private void clientSetup(final FMLCommonSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BlueBerryBush.BLBERRY_BUSH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(CherryTree.CHERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CherryTree.CHERRY_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(LemonBush.LEMON_BUSH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(OrangeTree.ORANGE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(OrangeTree.ORANGE_SAPLING.get(), RenderType.cutout());
    }
}
