package com.olesteep.turorudi.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class TuroSaplingBlock extends SaplingBlock {
    private final Supplier<Block> otherDirt;

    public TuroSaplingBlock(AbstractTreeGrower pTreeGrower, Properties pProperties, Supplier<Block> otherDirt) {
        super(pTreeGrower, pProperties);
        this.otherDirt = otherDirt;
    }

    @Override
    public boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return pState.is(otherDirt.get());
    }

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return PlantType.get("custom");
    }
}