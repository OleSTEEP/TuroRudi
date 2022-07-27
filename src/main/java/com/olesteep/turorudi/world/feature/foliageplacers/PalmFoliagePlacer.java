package com.olesteep.turorudi.world.feature.foliageplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.BiConsumer;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create((p_68380_) -> {
        return foliagePlacerParts(p_68380_).apply(p_68380_, PalmFoliagePlacer::new);
    });

    public PalmFoliagePlacer(IntProvider p_161343_, IntProvider p_161344_) {
        super(p_161343_, p_161344_);
    }

    protected @NotNull FoliagePlacerType<?> type() {
        return TuroFoliagePlacerType.PALM_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader WorldReader, BiConsumer<BlockPos, BlockState> AcceptedLocations, Random Rand, TreeConfiguration TreeConf, int p_161350_, FoliagePlacer.FoliageAttachment p_161351_, int p_161352_, int p_161353_, int p_161354_) {
        boolean flag = p_161351_.doubleTrunk();
        BlockPos blockpos = p_161351_.pos().above(p_161354_);
        this.placeLeavesRow(WorldReader, AcceptedLocations, Rand, TreeConf, blockpos, p_161353_ + p_161351_.radiusOffset(), -1 - p_161352_, flag);
        this.placeLeavesRow(WorldReader, AcceptedLocations, Rand, TreeConf, blockpos, p_161353_ - 1, -p_161352_, flag);
        this.placeLeavesRow(WorldReader, AcceptedLocations, Rand, TreeConf, blockpos, p_161353_ + p_161351_.radiusOffset() - 1, 0, flag);
    }

    public int foliageHeight(Random Rand, int p_68390_, TreeConfiguration TreeConf) {
        return 0;
    }

    protected boolean shouldSkipLocation(Random p_68382_, int p_68383_, int p_68384_, int p_68385_, int p_68386_, boolean p_68387_) {
        if (p_68384_ == 0) {
            return (p_68383_ > 1 || p_68385_ > 1) && p_68383_ != 0 && p_68385_ != 0;
        } else {
            return p_68383_ == p_68386_ && p_68385_ == p_68386_ && p_68386_ > 0;
        }
    }
}
