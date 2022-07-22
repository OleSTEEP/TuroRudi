package com.olesteep.turorudi.block;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.item.TuroItems;
import com.olesteep.turorudi.tags.TuroBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
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
import org.jetbrains.annotations.NotNull;

import static com.olesteep.turorudi.event.BlockRegisters.registerBlock;
import static com.olesteep.turorudi.event.BlockRegisters.registerBlockWithoutItem;

public class TuroBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);


    public static final RegistryObject<Block> COCONUT_BLOCK = registerBlockWithoutItem(BLOCKS, "coconut",
            () -> new CocoaBlock(BlockBehaviour.Properties.copy(Blocks.COCOA)) {
        @Override
        public boolean canSurvive(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
            BlockState blockstate = levelReader.getBlockState(blockPos.relative(blockState.getValue(FACING)));
            return blockstate.is(TuroBlockTags.PALM_LOGS);
        }
    });

    public static final RegistryObject<Block> BANANA_BLOCK = registerBlockWithoutItem(BLOCKS, "banana",
            () -> new CocoaBlock(BlockBehaviour.Properties.copy(Blocks.COCOA)) {
        @Override
        public boolean canSurvive(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
            BlockState blockstate = levelReader.getBlockState(blockPos.relative(blockState.getValue(FACING)));
            return blockstate.is(TuroBlockTags.PALM_LOGS);
        }
    });

    public static final RegistryObject<Block> MILK_FAT_BLOCK = registerBlock(BLOCKS, "milk_fat_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(3f)));

    public static final RegistryObject<Block> TURO_BLOCK = registerBlock(BLOCKS, "turorudi_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(3f)));

    public static final RegistryObject<Block> TURO_BAD_BLOCK = registerBlock(BLOCKS, "turorudi_bad_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)
                    .strength(3f)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
