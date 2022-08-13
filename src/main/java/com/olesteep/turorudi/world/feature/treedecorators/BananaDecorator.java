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
    public static final Codec<BananaDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(BananaDecorator::new, (p_69989_) -> p_69989_.probability).codec();
    private final float probability;

    public BananaDecorator(float p_69976_) {
        this.probability = p_69976_;
    }

    protected @NotNull TreeDecoratorType<?> type() {
        return TuroTreeDecoratorType.BANANA_DECORATOR.get();
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
                            placeContext.setBlock(blockpos, TuroBlocks.BANANA_BLOCK.get().defaultBlockState().setValue(TuroBananaBlock.AGE, randomsource.nextInt(3)).setValue(TuroBananaBlock.FACING, direction));
                        }
                    }
                }

            });
        }
    }
}
