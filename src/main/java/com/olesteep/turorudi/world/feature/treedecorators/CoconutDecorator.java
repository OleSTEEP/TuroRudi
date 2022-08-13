package com.olesteep.turorudi.world.feature.treedecorators;

import com.mojang.serialization.Codec;
import com.olesteep.turorudi.block.TuroBlocks;
import com.olesteep.turorudi.block.custom.TuroCoconutBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CoconutDecorator extends TreeDecorator {
    public static final Codec<CoconutDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(CoconutDecorator::new, (p_69989_) -> p_69989_.probability).codec();
    private final float probability;

    public CoconutDecorator(float p_69976_) {
        this.probability = p_69976_;
    }

    protected @NotNull TreeDecoratorType<?> type() {
        return TuroTreeDecoratorType.COCONUT_DECORATOR.get();
    }

    public void place(TreeDecorator.Context placeContext) {
        RandomSource randomsource = placeContext.random();
        if (!(randomsource.nextFloat() >= this.probability)) {
            List<BlockPos> leaves = placeContext.leaves();
            List<BlockPos> logs = placeContext.logs();
            int i = leaves.get(0).getY();
            logs.stream().filter((log) -> i - log.getY() == -1).forEach((log) -> {
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    if (randomsource.nextFloat() <= 0.75F) {
                        Direction direction1 = direction.getOpposite();
                        BlockPos blockpos = log.offset(direction1.getStepX(), 0, direction1.getStepZ());
                        if (placeContext.isAir(blockpos)) {
                            placeContext.setBlock(blockpos, TuroBlocks.COCONUT_BLOCK.get().defaultBlockState().setValue(TuroCoconutBlock.AGE, randomsource.nextInt(3)).setValue(TuroCoconutBlock.FACING, direction));
                        }
                    }
                }

            });
        }
    }
}