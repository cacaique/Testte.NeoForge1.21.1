package net.cacaique.TutorialMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, ModTutorial.MOD_ID);

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SCORCHMELT_SOURCE = FLUIDS.register(
            "scorchmelt",
            () -> new BaseFlowingFluid.Source(SCORCHMELT_PROPERTIES));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> SCORCHMELT_FLOWING = FLUIDS.register(
            "flowing_scorchmelt",
            () -> new BaseFlowingFluid.Flowing(SCORCHMELT_PROPERTIES));

    public static final BaseFlowingFluid.Properties SCORCHMELT_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.SCORCHMELT_TYPE, SCORCHMELT_SOURCE, SCORCHMELT_FLOWING)
            .slopeFindDistance(4)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.SCORCHMELT_BLOCK)
            .bucket(ModItems.SCORCHMELT_BUCKET);
}