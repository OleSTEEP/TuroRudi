package com.olesteep.turorudi.block;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.block.custom.TuroBananaBlock;
import com.olesteep.turorudi.block.custom.TuroCoconutBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.olesteep.turorudi.event.BlockRegisters.registerBlock;
import static com.olesteep.turorudi.event.BlockRegisters.registerBlockWithoutItem;

public class TuroBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);

    public static final RegistryObject<Block> COCONUT_BLOCK = registerBlockWithoutItem(BLOCKS, "coconut", () -> new TuroCoconutBlock(BlockBehaviour.Properties.copy(Blocks.COCOA).randomTicks().strength(0.2F, 3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> BANANA_BLOCK = registerBlockWithoutItem(BLOCKS, "banana", () -> new TuroBananaBlock(BlockBehaviour.Properties.copy(Blocks.COCOA).randomTicks().strength(0.2F, 3.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> MILK_FAT_BLOCK = registerBlock(BLOCKS, "milk_fat_block", () -> new Block(BlockBehaviour.Properties.of(Material.CAKE).strength(0.8F).sound(SoundType.SLIME_BLOCK)));
    public static final RegistryObject<Block> TURO_BLOCK = registerBlock(BLOCKS, "turorudi_block", () -> new Block(BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> TURO_BAD_BLOCK = registerBlock(BLOCKS, "turorudi_bad_block", () -> new Block(BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
