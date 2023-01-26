package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sirkoff {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);
    public static final RegistryObject<Item> SIRKOFF_VANILLA = ITEMS.register("sirkoff", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> SIRKOFF_COCO = ITEMS.register("sirkoff_coconut", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COCO)));
    public static final RegistryObject<Item> SIRKOFF_COND = ITEMS.register("sirkoff_condensed", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COND)));
    public static final RegistryObject<Item> SIRKOFF_STRAW = ITEMS.register("sirkoff_strawberry", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_BERRY)));
    public static final RegistryObject<Item> SIRKOFF_POTATO = ITEMS.register("sirkoff_potato", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_POTATO)));

    public static final RegistryObject<Item> PACKAGE_SIRKOFF = ITEMS.register("package_sirkoff", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
