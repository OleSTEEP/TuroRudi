package com.olesteep.turorudi.event;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.item.TuroItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TuroRudi.MOD_ID)
public class FurnaceEvent {

    @SubscribeEvent
    public static void onSmelt(PlayerEvent.ItemSmeltedEvent event) {

        if(event.getSmelting().getItem().equals(new ItemStack(TuroItems.MILK_FAT.get()).getItem())) {
            event.getEntity().addItem(new ItemStack(Items.BUCKET));

        }
    }
}
