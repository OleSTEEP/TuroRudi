package com.olesteep.turorudi.block;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.block.custom.TuroFlammableRotatedPillarBlock;
import com.olesteep.turorudi.block.custom.TuroSaplingBlock;
import com.olesteep.turorudi.world.feature.tree.PalmTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.olesteep.turorudi.registry.BlockRegisters.registerBlock;

public class PalmTree {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);

    public static final RegistryObject<Block> PALM_LOG = registerBlock(BLOCKS, "palm_log", () -> new TuroFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> PALM_WOOD = registerBlock(BLOCKS, "palm_wood", () -> new TuroFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PALM_LOG = registerBlock(BLOCKS, "stripped_palm_log", () -> new TuroFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final RegistryObject<Block> STRIPPED_PALM_WOOD = registerBlock(BLOCKS, "stripped_palm_wood", () -> new TuroFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final RegistryObject<Block> PALM_PLANKS = registerBlock(BLOCKS, "palm_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 20;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
    });

    public static final RegistryObject<Block> PALM_LEAVES = registerBlock(BLOCKS, "palm_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LEAVES)) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 60;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 30;
        }
    });

    public static final RegistryObject<Block> PALM_SAPLING = registerBlock(BLOCKS, "palm_sapling", () -> new TuroSaplingBlock(new PalmTreeGrower(), BlockBehaviour.Properties.copy(Blocks.JUNGLE_SAPLING), () -> Blocks.SAND));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
