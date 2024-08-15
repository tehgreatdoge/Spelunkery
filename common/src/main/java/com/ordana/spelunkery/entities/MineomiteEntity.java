package com.ordana.spelunkery.entities;

import com.ordana.spelunkery.blocks.GlowstickBlock;
import com.ordana.spelunkery.blocks.MineomiteBlock;
import com.ordana.spelunkery.reg.ModBlocks;
import com.ordana.spelunkery.reg.ModEntities;
import com.ordana.spelunkery.reg.ModItems;
import net.mehvahdjukaar.moonlight.api.entity.ImprovedProjectileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class MineomiteEntity extends ImprovedProjectileEntity {

    public MineomiteEntity(EntityType<? extends MineomiteEntity> type, Level world) {
        super(type, world);
    }

    public MineomiteEntity(Level level, LivingEntity thrower) {
        super(ModEntities.MINEOMITE.get(), thrower, level);
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.MINEOMITE.get();
    }

    public static boolean canPlace (BlockState state) {
        return state.isAir() || state.canBeReplaced() || state.is(ModBlocks.MINEOMITE.get());
    }

    protected void onHit(HitResult result) {
        if (result instanceof BlockHitResult bResult) placeGlowstick(level, bResult);
        super.onHit(result);
    }

    public void placeGlowstick(Level level, BlockHitResult hitResult) {

        Direction dir = hitResult.getDirection();
        BlockPos pos = hitResult.getBlockPos();
        BlockPos relativePos = pos.relative(dir);
        BlockState replaceState = level.getBlockState(relativePos);
        BlockState placeState = ModBlocks.MINEOMITE.get().defaultBlockState().setValue(RodBlock.FACING, dir).setValue(GlowstickBlock.WATERLOGGED, replaceState.getFluidState().is(Fluids.WATER));
        var sticks = 1;

        if (replaceState.is(ModBlocks.MINEOMITE.get()) && replaceState.getValue(MineomiteBlock.STICKS) < 9) sticks = replaceState.getValue(MineomiteBlock.STICKS) + 1;
        if (canPlace(replaceState)) level.setBlockAndUpdate(relativePos, placeState.setValue(MineomiteBlock.STICKS, sticks));
        else level.addFreshEntity(new ItemEntity(level, relativePos.getX(), relativePos.getY(), relativePos.getZ(), new ItemStack(getDefaultItem())));

        this.remove(RemovalReason.DISCARDED);
    }
}
