package com.olesteep.turorudi.fluid.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

// Thanks to example https://github.com/Lothrazar/Cyclic/blob/trunk/1.19/src/main/java/com/lothrazar/cyclic/fluid/block/HoneyFluidBlock.java
public class CondensedMilkFluidBlock extends LiquidBlock {
    public CondensedMilkFluidBlock(Supplier<? extends FlowingFluid> supplier, BlockBehaviour.Properties props) {
        super(supplier, props);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void entityInside(@NotNull BlockState state, Level worldIn, @NotNull BlockPos pos, @NotNull Entity entityIn) {
        if (!worldIn.isClientSide && entityIn instanceof LivingEntity entity) {
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1));
            entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 5));
            entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 5));
        }
        super.entityInside(state, worldIn, pos, entityIn);
    }
}