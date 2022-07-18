package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Pottyos {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> POTTYOS_VANILLA = ITEMS.register("pottyos",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_VANILLA)));

    public static final RegistryObject<Item> POTTYOS_STRAW = ITEMS.register("pottyos_strawberry",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_STRAW)));

    public static final RegistryObject<Item> POTTYOS_APRICOT = ITEMS.register("pottyos_apricot",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB).food(TuroFoods.TURO_APRICOT)));


    public static final RegistryObject<Item> PACKAGE_POTTYOS = ITEMS.register("package_pottyos",
            () -> new Item(new Item.Properties().tab(TuroCreativeTab.TUROTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}