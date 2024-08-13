package com.ordana.spelunkery.blocks;

import com.ordana.spelunkery.reg.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

public class TangleRootsBlockBlock extends Block implements BonemealableBlock {

    public TangleRootsBlockBlock(Properties properties) {
        super(properties);
    }


    protected boolean canGrowInto(BlockState state) {
        return NetherVines.isValidGrowthState(state) || state.getFluidState().is(Fluids.WATER);
    }

    public static int getBlocksToGrowWhenBonemealed(RandomSource random) {
        double d = 1.0;

        int i;
        for(i = 0; random.nextDouble() < d; ++i) {
            d *= 0.826;
        }

        return i;
    }

    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return this.canGrowInto(level.getBlockState(pos.below()));
    }

    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.below();
        int i = 1;
        int j = getBlocksToGrowWhenBonemealed(random);

        for(int k = 0; k < j && this.canGrowInto(level.getBlockState(blockPos)); ++k) {
            level.setBlockAndUpdate(blockPos, ModBlocks.TANGLE_ROOTS.get().defaultBlockState().setValue(TangleRootsHeadBlock.AGE, i));
            blockPos = blockPos.below();
            i = Math.min(i + 1, 25);
        }

    }
}