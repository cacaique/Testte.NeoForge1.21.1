package net.cacaique.TutorialMod;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ModTutorial.MOD_ID);

    public static final DeferredBlock<LiquidBlock> SCORCHMELT_BLOCK = BLOCKS.register(
            "scorchmelt",
            () -> new LiquidBlock(ModFluids.SCORCHMELT_SOURCE.get(),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_RED)
                            .lightLevel(state -> 15)
                            .noLootTable()
                            .liquid()));
}