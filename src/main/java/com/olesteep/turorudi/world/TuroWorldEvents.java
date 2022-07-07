package com.olesteep.turorudi.world;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.world.gen.TuroTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TuroRudi.MOD_ID)
public class TuroWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        TuroTreeGeneration.generateTrees(event);
    }
}
