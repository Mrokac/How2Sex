
package net.mcreator.howsex.entity;

import net.mcreator.howsex.procedures.ExplosionMakerProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.world.ForgeChunkManager;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.howsex.init.HowsexModEntities;

public class IntercontinentalThermonuclearBallisticMissileEntity extends Monster {
	public static final EntityDataAccessor<Integer> StateData = SynchedEntityData.defineId(IntercontinentalThermonuclearBallisticMissileEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<String> GoalData = SynchedEntityData.defineId(IntercontinentalThermonuclearBallisticMissileEntity.class, EntityDataSerializers.STRING);

	double vel = 0;
	boolean exploded = false;

	public IntercontinentalThermonuclearBallisticMissileEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(HowsexModEntities.INTERCONTINENTAL_THERMONUCLEAR_BALLISTIC_MISSILE.get(), world);
	}

	public IntercontinentalThermonuclearBallisticMissileEntity(EntityType<IntercontinentalThermonuclearBallisticMissileEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(true);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.attack"));
	}

	public static void init() {
//		SpawnPlacements.register(HowsexModEntities.INTERCONTINENTAL_THERMONUCLEAR_BALLISTIC_MISSILE.get(), SpawnPlacements.Type.ON_GROUND,
//				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL
//						&& Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 1000000);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (source.getDirectEntity() instanceof Player)
			return false;
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source == DamageSource.FALL)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		if (source == DamageSource.LIGHTNING_BOLT)
			return false;
		if (source.isExplosion())
			return false;
		if (source.getMsgId().equals("trident"))
			return false;
		if (source == DamageSource.ANVIL)
			return false;
		if (source == DamageSource.DRAGON_BREATH)
			return false;
		if (source == DamageSource.WITHER)
			return false;
		if (source.getMsgId().equals("witherSkull"))
			return false;
		return super.hurt(source, amount);
	}

	public int distanceToGoal() {
		double a = Math.abs(this.getX() - getGoal().x);
		double b = Math.abs(this.getX() - getGoal().z);
		return (int) Math.floor(Math.sqrt(a*a + b*b));
	}

	@Override
	public void tick() {
		if(getStateData() == 1) {
			if(vel < 3.5D)
				vel += 0.02D;
			this.setPos(this.getX(), this.getY() + vel, this.getZ());

			if (this.getLevel() instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, this.getX(), (this.getY() - 2), this.getZ(), 100, 1, 1, 1, 0.025);
			if (this.getLevel() instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, this.getX(), this.getY(), this.getZ(), 50, 0.5, 0.5, 0.5, 0.1);
//			if(level instanceof ServerLevel serverLevel)
//				ForgeChunkManager.forceChunk(serverLevel, "howsex", this, this.chunkPosition().x, this.chunkPosition().z, true, true)
			if(this.getY() > 1000 + distanceToGoal()) {
				setStateData(2);
			}
		}
		if(getStateData() == 2) {
			this.lerpHeadTo(0, 90);
			this.setPos(getGoal().x, this.getY()-5, getGoal().z);

			if(!level.getBlockState(new BlockPos(this.getX(), this.getY(), this.getZ()))
					.getBlock().equals(Blocks.AIR) &&
					!level.getBlockState(new BlockPos(this.getX(), this.getY(), this.getZ()))
					.getBlock().equals(Blocks.VOID_AIR) &&
					!level.getBlockState(new BlockPos(this.getX(), this.getY(), this.getZ()))
					.getBlock().equals(Blocks.CAVE_AIR)) {
				if(!exploded) {
					ExplosionMakerProcedure.execute(level, this.getX(), this.getY(), this.getZ(), 75);
					this.discard();
					exploded = true;
				}
			}
		}

	}

	public void launch(Goal thegoal) {
		setStateData(1);
		setGoal(thegoal.toString());
	}

	public static class Goal {
		public double x;
		public double z;

		public Goal(double x, double z) {
			this.x = x;
			this.z = z;
		}

		public String toString() {
			return ((int) Math.round(x)) + "#" + ((int) Math.round(z));
		}

		public static IntercontinentalThermonuclearBallisticMissileEntity.Goal from(String input) {
			String[] values = input.split("#");
			double value1 = Double.parseDouble(values[0]);
			double value2 = Double.parseDouble(values[1]);
			return new Goal(value1, value2);
		}
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(StateData, 0);
		this.entityData.define(GoalData, "0|0");
	}

	public void setStateData(int varIn) {
		this.entityData.set(StateData, varIn);
	}

	public int getStateData() {
		return this.entityData.get(StateData);
	}

	public void setGoal(String goal) {
		this.entityData.set(GoalData, goal);
	}

	public Goal getGoal() {
		return Goal.from(this.entityData.get(GoalData));
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("StateData", this.getStateData());
		compound.putString("Goal", this.getGoal().toString());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setStateData(compound.getInt("StateData"));
		this.setGoal(compound.getString("Goal"));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}
}
