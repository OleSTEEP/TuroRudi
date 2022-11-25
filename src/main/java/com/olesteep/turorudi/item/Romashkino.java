package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Romashkino {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> ROMA_VANILLA = ITEMS.register("romashkino", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA_BAD)));
    public static final RegistryObject<Item> ROMA_COCOA = ITEMS.register("romashkino_cocoa", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COCOA_BAD)));
    public static final RegistryObject<Item> ROMA_COCO = ITEMS.register("romashkino_coconut", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COCO_BAD)));
    public static final RegistryObject<Item> ROMA_COND = ITEMS.register("romashkino_condensed", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COND_BAD)));

    public static final RegistryObject<Item> PACKAGE_ROMA = ITEMS.register("package_romashkino", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
