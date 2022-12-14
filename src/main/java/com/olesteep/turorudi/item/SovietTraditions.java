package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SovietTraditions {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);
    public static final RegistryObject<Item> SOVIET_VANILLA = ITEMS.register("soviet", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> SOVIET_CARAMEL = ITEMS.register("soviet_caramel", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_CARAMEL)));
    public static final RegistryObject<Item> SOVIET_COCOA = ITEMS.register("soviet_cocoa", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COCOA)));
    public static final RegistryObject<Item> SOVIET_COND = ITEMS.register("soviet_condensed", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COND)));

    public static final RegistryObject<Item> PACKAGE_SOVIET = ITEMS.register("package_soviet", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
