package com.olesteep.turorudi.data;

import com.olesteep.turorudi.item.*;
import net.minecraft.world.item.Item;

import java.util.Random;

public class TuroList {
    public static Random random = new Random();

    public static Item getRandGood() {
        Item[] list = {Alexandrov.ALEX_VANILLA5.get(),
                Alexandrov.ALEX_VANILLA26.get(),
                Alexandrov.ALEX_CHOCOLESS.get(),
                Alexandrov.ALEX_COND.get(),
                Alexandrov.ALEX_MILK5.get(),
                Alexandrov.ALEX_MILK26.get(),
                Alexandrov.ALEX_POTATO.get(),
                Alexandrov.ALEX_SOUFFLE.get(),
                Alexandrov.ALEX_SOUFFLE_MILK.get(),
                Alexandrov.ALEX_WHITE.get(),
                Corenovka.CORENOVKA_VANILLA.get(),
                Corenovka.CORENOVKA_CARAMEL.get(),
                Corenovka.CORENOVKA_ORANGE.get(),
                Corenovka.CORENOVKA_LEMON_LIME.get(),
                Pottyos.POTTYOS_VANILLA.get(),
                Pottyos.POTTYOS_MILK.get(),
                Pottyos.POTTYOS_STRAW.get(),
                Pottyos.POTTYOS_APRICOT.get(),
                Svitlogorie.SVITL_VANILLA.get(),
                Svitlogorie.SVITL_COCOA.get(),
                Svitlogorie.SVITL_COCO.get(),
                Svitlogorie.SVITL_COCO_GLAZE.get(),
                Svitlogorie.SVITL_COOKIE.get(),
                Svitlogorie.SVITL_VANILLA_GLAZE.get(),
                Svitlogorie.SVITL_LEMON.get(),
                Svitlogorie.SVITL_POTATO.get(),
                Svitlogorie.SVITL_STRAW.get(),
                Vkusnoteevo.VKUSN_VANILLA.get(),
                Vkusnoteevo.VKUSN_COCOA.get(),
                Vkusnoteevo.VKUSN_COND.get()
        };
        int item = random.nextInt(list.length);
        return list[item];
    }

    public static Item getRandBad() {
        Item[] list = {Preobrajenskiy.PREOBR_VANILLA.get(),
                Preobrajenskiy.PREOBR_COCOA.get(),
                Preobrajenskiy.PREOBR_PREM_VANILLA.get(),
                Vologosha.VOLOG_VANILLA.get(),
                Vologosha.VOLOG_BANANA.get(),
                Vologosha.VOLOG_BLBERRY.get(),
                Vologosha.VOLOG_CHERRY.get(),
                Vologosha.VOLOG_COCOA.get(),
                Vologosha.VOLOG_COND.get(),
                Vologosha.VOLOG_ORANGE.get(),
                Vologosha.VOLOG_STRAW.get()
        };
        int item = random.nextInt(list.length);
        return list[item];
    }
}
