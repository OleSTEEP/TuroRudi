package com.olesteep.turorudi.world.feature.treedecorators;

import com.mojang.serialization.Codec;
import com.olesteep.turorudi.block.TuroBlocks;
import com.olesteep.turorudi.block.custom.TuroBananaBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BananaDecorator extends TreeDecorator {
    public static final Codec<BananaDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(BananaDecorator::new, (p_69989_) -> {
        return p_69989_.probability;
    }).codec();
    private final float probability;

    public BananaDecorator(float p_69976_) {
        this.probability = p_69976_;
    }

    protected @NotNull TreeDecoratorType<?> type() {
        return TuroTreeDecoratorType.BANANA_DECORATOR.get();
    }

    public void place(TreeDecorator.Context p_226028_) {
        RandomSource randomsource = p_226028_.random();
        if (!(randomsource.nextFloat() >= this.probability)) {
            List<BlockPos> list = p_226028_.logs();
            int i = list.get(0).getY();
            list.stream().filter((p_69980_) -> {
                return p_69980_.getY() - i <= 2;
            }).forEach((p_226026_) -> {
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    if (randomsource.nextFloat() <= 0.25F) {
                        Direction direction1 = direction.getOpposite();
                        BlockPos blockpos = p_226026_.offset(direction1.getStepX(), 0, direction1.getStepZ());
                        if (p_226028_.isAir(blockpos)) {
                            p_226028_.setBlock(blockpos, TuroBlocks.BANANA_BLOCK.get().defaultBlockState().setValue(TuroBananaBlock.AGE, Integer.valueOf(randomsource.nextInt(3))).setValue(TuroBananaBlock.FACING, direction));
                        }
                    }
                }

            });
        }
    }
}
