package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> TURORUDI = ITEMS.register("turorudi",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> TURORUDI_BAD = ITEMS.register("turorudi_bad",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> CHOCOLATE_MILK = ITEMS.register("chocolate_milk",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> CHOCOLATE_WHITE = ITEMS.register("chocolate_white",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> GLAZE = ITEMS.register("glaze",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> CURD = ITEMS.register("curd",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> CURD_BAD = ITEMS.register("curd_bad",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> MILK_FAT = ITEMS.register("milk_fat",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> MILK_COND_BUCKET = ITEMS.register("milk_condensed_bucket",
            () -> new BucketItem(ModFluids.MILK_COND_FLUID,
                    new Item.Properties().tab(ModCreativeTab.TUROTAB).stacksTo(1)));

    public static final RegistryObject<Item> COCO = ITEMS.register("coconut",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.TUROTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
