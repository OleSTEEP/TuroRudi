package com.olesteep.turorudi.fluid.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class CondensedMilkFluidBlock extends LiquidBlock {
    public CondensedMilkFluidBlock(Supplier<? extends FlowingFluid> supplier, BlockBehaviour.Properties props) {
        super(supplier, props);
    }
}