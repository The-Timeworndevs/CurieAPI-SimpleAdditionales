package net.timeworndevs.curiecontent.entities.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.timeworndevs.curiecontent.registries.CurieContentEntities;
import net.timeworndevs.curieapi.radiation.RadiationType;
import net.timeworndevs.curieapi.radiation.RadiationData;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import static net.timeworndevs.curieapi.util.CurieAPIConfig.RADIATION_TYPES;


public class MonstrosityEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState walkAnimationState = new AnimationState();

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta*6.0f, 1.0f): 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    public MonstrosityEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createMonstrosityAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, .5f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, .2f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new AttackGoal(this));
        this.goalSelector.add(2, new SwimGoal(this));
        this.goalSelector.add(3, new EscapeDangerGoal(this, 0.5f));
        this.goalSelector.add(4, new WanderNearTargetGoal(this, 0.4f, 20));
        this.goalSelector.add(5, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.3f, 0.001f));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return CurieContentEntities.MONSTROSITY.create(world);
    }

    private void updateAnimation() {
        if (this.idleAnimationTimeout <= 0 && this.getVelocity().horizontalLengthSquared() <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.getVelocity().horizontalLengthSquared() > 0)
        {
            this.idleAnimationTimeout = 0;
            this.idleAnimationState.stop();
            if (!this.walkAnimationState.isRunning())
            {
                this.walkAnimationState.start(this.age);
            }
        } else {
            this.walkAnimationState.stop();
        }
    }
    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            updateAnimation();
        }

        if (this.getTarget()!=null) {
            if (this.getTarget() instanceof PlayerEntity player) {
                if (player.getRecentDamageSource() != null) {
                    if (player.getRecentDamageSource().getSource() == this && this.isAlive()) { //check if entity attacked the player
                        ArrayList<RadiationType> radiations = new ArrayList<>(RADIATION_TYPES.values());
                        RadiationData.addRad(player, radiations.get(random.nextInt(radiations.size())), random.nextInt(4800)); //add random amount of random radiation kind
                        this.kill(); // kill the goober
                    }
                }

            }

        }
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CAT_STRAY_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ALLAY_DEATH;
    }
}
