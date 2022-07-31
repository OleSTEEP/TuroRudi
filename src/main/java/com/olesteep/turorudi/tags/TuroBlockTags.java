package com.olesteep.turorudi.tags;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TuroBlockTags {
    public static final TagKey<Block> CHERRY_LOGS = create("cherry_logs");
    public static final TagKey<Block> ORANGE_LOGS = create("orange_logs");
    public static final TagKey<Block> PALM_LOGS = create("palm_logs");

    private TuroBlockTags() {
    }

    private static TagKey<Block> create(String name) {
        return BlockTags.create(new ResourceLocation(TuroRudi.MOD_ID, name));
    }
}
