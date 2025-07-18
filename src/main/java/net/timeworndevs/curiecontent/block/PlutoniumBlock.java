package net.timeworndevs.curiecontent.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.World;
import net.timeworndevs.curieapi.radiation.RadiationData;
import net.timeworndevs.curiecontent.CurieContent;
import net.timeworndevs.curiecontent.registries.CurieContentRadiationTypes;

import java.util.Random;

public class PlutoniumBlock extends Block {
    private static final Random random = new Random();
    public boolean supercritical = false;

    public PlutoniumBlock(Settings settings) {
        super(settings);
    }


    public int sc_ticks = 0;
    public int end_sc_ticks = 0;

    public void goSupercritical(World world, BlockPos pos, Integer ticks) {

        end_sc_ticks = ticks;
        this.supercritical = true;
        CurieContent.LOGGER.error("SUPERCRITICAL");

        var closestPlayer = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 25, true);
        if (closestPlayer != null && !world.isClient()) {
            RadiationData.addRad(closestPlayer, CurieContentRadiationTypes.ALPHA, random.nextInt(1500));
            RadiationData.addRad(closestPlayer, CurieContentRadiationTypes.BETA, random.nextInt(1250));
            RadiationData.addRad(closestPlayer, CurieContentRadiationTypes.GAMMA, random.nextInt(1000));
            RadiationData.addRad(closestPlayer, CurieContentRadiationTypes.NEUTRON, random.nextInt(4000));
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if (supercritical) {
            for (int i = 0; i < 100; i++) {
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                        pos.getX(), pos.getY() + 1, pos.getZ(), (double) random.nextBetween(-10, 10) / 20, 0, (double) random.nextBetween(-10, 10) / 20);
            }
            sc_ticks++;
            if (end_sc_ticks < sc_ticks) {
                this.end_sc_ticks = 0;
                this.sc_ticks = 0;
                this.supercritical = false;
            }
        }
    }
}