package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Svitlogories {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);
    public static final RegistryObject<Item> SVITL_VANILLA = ITEMS.register("svitlogorie",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB).food(ModFoods.TURO_VANILLA)));

    public static final RegistryObject<Item> SVITL_COCOA = ITEMS.register("svitlogorie_cocoa",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB).food(ModFoods.TURO_COCOA)));

    public static final RegistryObject<Item> SVITL_COCO = ITEMS.register("svitlogorie_coconut",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB).food(ModFoods.TURO_COCO)));

    public static final RegistryObject<Item> SVITL_COCO_GLAZE = ITEMS.register("svitlogorie_coconut_glaze",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB).food(ModFoods.TURO_COCO_GLAZE)));

    public static final RegistryObject<Item> SVITL_VANILLA_GLAZE = ITEMS.register("svitlogorie_glaze",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB).food(ModFoods.TURO_GLAZE)));

    public static final RegistryObject<Item> SVITL_LEMON = ITEMS.register("svitlogorie_lemon",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB).food(ModFoods.TURO_LEMON)));

    public static final RegistryObject<Item> SVITL_POTATO = ITEMS.register("svitlogorie_potato",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB).food(ModFoods.TURO_POTATO)));

    public static final RegistryObject<Item> SVITL_STRAW = ITEMS.register("svitlogorie_strawberry",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB).food(ModFoods.TURO_STRAW)));


    public static final RegistryObject<Item> PACKAGE_SVITL = ITEMS.register("package_svitlogorie",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
