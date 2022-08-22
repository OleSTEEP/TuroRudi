package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Preobrajenskiy {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> PREOBR_VANILLA = ITEMS.register("preobrajenskiy", () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_VANILLA_BAD)));
    public static final RegistryObject<Item> PREOBR_COCOA = ITEMS.register("preobrajenskiy_cocoa", () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_COCOA_BAD)));
    public static final RegistryObject<Item> PREOBR_PREM_VANILLA = ITEMS.register("preobrajenskiy_premium", () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_VANILLA_FAT_BAD)));

    public static final RegistryObject<Item> PACKAGE_PREOBR = ITEMS.register("package_preobrajenskiy", () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
