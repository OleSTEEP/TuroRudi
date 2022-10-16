package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.block.*;
import com.olesteep.turorudi.fluid.TuroFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TuroItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);
    public static final RegistryObject<Item> TURORUDI = ITEMS.register("turorudi", () -> new Item(new Item.Properties().food(TuroFoods.TURO_BASE).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> TURORUDI_BAD = ITEMS.register("turorudi_bad", () -> new Item(new Item.Properties().food(TuroFoods.TURO_BAD).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> APRICOT = ITEMS.register("apricot", () -> new ItemNameBlockItem(ApricotBush.APRICOT_BUSH.get(), (new Item.Properties()).food(TuroFoods.APRICOT).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana_item", () -> new ItemNameBlockItem(TuroBlocks.BANANA_BLOCK.get(), new Item.Properties().food(TuroFoods.BANANA).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", () -> new ItemNameBlockItem(BlueBerryBush.BLBERRY_BUSH.get(), (new Item.Properties()).food(TuroFoods.BLBERRY).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> CARAMEL = ITEMS.register("caramel", () -> new Item(new Item.Properties().food(TuroFoods.CARAMEL).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> CHERRY = ITEMS.register("cherry", () -> new Item(new Item.Properties().food(TuroFoods.CHERRY).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate", () -> new Item(new Item.Properties().food(TuroFoods.CHOCOLATE).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> CHOCOLATE_BAD = ITEMS.register("chocolate_bad", () -> new Item(new Item.Properties().food(TuroFoods.CHOCOLATE_BAD).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> CHOCOLATE_MILK = ITEMS.register("chocolate_milk", () -> new Item(new Item.Properties().food(TuroFoods.CHOCOLATE).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> CHOCOLATE_WHITE = ITEMS.register("chocolate_white", () -> new Item(new Item.Properties().food(TuroFoods.CHOCOLATE).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> COCO = ITEMS.register("coconut_item", () -> new ItemNameBlockItem(TuroBlocks.COCONUT_BLOCK.get(), new Item.Properties().food(TuroFoods.COCO).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> CURD = ITEMS.register("curd", () -> new Item(new Item.Properties().food(TuroFoods.CURD).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> CURD_BAD = ITEMS.register("curd_bad", () -> new Item(new Item.Properties().food(TuroFoods.CURD_BAD).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> GLAZE = ITEMS.register("glaze", () -> new Item(new Item.Properties().food(TuroFoods.GLAZE).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> MILK_COND_BUCKET = ITEMS.register("milk_condensed_bucket", () -> new BucketItem(TuroFluids.MILK_COND_FLUID, new Item.Properties().tab(TuroCreativeTab.TUROTAB).stacksTo(1)));
    public static final RegistryObject<Item> MILK_FAT = ITEMS.register("milk_fat", () -> new Item(new Item.Properties().food(TuroFoods.MILK_FAT).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new ItemNameBlockItem(LemonBush.LEMON_BUSH.get(), new Item.Properties().food(TuroFoods.LEMON).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> LIME = ITEMS.register("lime", () -> new ItemNameBlockItem(LimeBush.LIME_BUSH.get(), new Item.Properties().food(TuroFoods.LIME).tab(TuroCreativeTab.TUROTAB)));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () -> new Item(new Item.Properties().food(TuroFoods.ORANGE).tab(TuroCreativeTab.TUROTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
