package com.olesteep.turorudi.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TuroCreativeTab {
    public static final CreativeModeTab TUROTAB = new CreativeModeTab("turotab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Alexandrov.ALEX_VANILLA26.get());
        }
    };
}
