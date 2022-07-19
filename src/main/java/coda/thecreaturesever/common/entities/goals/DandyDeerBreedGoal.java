package coda.thecreaturesever.common.entities.goals;

import coda.thecreaturesever.common.entities.DandyDeerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class DandyDeerBreedGoal extends Goal {
    private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();
    protected final DandyDeerEntity animal;
    private final Class<? extends DandyDeerEntity> mateClass;
    protected final Level world;
    protected DandyDeerEntity targetMate;
    private int spawnBabyDelay;
    private final double moveSpeed;

    public DandyDeerBreedGoal(DandyDeerEntity animal, double speedIn) {
        this(animal, speedIn, animal.getClass());
    }

    public DandyDeerBreedGoal(DandyDeerEntity animal, double moveSpeed, Class<? extends DandyDeerEntity> mateClass) {
        this.animal = animal;
        this.world = animal.level;
        this.mateClass = mateClass;
        this.moveSpeed = moveSpeed;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        assert !this.animal.isBaby();

        if (!this.animal.isInLove() || this.animal.isBaby()) {
            return false;
        }
        else if (animal.level.getBiome(animal.blockPosition()).is(Biomes.FLOWER_FOREST)) {
            this.targetMate = this.getNearbyMate();
            return this.targetMate != null;
        }
        else {
            return false;
        }
    }

    public boolean canContinueToUse() {
        return this.targetMate.isAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
    }

    public void stop() {
        this.targetMate = null;
        this.spawnBabyDelay = 0;
    }

    public void tick() {
        this.animal.getLookControl().setLookAt(this.targetMate, 10.0F, (float)this.animal.getMaxHeadXRot());
        this.animal.getNavigation().moveTo(this.targetMate, this.moveSpeed);
        ++this.spawnBabyDelay;
        if (this.spawnBabyDelay >= 60 && this.animal.distanceToSqr(this.targetMate) < 9.0D) {
            this.spawnBaby();
        }

    }

    @Nullable
    private DandyDeerEntity getNearbyMate() {
        List<? extends DandyDeerEntity> list = this.world.getNearbyEntities(this.mateClass, PARTNER_TARGETING, this.animal, this.animal.getBoundingBox().inflate(20.0D));
        double d0 = Double.MAX_VALUE;
        DandyDeerEntity animalentity = null;

        for (DandyDeerEntity dandyDeer : list) {
            if (this.animal.canMate(dandyDeer) && this.animal.distanceToSqr(dandyDeer) < d0 && !dandyDeer.isBaby()) {
                animalentity = dandyDeer;
                d0 = this.animal.distanceToSqr(dandyDeer);
            }
        }

        return animalentity;
    }

    protected void spawnBaby() {
        this.animal.spawnChildFromBreeding((ServerLevel) this.world, this.targetMate);
    }
}