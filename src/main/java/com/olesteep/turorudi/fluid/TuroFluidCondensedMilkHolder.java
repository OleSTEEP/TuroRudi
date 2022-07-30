package com.olesteep.turorudi.fluid;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.event.BlockRegisters;
import com.olesteep.turorudi.fluid.block.CondensedMilkFluidBlock;
import com.olesteep.turorudi.item.TuroCreativeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class TuroFluidCondensedMilkHolder {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, TuroRudi.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TuroRudi.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    private static final ResourceLocation FLUID_FLOWING = new ResourceLocation("block/water_flow");
    private static final ResourceLocation FLUID_STILL = new ResourceLocation("block/water_still");
    private static final int COLOR = 0xbf7a3816;

    public static RegistryObject<FlowingFluid> STILL = FLUIDS.register("milk_condensed", () -> new ForgeFlowingFluid.Source(makeProperties()));
    public static RegistryObject<FlowingFluid> FLOWING = FLUIDS.register("milk_condensed_flowing", () -> new ForgeFlowingFluid.Flowing(makeProperties()));
    public static RegistryObject<LiquidBlock> BLOCK = BlockRegisters.registerBlockWithoutItem(BLOCKS, "milk_condensed_block", () -> new CondensedMilkFluidBlock((Supplier)STILL, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
    public static RegistryObject<Item> BUCKET = ITEMS.register("milk_condensed_bucket", () -> new BucketItem((Supplier)STILL, (new Item.Properties()).tab(TuroCreativeTab.TUROTAB).stacksTo(1)));
    public static RegistryObject<FluidType> MILK_CONDENSED_FLUID_TYPE = FLUID_TYPES.register("milk_condensed", () -> new FluidType(FluidType.Properties.create()) {
        public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
            consumer.accept(new IClientFluidTypeExtensions() {
                public ResourceLocation getStillTexture() {
                    return TuroFluidCondensedMilkHolder.FLUID_STILL;
                }
                public ResourceLocation getFlowingTexture() {
                    return TuroFluidCondensedMilkHolder.FLUID_FLOWING;
                }
                public ResourceLocation getOverlayTexture() {
                    return null;
                }
                public int getTintColor() {
                    return COLOR;
                }
            });
        }
    });

    private static ForgeFlowingFluid.Properties makeProperties() {
        return (new ForgeFlowingFluid.Properties((Supplier)MILK_CONDENSED_FLUID_TYPE, (Supplier)STILL, (Supplier)FLOWING)).bucket((Supplier)BUCKET).block((Supplier)BLOCK);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        FLUIDS.register(eventBus);
        FLUID_TYPES.register(eventBus);
        ITEMS.register(eventBus);
    }
}