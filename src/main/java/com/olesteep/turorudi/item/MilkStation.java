package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MilkStation {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static final RegistryObject<Item> MILK_STATION_VANILLA = ITEMS.register("milk_station", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> MILK_STATION_COND = ITEMS.register("milk_station_condensed", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COND)));

    public static final RegistryObject<Item> PACKAGE_MILK_STATION = ITEMS.register("package_milk_station", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
