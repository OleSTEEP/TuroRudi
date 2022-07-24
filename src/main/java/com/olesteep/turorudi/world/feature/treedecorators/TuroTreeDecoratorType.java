package com.olesteep.turorudi.world.feature.treedecorators;

import com.olesteep.turorudi.TuroRudi;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TuroTreeDecoratorType {
    public static final DeferredRegister<TreeDecoratorType<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, TuroRudi.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<?>> BANANA_DECORATOR = DECORATORS.register("banana_decorator", () -> new TreeDecoratorType(BananaDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> COCONUT_DECORATOR = DECORATORS.register("coconut_decorator", () -> new TreeDecoratorType(CoconutDecorator.CODEC));

    public static void register(IEventBus eventBus) {
        DECORATORS.register(eventBus);
    }
}
