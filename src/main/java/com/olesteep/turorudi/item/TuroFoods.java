package com.olesteep.turorudi.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class TuroFoods {
    public static final FoodProperties TURO_BASE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).build();

    public static final FoodProperties TURO_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_VANILLA = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_VANILLA_CHOCOLESS = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.INVISIBILITY, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_VANILLA_FAT = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.8F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3000, 1), 1.0F).build();

    public static final FoodProperties TURO_VANILLA_MILK = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_VANILLA_FAT_MILK = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.8F).effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3000, 1), 1.0F).build();

    public static final FoodProperties TURO_BLBERRY = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_CHERRY = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 3400, 1), 1.0F).build();

    public static final FoodProperties TURO_COCOA = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_COCO = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_COCO_GLAZE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_COND = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_GLAZE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_LEMON = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_ORANGE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.SATURATION, 3000, 1), 1.0F).build();

    public static final FoodProperties TURO_POTATO = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_STRAW = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_SOUFFLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_SOUFFLE_MILK = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2400, 1), 1.0F).build();

    public static final FoodProperties TURO_WHITE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.JUMP, 2400, 1), 1.0F).build();


    public static final FoodProperties TURO_VANILLA_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_VANILLA_CHOCOLESS_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_VANILLA_FAT_BAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.9F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_VANILLA_MILK_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_VANILLA_FAT_MILK_BAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.9F).effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1500, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_BLBERRY_BAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_CHERRY_BAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.REGENERATION, 1700, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_COCOA_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_COCO_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_COCO_GLAZE_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_COND_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_GLAZE_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_LEMON_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_ORANGE_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.SATURATION, 1500, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_POTATO_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_STRAW_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_SOUFFLE_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_SOUFFLE_MILK_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

    public static final FoodProperties TURO_WHITE_BAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.JUMP, 1200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 0), 1.0F).build();

}