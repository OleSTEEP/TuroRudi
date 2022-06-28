package com.olesteep.turorudi.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab TUROTAB = new CreativeModeTab("turotab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Svitlogories.SVITL_VANILLA.get());
        }
    };
}
