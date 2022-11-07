package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Corenovka {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> CORENOVKA_VANILLA = ITEMS.register("corenovka", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> CORENOVKA_CARAMEL = ITEMS.register("corenovka_caramel", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_CARAMEL)));
    public static final RegistryObject<Item> CORENOVKA_ORANGE = ITEMS.register("corenovka_orange", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_ORANGE)));
    public static final RegistryObject<Item> CORENOVKA_LEMON_LIME = ITEMS.register("corenovka_lemon_lime", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_LEMON_LIME)));

    public static final RegistryObject<Item> PACKAGE_CORENOVKA = ITEMS.register("package_corenovka", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
