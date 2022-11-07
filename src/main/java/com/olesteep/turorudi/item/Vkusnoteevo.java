package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Vkusnoteevo {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> VKUSN_VANILLA = ITEMS.register("vkusnoteevo", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> VKUSN_COCOA = ITEMS.register("vkusnoteevo_cocoa", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COCOA)));
    public static final RegistryObject<Item> VKUSN_COND = ITEMS.register("vkusnoteevo_condensed", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COND)));

    public static final RegistryObject<Item> PACKAGE_VKUSN = ITEMS.register("package_vkusnoteevo", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}