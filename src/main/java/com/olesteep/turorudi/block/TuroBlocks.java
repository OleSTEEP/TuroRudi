package com.olesteep.turorudi.block;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.item.TuroCreativeTab;
import com.olesteep.turorudi.item.TuroItems;
import com.olesteep.turorudi.tags.TuroBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CocoaBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TuroBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);


    public static final RegistryObject<Block> COCONUT_BLOCK = registerBlockWithoutItem("coconut_block",
            () -> new CocoaBlock(BlockBehaviour.Properties.copy(Blocks.COCOA)) {
        @Override
        public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
            BlockState blockstate = levelReader.getBlockState(blockPos.relative(blockState.getValue(FACING)));
            return blockstate.is(TuroBlockTags.PALM_LOGS);
        }
            });

    public static final RegistryObject<Block> MILK_FAT_BLOCK = registerBlock("milk_fat_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(3f)));

    public static final RegistryObject<Block> TURO_BLOCK = registerBlock("turorudi_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(3f)));

    public static final RegistryObject<Block> TURO_BAD_BLOCK = registerBlock("turorudi_bad_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(3f)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {

        TuroItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(TuroCreativeTab.TUROTAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
