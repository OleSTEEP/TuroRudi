package com.olesteep.turorudi.villager;

import com.google.common.collect.ImmutableSet;
import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.block.TuroBlocks;
import com.olesteep.turorudi.data.TuroList;
import com.olesteep.turorudi.fluid.TuroFluidCondensedMilkHolder;
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
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TuroRudi.MOD_ID);

    public static final RegistryObject<PoiType> TUROMAKER_POI = POI_TYPES.register("turomaker_poi", () -> new PoiType(ImmutableSet.copyOf(TuroBlocks.TURO_BLOCK.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> TUROMAKER = VILLAGER_PROFESSIONS.register("turomaker", () -> new VillagerProfession("turomaker", x -> x.get() == TUROMAKER_POI.get(), x -> x.get() == TUROMAKER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if(event.getType() == TuroVillagers.TUROMAKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Sold
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.BANANA.get(), nonNullRandom()),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.BLUEBERRY.get(), nonNullRandom()),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(TuroItems.CARAMEL.get(), nonNullRandom()),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.CHERRY.get(), nonNullRandom()),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(TuroItems.CHOCOLATE.get(), nonNullRandom()),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.CHOCOLATE_BAD.get(), nonNullRandom()),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(TuroItems.CHOCOLATE_MILK.get(), nonNullRandom()),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(TuroItems.CHOCOLATE_WHITE.get(), nonNullRandom()),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.COCO.get(), nonNullRandom()),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(TuroItems.CURD.get(), nonNullRandom()),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.CURD_BAD.get(), nonNullRandom()),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(TuroItems.GLAZE.get(), nonNullRandom()),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(TuroFluidCondensedMilkHolder.BUCKET.get(), 1),4,12,0.18F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(TuroItems.MILK_FAT.get(), nonNullRandom()),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.LEMON.get(), nonNullRandom()),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.LIME.get(), nonNullRandom()),4,12,0.18F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.ORANGE.get(), nonNullRandom()),4,12,0.18F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 6), new ItemStack(TuroItems.TURORUDI.get(), nonNullRandom()),4,12,0.18F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(TuroItems.TURORUDI_BAD.get(), nonNullRandom()),4,12,0.18F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 8), new ItemStack(TuroList.getRandGood(), nonNullRandom()),4,12,0.12F));
            trades.get(4).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(TuroList.getRandBad(), nonNullRandom()),4,12,0.16F));

            // Buy
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.BANANA.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.BLUEBERRY.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CARAMEL.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 3),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHERRY.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHOCOLATE.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 3),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHOCOLATE_BAD.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHOCOLATE_MILK.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 3),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CHOCOLATE_WHITE.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 3),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.COCO.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CURD.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.CURD_BAD.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.GLAZE.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 3),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroFluidCondensedMilkHolder.BUCKET.get(), 1), new ItemStack(Items.EMERALD, 3),4,12,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.MILK_FAT.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 3),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.LEMON.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.LIME.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.ORANGE.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.TURORUDI.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 4),4,12,0.09F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(TuroItems.TURORUDI_BAD.get(), nonNullRandom()), new ItemStack(Items.EMERALD, 2),4,12,0.09F));
        }
    }

    private static int nonNullRandom() {
        int randNum = new Random().nextInt(5);
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