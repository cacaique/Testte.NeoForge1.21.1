package net.cacaique.TutorialMod;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * BaseFlowingFluid (NeoForge) não reimplementa o comportamento de "atear fogo em
 * blocos inflamáveis próximos" que a lava vanilla tem (isso vive só em LavaFluid#randomTick,
 * uma classe que não conseguimos estender). Então replicamos a mesma lógica aqui e chamamos
 * ela a partir do randomTick das nossas classes de fluido (ScorchmeltSourceFluid / ScorchmeltFlowingFluid).
 */
final class ScorchmeltFireBehavior {

    private ScorchmeltFireBehavior() {
    }

    static void spreadFire(Level level, BlockPos pos, RandomSource random) {
        if (!level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            return;
        }

        int i = random.nextInt(3);
        if (i > 0) {
            BlockPos target = pos;
            for (int j = 0; j < i; ++j) {
                target = target.offset(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
                if (!level.isLoaded(target)) {
                    return;
                }
                BlockState state = level.getBlockState(target);
                if (state.isAir()) {
                    if (hasFlammableNeighbours(level, target)) {
                        level.setBlockAndUpdate(target, BaseFireBlock.getState(level, target));
                        return;
                    }
                } else if (state.blocksMotion()) {
                    return;
                }
            }
        } else {
            for (int k = 0; k < 3; ++k) {
                BlockPos target = pos.offset(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                if (!level.isLoaded(target)) {
                    return;
                }
                if (level.isEmptyBlock(target.above()) && isFlammable(level, target)) {
                    level.setBlockAndUpdate(target.above(), BaseFireBlock.getState(level, target.above()));
                }
            }
        }
    }

    private static boolean hasFlammableNeighbours(LevelReader level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (isFlammable(level, pos.relative(direction))) {
                return true;
            }
        }
        return false;
    }

    // ignitedByLava() sem argumentos está deprecated no NeoForge 1.21.x (ainda funciona,
    // só recomendam a sobrecarga com posição/direção quando disponível). Como aqui é só
    // uma checagem simples "esse bloco pega fogo com lava?", o método antigo é suficiente.
    @SuppressWarnings("deprecation")
    private static boolean isFlammable(LevelReader level, BlockPos pos) {
        return level.getBlockState(pos).ignitedByLava();
    }
}