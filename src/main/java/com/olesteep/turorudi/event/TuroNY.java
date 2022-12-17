package com.olesteep.turorudi.event;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.item.TuroCreativeTabs;
import com.olesteep.turorudi.villager.TuroVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = TuroRudi.MOD_ID)
public class TuroNY {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TuroRudi.MOD_ID);
    public static final RegistryObject<SoundEvent> NYGIFT_BREAK = registerSoundEvent("new_year_gift_break");
    public static final RegistryObject<SoundEvent> NYGIFT_STEP = registerSoundEvent("new_year_gift_step");
    public static final RegistryObject<SoundEvent> NYGIFT_PLACE = registerSoundEvent("new_year_gift_place");
    public static final RegistryObject<SoundEvent> NYGIFT_HIT = registerSoundEvent("new_year_gift_hit");
    public static final RegistryObject<SoundEvent> NYGIFT_FALL = registerSoundEvent("new_year_gift_fall");
    public static final SoundType NYGIFT_SOUNDS = new ForgeSoundType(1.0F, 1.25F, NYGIFT_BREAK, NYGIFT_STEP, NYGIFT_PLACE, NYGIFT_HIT, NYGIFT_FALL);

    public static final RegistryObject<Block> NYGIFT = registerBlock("new_year_gift", () -> new Block(BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(NYGIFT_SOUNDS)) {

        private static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

        @Override
        public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
            return SHAPE;
        }
    });

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        DateTimeFormatter dtf_day = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter dtf_month = DateTimeFormatter.ofPattern("MM");
        LocalDateTime now = LocalDateTime.now();

        if (Integer.parseInt(dtf_day.format(now)) >= 15 && Integer.parseInt(dtf_month.format(now)) == 12) {
            if (event.getType() == TuroVillagers.TUROMAKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

                trades.get(1).add((trader, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(NYGIFT.get(), 1), 999, 6, 0.02F));
            }
        }
    }

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(TuroRudi.MOD_ID, name)));
    }

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        SOUND_EVENTS.register(eventBus);
    }
}
