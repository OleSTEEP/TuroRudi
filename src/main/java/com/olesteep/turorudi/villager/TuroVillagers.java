package com.olesteep.turorudi.villager;

import com.google.common.collect.ImmutableSet;
import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.block.TuroBlocks;
import com.olesteep.turorudi.item.*;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = TuroRudi.MOD_ID)
public class TuroVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, TuroRudi.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, TuroRudi.MOD_ID);

    public static final RegistryObject<PoiType> TUROMAKER_POI = POI_TYPES.register("turomaker_poi", () -> new PoiType("turomaker_poi", PoiType.getBlockStates(TuroBlocks.TURO_BLOCK.get()), 1, 1));

    public static final RegistryObject<VillagerProfession> TUROMAKER = VILLAGER_PROFESSIONS.register("turomaker", () -> new VillagerProfession("turomaker", TUROMAKER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if(event.getType() == TuroVillagers.TUROMAKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Sold
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.BANANA.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.BLUEBERRY.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(5)), new ItemStack(TuroItems.CARAMEL.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.CHERRY.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(TuroItems.CHOCOLATE.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.CHOCOLATE_BAD.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(TuroItems.CHOCOLATE_MILK.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(TuroItems.CHOCOLATE_WHITE.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.COCO.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(3)), new ItemStack(TuroItems.CURD.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.CURD_BAD.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(5)), new ItemStack(TuroItems.GLAZE.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(TuroItems.MILK_COND_BUCKET.get(), 1),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(5)), new ItemStack(TuroItems.MILK_FAT.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.LEMON.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.LIME.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.ORANGE.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(7)), new ItemStack(TuroItems.TURORUDI.get(), nonNullRandom(5)),4,12,0.18F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(4)), new ItemStack(TuroItems.TURORUDI_BAD.get(), nonNullRandom(5)),4,12,0.18F));

            // Buy
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.BANANA.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.BLUEBERRY.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CARAMEL.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(5)),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHERRY.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHOCOLATE.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(6)),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHOCOLATE_BAD.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHOCOLATE_MILK.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(6)),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHOCOLATE_WHITE.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(6)),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.COCO.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CURD.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(3)),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CURD_BAD.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.GLAZE.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(5)),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.MILK_COND_BUCKET.get(), 1), new ItemStack(Items.EMERALD, nonNullRandom(6)),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.MILK_FAT.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(5)),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.LEMON.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.LIME.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.ORANGE.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.TURORUDI.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(7)),4,12,0.09F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.TURORUDI_BAD.get(), nonNullRandom(5)), new ItemStack(Items.EMERALD, nonNullRandom(4)),4,12,0.09F));

            // Turorudi
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_VANILLA5.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_VANILLA26.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_CHOCOLESS.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_COND.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_MILK5.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_MILK26.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_POTATO.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_SOUFFLE.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_SOUFFLE_MILK.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Alexandrov.ALEX_WHITE.get(), nonNullRandom(5)),4,12,0.12F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Corenovka.CORENOVKA_VANILLA.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Corenovka.CORENOVKA_CARAMEL.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Corenovka.CORENOVKA_ORANGE.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Corenovka.CORENOVKA_LEMON_LIME.get(), nonNullRandom(5)),4,12,0.12F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Pottyos.POTTYOS_VANILLA.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Pottyos.POTTYOS_MILK.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Pottyos.POTTYOS_STRAW.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Pottyos.POTTYOS_APRICOT.get(), nonNullRandom(5)),4,12,0.12F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Preobrajenskiy.PREOBR_VANILLA.get(), nonNullRandom(5)),4,12,0.16F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Preobrajenskiy.PREOBR_COCOA.get(), nonNullRandom(5)),4,12,0.16F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(7)), new ItemStack(Preobrajenskiy.PREOBR_PREM_VANILLA.get(), nonNullRandom(5)),4,12,0.16F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Svitlogorie.SVITL_VANILLA.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Svitlogorie.SVITL_COCOA.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Svitlogorie.SVITL_COCO.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Svitlogorie.SVITL_COCO_GLAZE.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Svitlogorie.SVITL_COOKIE.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Svitlogorie.SVITL_VANILLA_GLAZE.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Svitlogorie.SVITL_LEMON.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Svitlogorie.SVITL_POTATO.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Svitlogorie.SVITL_STRAW.get(), nonNullRandom(5)),4,12,0.12F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Vkusnoteevo.VKUSN_VANILLA.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Vkusnoteevo.VKUSN_COCOA.get(), nonNullRandom(5)),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(10)), new ItemStack(Vkusnoteevo.VKUSN_COND.get(), nonNullRandom(5)),4,12,0.12F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Vologosha.VOLOG_VANILLA.get(), nonNullRandom(5)),4,12,0.16F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Vologosha.VOLOG_BANANA.get(), nonNullRandom(5)),4,12,0.16F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Vologosha.VOLOG_BLBERRY.get(), nonNullRandom(5)),4,12,0.16F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Vologosha.VOLOG_CHERRY.get(), nonNullRandom(5)),4,12,0.16F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Vologosha.VOLOG_COCOA.get(), nonNullRandom(5)),4,12,0.16F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Vologosha.VOLOG_COND.get(), nonNullRandom(5)),4,12,0.16F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Vologosha.VOLOG_ORANGE.get(), nonNullRandom(5)),4,12,0.16F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, nonNullRandom(6)), new ItemStack(Vologosha.VOLOG_STRAW.get(), nonNullRandom(5)),4,12,0.16F));
        }
    }

    private static int nonNullRandom(Integer nextInt) {
        int randNum = new Random().nextInt(nextInt);
        if(randNum == 0){
            randNum = randNum + 1;
        }
        return randNum;
    }

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, TUROMAKER_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}