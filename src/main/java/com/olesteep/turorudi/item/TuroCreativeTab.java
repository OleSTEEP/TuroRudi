package com.olesteep.turorudi.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TuroCreativeTab {
    public static final CreativeModeTab TUROTAB = new CreativeModeTab("turotab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Svitlogorie.SVITL_VANILLA.get());
        }
    };
}
