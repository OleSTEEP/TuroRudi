package com.olesteep.turorudi;

import com.olesteep.turorudi.block.ModBlocks;
import com.olesteep.turorudi.fluid.ModFluids;
import com.olesteep.turorudi.item.Alexandrovs;
import com.olesteep.turorudi.item.Svitlogories;
import com.olesteep.turorudi.item.ModItems;
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

        ModBlocks.register(eventBus);
        ModFluids.register(eventBus);
        ModItems.register(eventBus);
        Alexandrovs.register(eventBus);
        Svitlogories.register(eventBus);
        Vkusnoteevo.register(eventBus);

        eventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLCommonSetupEvent event) {

        ItemBlockRenderTypes.setRenderLayer(ModFluids.MILK_COND_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.MILK_COND_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.MILK_COND_FLOWING.get(), RenderType.translucent());

    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("PREINIT");
    }
}

