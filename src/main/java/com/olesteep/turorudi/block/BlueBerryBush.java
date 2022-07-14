package com.olesteep.turorudi.block;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.item.TuroCreativeTab;
import com.olesteep.turorudi.item.TuroItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlueBerryBush {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);

    public static final RegistryObject<Block> BLBERRY_BUSH = registerBlock(() -> new SweetBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH)));


    private static <T extends Block> RegistryObject<T> registerBlock(Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register("blueberry_bush", block);
        registerBlockItem(toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(RegistryObject<T> block) {

        TuroItems.ITEMS.register("blueberry_bush", () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
