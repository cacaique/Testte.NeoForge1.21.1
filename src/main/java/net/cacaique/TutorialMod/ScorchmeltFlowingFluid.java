package net.cacaique.TutorialMod;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public class ScorchmeltFlowingFluid extends BaseFlowingFluid.Flowing {
    public ScorchmeltFlowingFluid(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(Level level, BlockPos pos, FluidState state, RandomSource random) {
        super.randomTick(level, pos, state, random);
        ScorchmeltFireBehavior.spreadFire(level, pos, random);
    }
}