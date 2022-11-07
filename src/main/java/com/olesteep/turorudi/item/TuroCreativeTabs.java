package com.olesteep.turorudi.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TuroCreativeTabs {
    public static final CreativeModeTab ITEMTAB = new CreativeModeTab("itemtab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(TuroItems.TURORUDI.get());
        }
    };

    public static final CreativeModeTab SNACKTAB = new CreativeModeTab("snacktab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Alexandrov.ALEX_VANILLA26.get());
        }
    };
}
