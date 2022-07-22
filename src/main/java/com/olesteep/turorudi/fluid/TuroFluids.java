package com.olesteep.turorudi.fluid;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.item.TuroItems;
import com.olesteep.turorudi.block.TuroBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.olesteep.turorudi.event.BlockRegisters.registerBlockWithoutItem;

public class TuroFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, TuroRudi.MOD_ID);

    public static final RegistryObject<FlowingFluid> MILK_COND_FLUID
            = FLUIDS.register("milk_condensed_fluid",
            () -> new ForgeFlowingFluid.Source(TuroFluids.MILK_COND_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MILK_COND_FLOWING
            = FLUIDS.register("milk_condensed_flowing",
            () -> new ForgeFlowingFluid.Flowing(TuroFluids.MILK_COND_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MILK_COND_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MILK_COND_FLUID.get(), () -> MILK_COND_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.HONEY_DRINK).overlay(WATER_OVERLAY_RL)
            .color(0xbf7a3816)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> TuroFluids.MILK_COND_BLOCK.get()).bucket(() -> TuroItems.MILK_COND_BUCKET.get());

    public static final RegistryObject<LiquidBlock> MILK_COND_BLOCK = registerBlockWithoutItem(TuroBlocks.BLOCKS,"milk_cond",
            () -> new LiquidBlock(() -> TuroFluids.MILK_COND_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));

public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}