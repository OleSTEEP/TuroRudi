package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Vologosha {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> VOLOG_VANILLA = ITEMS.register("vologosha", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA_BAD)));
    public static final RegistryObject<Item> VOLOG_BANANA = ITEMS.register("vologosha_banana", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_BANANA_BAD)));
    public static final RegistryObject<Item> VOLOG_BLBERRY = ITEMS.register("vologosha_blueberry", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_BLBERRY_BAD)));
    public static final RegistryObject<Item> VOLOG_CHERRY = ITEMS.register("vologosha_cherry", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_CHERRY_BAD)));
    public static final RegistryObject<Item> VOLOG_COCOA = ITEMS.register("vologosha_cocoa", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COCOA_BAD)));
    public static final RegistryObject<Item> VOLOG_COND = ITEMS.register("vologosha_condensed", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COND_BAD)));
    public static final RegistryObject<Item> VOLOG_ORANGE = ITEMS.register("vologosha_orange", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_ORANGE_BAD)));
    public static final RegistryObject<Item> VOLOG_STRAW = ITEMS.register("vologosha_strawberry", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_STRAW_BAD)));

    public static final RegistryObject<Item> PACKAGE_VOLOG = ITEMS.register("package_vologosha", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}