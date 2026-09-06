package net.cacaique.TutorialMod;

import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, ModTutorial.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> SCORCHMELT_TYPE = FLUID_TYPES.register(
            "scorchmelt",
            () -> new FluidType(FluidType.Properties.create()
                    .lightLevel(15)             // ilumina igual lava
                    .density(4500)               // mais denso que lava (lava = 3000)
                    .viscosity(9000)             // mais grosso/lento que lava (lava = 6000)
                    .temperature(2200)           // mais quente que lava (lava = 1300)
                    .canConvertToSource(false)
                    .canDrown(false)
                    .canExtinguish(true)
                    .canHydrate(false)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
            ));
}