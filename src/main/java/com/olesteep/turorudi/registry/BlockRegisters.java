package com.olesteep.turorudi.registry;

import com.olesteep.turorudi.item.TuroCreativeTab;
import com.olesteep.turorudi.item.TuroItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegisters {

    public static <T extends Block> RegistryObject<T> registerBlock(DeferredRegister<Block> BLOCKS, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        TuroItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(TuroCreativeTab.TUROTAB)));
    }

    public static <T extends Block> RegistryObject<T> registerBlockWithoutItem(DeferredRegister<Block> BLOCKS, String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
}
