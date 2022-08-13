package com.olesteep.turorudi.fluid;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.fluid.block.CondensedMilkFluidBlock;
import com.olesteep.turorudi.item.TuroCreativeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

// Thanks to example https://github.com/Lothrazar/Cyclic/blob/trunk/1.19/src/main/java/com/lothrazar/cyclic/fluid/FluidHoneyHolder.java
public class TuroFluidCondensedMilkHolder {
    private static final ResourceLocation FLUID_STILL = new ResourceLocation("minecraft:block/water_still");
    private static final ResourceLocation FLUID_FLOWING = new ResourceLocation("minecraft:block/water_flow");
    private static final ResourceLocation FLUID_OVERLAY = new ResourceLocation("minecraft:block/water_overlay");
    public static final int COLOR = 0xBF7A3816;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, TuroRudi.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TuroRudi.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);

    public static RegistryObject<FlowingFluid> STILL = FLUIDS.register("milk_condensed", () -> new ForgeFlowingFluid.Source(makeProperties()));
    public static RegistryObject<FlowingFluid> FLOWING = FLUIDS.register("milk_condensed_flowing", () -> new ForgeFlowingFluid.Flowing(makeProperties()));
    public static RegistryObject<LiquidBlock> BLOCK = BLOCKS.register("milk_condensed_block", () -> new CondensedMilkFluidBlock(STILL, Block.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
    public static RegistryObject<Item> BUCKET = ITEMS.register("milk_condensed_bucket", () -> new BucketItem(STILL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(TuroCreativeTab.TUROTAB)));
    public static RegistryObject<FluidType> FLUID_TYPE = FLUID_TYPES.register("milk_condensed", () -> new FluidType(FluidType.Properties.create()) {

        @Override
        public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
            consumer.accept(new IClientFluidTypeExtensions() {

                @Override
                public ResourceLocation getStillTexture() {
                    return FLUID_STILL;
                }

                @Override
                public ResourceLocation getFlowingTexture() {
                    return FLUID_FLOWING;
                }

                @Override
                public ResourceLocation getOverlayTexture() {
                    return FLUID_OVERLAY;
                }

                @Override
                public int getTintColor() {
                    return COLOR;
                }
            });
        }

        @Override
        public SoundEvent getSound(SoundAction action) {
            return SoundEvents.HONEY_DRINK;
        }

        @Override
        public int getDensity() {
            return 3000;
        }

        @Override
        public int getViscosity() {
            return 6000;
        }

    });

    private static ForgeFlowingFluid.Properties makeProperties() {
        return new ForgeFlowingFluid.Properties(FLUID_TYPE, STILL, FLOWING)
                .bucket(BUCKET)
                .block(BLOCK)
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        FLUIDS.register(eventBus);
        FLUID_TYPES.register(eventBus);
        ITEMS.register(eventBus);
    }
}