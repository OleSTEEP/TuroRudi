package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Nostalgia {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> NOSTALGIA_VANILLA_23 = ITEMS.register("nostalgia23", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA_FAT)));
    public static final RegistryObject<Item> NOSTALGIA_VANILLA_5 = ITEMS.register("nostalgia5", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> NOSTALGIA_BERRY = ITEMS.register("nostalgia_berry", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_BERRY)));
    public static final RegistryObject<Item> NOSTALGIA_CHERRY = ITEMS.register("nostalgia_cherry", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_CHERRY)));
    public static final RegistryObject<Item> NOSTALGIA_COND = ITEMS.register("nostalgia_condensed", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COND)));
    public static final RegistryObject<Item> NOSTALGIA_POTATO = ITEMS.register("nostalgia_potato", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_POTATO)));

    public static final RegistryObject<Item> PACKAGE_NOSTALGIA = ITEMS.register("package_nostalgia", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
