package com.olesteep.turorudi.block;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.item.TuroCreativeTab;
import com.olesteep.turorudi.item.TuroItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class LemonBush {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);

    public static final RegistryObject<Block> LEMON_BUSH = registerBlock(
            () -> new FlowerBlock(MobEffects.LEVITATION, 8,
                    BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH).noOcclusion()));

    public static final RegistryObject<Block> POTTED_LEMON_BUSH = registerBlockWithoutBlockItem(
            () -> new FlowerPotBlock(null, LemonBush.LEMON_BUSH,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(Supplier<T> block) {
        return BLOCKS.register("potted_lemon_bush", block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register("lemon_bush", block);
        registerBlockItem(toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(RegistryObject<T> block) {

        TuroItems.ITEMS.register("lemon_bush", () -> new BlockItem(block.get(),
                new Item.Properties().tab(TuroCreativeTab.TUROTAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
