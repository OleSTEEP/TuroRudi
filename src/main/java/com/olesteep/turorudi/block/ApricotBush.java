package com.olesteep.turorudi.block;

import com.olesteep.turorudi.TuroRudi;
import com.olesteep.turorudi.item.TuroItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import static com.olesteep.turorudi.registry.BlockRegisters.registerBlockWithoutItem;

public class ApricotBush {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuroRudi.MOD_ID);

    public static final RegistryObject<Block> APRICOT_BUSH = registerBlockWithoutItem(BLOCKS, "apricot_bush", () -> new SweetBerryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH)) {
        @Override
        public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter block, @NotNull BlockPos pos, @NotNull BlockState state) {
            return new ItemStack(TuroItems.APRICOT.get());
        }

        @Override
        public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
            int i = blockState.getValue(AGE);
            boolean flag = i == 3;
            if (!flag && player.getItemInHand(interactionHand).is(Items.BONE_MEAL)) {
                return InteractionResult.PASS;
            } else if (i > 1) {
                int j = 1 + level.random.nextInt(2);
                popResource(level, blockPos, new ItemStack(TuroItems.APRICOT.get(), j + (flag ? 1 : 0)));
                level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                level.setBlock(blockPos, blockState.setValue(AGE, 1), 2);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
            }
        }
    });

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
