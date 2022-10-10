package com.olesteep.turorudi.world.village;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Lifecycle;
import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.mixin.SingleJigsawAccess;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;


// Thanks https://github.com/BluSunrize/ImmersiveEngineering/blob/1.18.2/src/main/java/blusunrize/immersiveengineering/common/world/Villages.java for example
public class TuroVillagePools {
    public static void init()
    {
        PlainVillagePools.bootstrap();
        SnowyVillagePools.bootstrap();
        SavannaVillagePools.bootstrap();
        DesertVillagePools.bootstrap();
        TaigaVillagePools.bootstrap();

        // Register engineer's houses for each biome
        for(String biome : new String[]{"plains", "snowy", "savanna", "desert", "taiga"})
            addToPool(new ResourceLocation("village/"+biome+"/houses"), new ResourceLocation(TuroRudi.MOD_ID, "village/houses/"+biome+"_turohouse"), 3);
    }

    private static void addToPool(ResourceLocation pool, ResourceLocation toAdd, int weight)
    {
        StructureTemplatePool old = BuiltinRegistries.TEMPLATE_POOL.get(pool);
        int id = BuiltinRegistries.TEMPLATE_POOL.getId(old);

        // Fixed seed to prevent inconsistencies between different worlds
        List<StructurePoolElement> shuffled;
        if(old!=null)
            shuffled = old.getShuffledTemplates(RandomSource.create(0));
        else
            shuffled = ImmutableList.of();
        Object2IntMap<StructurePoolElement> newPieces = new Object2IntLinkedOpenHashMap<>();
        for(StructurePoolElement p : shuffled)
            newPieces.computeInt(p, (StructurePoolElement pTemp, Integer i) -> (i==null?0: i)+1);
        newPieces.put(SingleJigsawAccess.construct(Either.left(toAdd), ProcessorLists.EMPTY, StructureTemplatePool.Projection.RIGID), weight);
        List<Pair<StructurePoolElement, Integer>> newPieceList = newPieces.object2IntEntrySet().stream().map(e -> Pair.of(e.getKey(), e.getIntValue())).collect(Collectors.toList());

        ResourceLocation name = old.getName();
        ((WritableRegistry<StructureTemplatePool>)BuiltinRegistries.TEMPLATE_POOL).registerOrOverride(OptionalInt.of(id), ResourceKey.create(BuiltinRegistries.TEMPLATE_POOL.key(), name), new StructureTemplatePool(pool, name, newPieceList), Lifecycle.stable());
    }
}
