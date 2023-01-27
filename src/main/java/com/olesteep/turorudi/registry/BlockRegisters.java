package com.olesteep.turorudi.registry;

import com.olesteep.turorudi.item.TuroCreativeTabs;
import com.olesteep.turorudi.item.TuroItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class BlockRegisters {

    public static <T extends Block> RegistryObject<T> registerBlock(DeferredRegister<Block> BLOCKS, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        TuroItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));
    }

    public static <T extends Block> RegistryObject<T> registerEventBlock(DeferredRegister<Block> BLOCKS, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerEventBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerEventBlockItem(String name, RegistryObject<T> block) {
        DateTimeFormatter dtf_day = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter dtf_month = DateTimeFormatter.ofPattern("MM");
        LocalDateTime now = LocalDateTime.now();

        if(Integer.parseInt(dtf_day.format(now)) >= 20 && Integer.parseInt(dtf_month.format(now)) == 10) {
            TuroItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));
        }
        else {
            TuroItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
    }

    public static <T extends Block> RegistryObject<T> registerBlockWithoutItem(DeferredRegister<Block> BLOCKS, String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
}
