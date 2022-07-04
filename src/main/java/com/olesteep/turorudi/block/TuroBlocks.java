package com.olesteep.turorudi.block;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.item.TuroCreativeTab;
import com.olesteep.turorudi.item.TuroItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TuroBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);

    public static final RegistryObject<Block> MILK_FAT_BLOCK = registerBlock("milk_fat_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(3f)), TuroCreativeTab.TUROTAB);

    public static final RegistryObject<Block> TURO_BLOCK = registerBlock("turorudi_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(3f)), TuroCreativeTab.TUROTAB);

    public static final RegistryObject<Block> TURO_BAD_BLOCK = registerBlock("turorudi_bad_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(3f)), TuroCreativeTab.TUROTAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {

        return TuroItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
