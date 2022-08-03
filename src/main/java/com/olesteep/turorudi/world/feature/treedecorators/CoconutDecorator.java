package com.olesteep.turorudi.world.feature.treedecorators;

import com.mojang.serialization.Codec;
import com.olesteep.turorudi.block.TuroBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.CocoaBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class CoconutDecorator extends TreeDecorator {
    public static final Codec<CoconutDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(CoconutDecorator::new, (name) -> name.probability).codec();
    private final float probability;

    public CoconutDecorator(float p_69976_) {
        this.probability = p_69976_;
    }

    protected @NotNull TreeDecoratorType<?> type() {
        return TuroTreeDecoratorType.COCONUT_DECORATOR.get();
    }

    public void place(@NotNull LevelSimulatedReader worldReader, @NotNull BiConsumer<BlockPos, BlockState> acceptedLocations, Random random, @NotNull List<BlockPos> logs, @NotNull List<BlockPos> leaves) {
        if (!(random.nextFloat() >= this.probability)) {
            int i = logs.get(0).getY();
            logs.stream().filter((p_69980_) -> p_69980_.getY() - i <= 2).forEach((p_161728_) -> {
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    if (random.nextFloat() <= 0.25F) {
                        Direction direction1 = direction.getOpposite();
                        BlockPos blockpos = p_161728_.offset(direction1.getStepX(), 0, direction1.getStepZ());
                        if (Feature.isAir(worldReader, blockpos)) {
                            acceptedLocations.accept(blockpos, TuroBlocks.COCONUT_BLOCK.get().defaultBlockState().setValue(CocoaBlock.AGE, random.nextInt(3)).setValue(CocoaBlock.FACING, direction));
                        }
                    }
                }

            });
        }
    }
}