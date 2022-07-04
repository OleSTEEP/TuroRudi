package com.olesteep.turorudi;

import com.olesteep.turorudi.block.TuroBlocks;
import com.olesteep.turorudi.fluid.TuroFluids;
import com.olesteep.turorudi.item.Alexandrov;
import com.olesteep.turorudi.item.Svitlogorie;
import com.olesteep.turorudi.item.TuroItems;
import com.olesteep.turorudi.item.Vkusnoteevo;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("turorudi")
public class TuroRudi {
    public static final String MOD_ID = "turorudi";

    private static final Logger LOGGER = LogUtils.getLogger();

    public TuroRudi() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        TuroBlocks.register(eventBus);
        TuroFluids.register(eventBus);
        TuroItems.register(eventBus);
        Alexandrov.register(eventBus);
        Svitlogorie.register(eventBus);
        Vkusnoteevo.register(eventBus);

        eventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLCommonSetupEvent event) {

        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TuroFluids.MILK_COND_FLOWING.get(), RenderType.translucent());

    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("PREINIT");
    }
}

