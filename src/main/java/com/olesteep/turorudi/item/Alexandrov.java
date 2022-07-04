package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Alexandrov {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> ALEX_VANILLA5 = ITEMS.register("alexandrov5",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_VANILLA)));

    public static final RegistryObject<Item> ALEX_VANILLA26 = ITEMS.register("alexandrov26",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_VANILLA_FAT)));

    public static final RegistryObject<Item> ALEX_CHOCOLESS = ITEMS.register("alexandrov_chocoless",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_VANILLA_CHOCOLESS)));

    public static final RegistryObject<Item> ALEX_COND = ITEMS.register("alexandrov_condensed",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_COND)));

    public static final RegistryObject<Item> ALEX_MILK5 = ITEMS.register("alexandrov_milk5",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_VANILLA_MILK)));

    public static final RegistryObject<Item> ALEX_MILK26 = ITEMS.register("alexandrov_milk26",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_VANILLA_FAT_MILK)));

    public static final RegistryObject<Item> ALEX_POTATO = ITEMS.register("alexandrov_potato",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_POTATO)));

    public static final RegistryObject<Item> ALEX_SOUFFLE = ITEMS.register("alexandrov_souffle",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_SOUFFLE)));

    public static final RegistryObject<Item> ALEX_SOUFFLE_MILK = ITEMS.register("alexandrov_souffle_milk",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_SOUFFLE_MILK)));

    public static final RegistryObject<Item> ALEX_WHITE = ITEMS.register("alexandrov_white",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_WHITE)));


    public static final RegistryObject<Item> PACKAGE_ALEX = ITEMS.register("package_alexandrov",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
