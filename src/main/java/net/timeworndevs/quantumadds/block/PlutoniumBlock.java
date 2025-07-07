package net.timeworndevs.quantumadds.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.timeworndevs.quantumadds.Quantum;
import net.timeworndevs.quantumadds.registries.QuantumRadiationTypes;
import net.timeworndevs.quantumadds.util.IEntityDataSaver;
import net.timeworndevs.quantumadds.radiation.RadiationData;

public class PlutoniumBlock extends Block {

    public boolean supercritical = false;

    public PlutoniumBlock(Settings settings) {
        super(settings);
    }


    public int sc_ticks = 0;
    public int end_sc_ticks = 0;

    public void goSupercritical(World world, BlockPos pos, Integer ticks) {
        end_sc_ticks = ticks;
        this.supercritical = true;
        Quantum.LOGGER.error("SUPERCRITICAL");

        var closestPlayer = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 25, true);
        if (closestPlayer != null && !world.isClient()) {
            RadiationData.addRad((IEntityDataSaver) closestPlayer, QuantumRadiationTypes.ALPHA, new java.util.Random().nextInt(1500));
            RadiationData.addRad((IEntityDataSaver) closestPlayer, QuantumRadiationTypes.BETA, new java.util.Random().nextInt(1250));
            RadiationData.addRad((IEntityDataSaver) closestPlayer, QuantumRadiationTypes.GAMMA, new java.util.Random().nextInt(1000));
            RadiationData.addRad((IEntityDataSaver) closestPlayer, QuantumRadiationTypes.RADIATION_TYPES.get("neutron"), new java.util.Random().nextInt(4000));
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (supercritical) {
            for (int i = 0; i < 100; i++) {
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                        pos.getX(), pos.getY()+1, pos.getZ(), (double) random.nextBetween(-10, 10) /20, 0, (double) random.nextBetween(-10, 10) /20);
            }
            sc_ticks++;
            if (end_sc_ticks<sc_ticks) {
                this.end_sc_ticks = 0;
                this.sc_ticks = 0;
                this.supercritical = false;
            }
        }
    }
}