package com.olesteep.turorudi.event;

import com.google.common.collect.ImmutableSet;
import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.data.TuroLists;
import com.olesteep.turorudi.item.TuroCreativeTabs;
import com.olesteep.turorudi.item.TuroFoods;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = TuroRudi.MOD_ID)
public class TuroHW {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TuroRudi.MOD_ID);
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, TuroRudi.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TuroRudi.MOD_ID);

    public static final RegistryObject<Block> TURO_BLOCK_DARK = registerBlock(BLOCKS, "turorudi_block_dark", () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL).lightLevel((level) -> 15)));
    public static final RegistryObject<Item> ALEX_5_DARK = ITEMS.register("alexandrov5_dark", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> ALEX_26_DARK = ITEMS.register("alexandrov26_dark", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB).food(TuroFoods.TURO_VANILLA_FAT)));
    public static final RegistryObject<Item> CORENOVKA_DARK = ITEMS.register("corenovka_dark", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> POTTYOS_DARK = ITEMS.register("pottyos_dark", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> PREOBR_DARK = ITEMS.register("preobrajenskiy_dark", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB).food(TuroFoods.TURO_VANILLA_BAD)));
    public static final RegistryObject<Item> ROSTAGRO_DARK = ITEMS.register("rostagroexport_dark", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB).food(TuroFoods.TURO_VANILLA_FAT)));
    public static final RegistryObject<Item> SVITL_DARK = ITEMS.register("svitlogorie_dark", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> VKUSN_DARK = ITEMS.register("vkusnoteevo_dark", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB).food(TuroFoods.TURO_VANILLA)));
    public static final RegistryObject<Item> VOLOG_DARK = ITEMS.register("vologosha_dark", () -> new Item(new Item.Properties().tab(TuroCreativeTabs.ITEMTAB).food(TuroFoods.TURO_VANILLA_BAD)));
    public static final RegistryObject<PoiType> TUROMAKER_DARK_POI = POI_TYPES.register("turomaker_dark_poi", () -> new PoiType(ImmutableSet.copyOf(TURO_BLOCK_DARK.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<VillagerProfession> TUROMAKER_DARK = VILLAGER_PROFESSIONS.register("turomaker_dark", () -> new VillagerProfession("turomaker_dark", x -> x.get() == TUROMAKER_DARK_POI.get(), x -> x.get() == TUROMAKER_DARK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        DateTimeFormatter dtf_day = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter dtf_month = DateTimeFormatter.ofPattern("MM");
        LocalDateTime now = LocalDateTime.now();

        if(Integer.parseInt(dtf_day.format(now)) >= 20 && Integer.parseInt(dtf_month.format(now)) == 10) {
            if (event.getType() == TUROMAKER_DARK.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

                // Sold
                trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, 39), new ItemStack(Items.ENDER_PEARL, nonNullRandom(5)), 4, 12, 0.06F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, 26), new ItemStack(Items.PUMPKIN, 1), 4, 12, 0.10F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, 39), new ItemStack(Items.PUMPKIN_PIE, 1), 4, 12, 0.09F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, 13), new ItemStack(Items.PUMPKIN_SEEDS, nonNullRandom(15)), 4, 12, 0.12F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, 13), new ItemStack(Items.REDSTONE, nonNullRandom(32)), 4, 12, 0.12F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, 13), new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(10)), 4, 12, 0.12F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, 13), new ItemStack(Items.SPIDER_EYE, nonNullRandom(10)), 4, 12, 0.12F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, 13), new ItemStack(Items.STRING, nonNullRandom(10)), 4, 12, 0.12F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(52)), new ItemStack(ALEX_5_DARK.get(), nonNullRandom(5)), 4, 12, 0.09F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(52)), new ItemStack(ALEX_26_DARK.get(), nonNullRandom(5)), 4, 12, 0.09F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(52)), new ItemStack(CORENOVKA_DARK.get(), nonNullRandom(5)), 4, 12, 0.09F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(52)), new ItemStack(POTTYOS_DARK.get(), nonNullRandom(5)), 4, 12, 0.09F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(52)), new ItemStack(PREOBR_DARK.get(), nonNullRandom(5)), 4, 12, 0.09F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(52)), new ItemStack(ROSTAGRO_DARK.get(), nonNullRandom(5)), 4, 12, 0.09F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(52)), new ItemStack(SVITL_DARK.get(), nonNullRandom(5)), 4, 12, 0.09F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(39)), new ItemStack(VKUSN_DARK.get(), nonNullRandom(5)), 4, 12, 0.12F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(39)), new ItemStack(VOLOG_DARK.get(), nonNullRandom(5)), 4, 12, 0.12F));

                // Buy
                trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ENDER_PEARL, nonNullRandom(5)), new ItemStack(Items.EMERALD, 2), 4, 12, 0.06F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.PUMPKIN, 1), new ItemStack(Items.EMERALD, 2), 4, 12, 0.10F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.PUMPKIN_PIE, 1), new ItemStack(Items.EMERALD, 2), 4, 12, 0.09F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.PUMPKIN_SEEDS, nonNullRandom(15)), new ItemStack(Items.EMERALD, 2), 4, 12, 0.12F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.REDSTONE, nonNullRandom(32)), new ItemStack(Items.EMERALD, 2), 4, 12, 0.12F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, nonNullRandom(10)), new ItemStack(Items.EMERALD, 2), 4, 12, 0.12F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.SPIDER_EYE, nonNullRandom(10)), new ItemStack(Items.EMERALD, 2), 4, 12, 0.12F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.STRING, nonNullRandom(10)), new ItemStack(Items.EMERALD, 2), 4, 12, 0.12F));
            }
        }
    }

    @SubscribeEvent
    protected static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof Player player) {

            switch (player.getMainHandItem().getItem().toString()) {
                case ("alexandrov5_dark"), ("corenovka_dark"), ("pottyos_dark"), ("svitlogorie_dark"), ("vkusnoteevo_dark") ->
                        player.addEffect(new MobEffectInstance(Objects.requireNonNull(TuroLists.getRandEffect()), nonNullRandom(1200), 1));
                case ("alexandrov26_dark"), ("rostagroexport_dark") ->
                        player.addEffect(new MobEffectInstance(Objects.requireNonNull(TuroLists.getRandEffect()), nonNullRandom(1500), 1));
                case ("preobrajenskiy_dark"), ("vologosha_dark") ->
                        player.addEffect(new MobEffectInstance(TuroLists.getRandEffect(), 600, 1));
            }
        }
    }

    private static int nonNullRandom(Integer limit) {
        int randNum = new Random().nextInt(limit);
        if(randNum == 0){
            randNum = randNum + 1;
        }
        return randNum;
    }

    public static <T extends Block> RegistryObject<T> registerBlock(DeferredRegister<Block> BLOCKS, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(TuroCreativeTabs.ITEMTAB)));
    }

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, TUROMAKER_DARK_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
