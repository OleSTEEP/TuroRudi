package com.olesteep.turorudi.block.custom;

import com.olesteep.turorudi.tags.TuroBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class TuroBananaBlock extends CocoaBlock {
    // (EAST) FRONT, DOWN, LEFT, BACK, UP, RIGHT
    // (WEST) BACK, DOWN, RIGHT, FRONT, UP, LEFT
    // (NORTH) LEFT, DOWN, BACK, RIGHT, UP, FRONT
    // (SOUTH) RIGHT, DOWN, FRONT, LEFT, UP, BACK
    protected static final VoxelShape[] EAST_AABB = new VoxelShape[]{Block.box(12.0D, 7.0D, 6.5D, 15.0D, 12.0D, 9.5D), Block.box(11.0D, 5.0D, 6.0D, 15.0D, 12.0D, 10.0D), Block.box(10.0D, 1.0D, 5.5D, 15.0D, 12.0D, 10.5D)};
    protected static final VoxelShape[] WEST_AABB = new VoxelShape[]{Block.box(1.0D, 7.0D, 6.5D, 4.0D, 12.0D, 9.5D), Block.box(1.0D, 5.0D, 6.0D, 5.0D, 12.0D, 10.0D), Block.box(1.0D, 1.0D, 5.5D, 6.0D, 12.0D, 10.5D)};
    protected static final VoxelShape[] NORTH_AABB = new VoxelShape[]{Block.box(6.5D, 7.0D, 1.0D, 9.5D, 12.0D, 4.0D), Block.box(6.0D, 5.0D, 1.0D, 10.0D, 12.0D, 5.0D), Block.box(5.5D, 1.0D, 1.0D, 10.5D, 12.0D, 6.0D)};
    protected static final VoxelShape[] SOUTH_AABB = new VoxelShape[]{Block.box(6.5D, 7.0D, 12.0D, 9.5D, 12.0D, 15.0D), Block.box(6.0D, 5.0D, 11.0D, 10.0D, 12.0D, 15.0D), Block.box(5.5D, 1.0D, 10.0D, 10.5D, 12.0D, 15.0D)};

    public TuroBananaBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AGE, 0));
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockState blockstate = levelReader.getBlockState(blockPos.relative(blockState.getValue(FACING)));
        return blockstate.is(TuroBlockTags.PALM_LOGS);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        int i = blockState.getValue(AGE);
        switch(blockState.getValue(FACING)) {
            case SOUTH:
                return SOUTH_AABB[i];
            case NORTH:
            default:
                return NORTH_AABB[i];
            case WEST:
                return WEST_AABB[i];
            case EAST:
                return EAST_AABB[i];
        }
    }
}