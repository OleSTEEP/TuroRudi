package com.olesteep.turorudi.item;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Rostagroexport {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);
    public static final RegistryObject<Item> ROSTAGRO_VANILLA = ITEMS.register("rostagroexport", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA_FAT)));
    public static final RegistryObject<Item> ROSTAGRO_VANILLA5 = ITEMS.register("rostagroexport5", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> ROSTAGRO_COCOA = ITEMS.register("rostagroexport_cocoa", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COCOA)));
    public static final RegistryObject<Item> ROSTAGRO_COCO = ITEMS.register("rostagroexport_coconut", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COCO)));
    public static final RegistryObject<Item> ROSTAGRO_COND = ITEMS.register("rostagroexport_condensed", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_COND)));
    public static final RegistryObject<Item> ROSTAGRO_POTATO = ITEMS.register("rostagroexport_potato", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.SNACKTAB).food(TuroFoods.TURO_POTATO)));

    public static final RegistryObject<Item> PACKAGE_ROSTAGRO = ITEMS.register("package_rostagroexport", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
