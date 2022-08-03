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
    public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create((p_68380_) -> foliagePlacerParts(p_68380_).apply(p_68380_, PalmFoliagePlacer::new));

    public PalmFoliagePlacer(IntProvider p_161343_, IntProvider p_161344_) {
        super(p_161343_, p_161344_);
    }

    protected @NotNull FoliagePlacerType<?> type() {
        return TuroFoliagePlacerType.PALM_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(@NotNull LevelSimulatedReader worldReader, @NotNull BiConsumer<BlockPos, BlockState> acceptedLocations, @NotNull Random random, @NotNull TreeConfiguration treeConfiguration, int p_161350_, FoliagePlacer.FoliageAttachment attachment, int height, int radius, int p_161354_) {
        boolean flag = attachment.doubleTrunk();
        // Layer 1
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_),radius - 2, height, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).north(1),radius - 2, height, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).south(1),radius - 2, height, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).west(1),radius - 2, height, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).east(1),radius - 2, height, flag);

        //Layer 2
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_),radius - 1,height - 1, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).north(2),radius - 2, height - 1, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).south(2),radius - 2, height - 1, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).west(2),radius - 2, height - 1, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).east(2),radius - 2, height - 1, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).north(1).east(1),radius - 2, height - 1, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).north(1).west(1),radius - 2, height - 1, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).south(1).east(1),radius - 2, height - 1, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).south(1).west(1),radius - 2, height - 1, flag);

        //Layer 3
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).north(2),radius - 2, height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).south(2),radius - 2, height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).west(2),radius - 2, height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).east(2),radius - 2, height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).north(1).east(1),radius - 2, height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).north(1).west(1),radius - 2, height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).south(1).east(1),radius - 2, height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().above(p_161354_).south(1).west(1),radius - 2, height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().north(3),radius - 2,   height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().south(3),radius - 2,   height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().west(3), radius - 2,   height - 2, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().east(3), radius - 2,   height - 2, flag);

        //Layer 4
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().north(3),radius - 2,   height - 3, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().south(3),radius - 2,   height - 3, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().west(3), radius - 2,   height - 3, flag);
        this.placeLeavesRow(worldReader, acceptedLocations, random, treeConfiguration, attachment.pos().east(3), radius - 2,   height - 3, flag);
    }

    public int foliageHeight(@NotNull Random random, int height, @NotNull TreeConfiguration treeConfiguration) {
        return 0;
    }

    protected boolean shouldSkipLocation(@NotNull Random random, int p_68383_, int p_68384_, int p_68385_, int p_68386_, boolean p_68387_) {
        if (p_68384_ == 0) {
            return (p_68383_ > 1 || p_68385_ > 1) && p_68383_ != 0 && p_68385_ != 0;
        } else {
            return p_68383_ == p_68386_ && p_68385_ == p_68386_ && p_68386_ > 0;
        }
    }
}
