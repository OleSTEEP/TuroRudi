package com.olesteep.turorudi.block.custom;

import com.olesteep.turorudi.tags.TuroBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CocoaBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class TuroCoconutBlock extends CocoaBlock {
    public TuroCoconutBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AGE, 0));
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockState blockstate = levelReader.getBlockState(blockPos.relative(blockState.getValue(FACING)));
        return blockstate.is(TuroBlockTags.PALM_LOGS);
    }
}