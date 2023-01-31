package net.mcreator.howsex.procedures;

import net.mcreator.howsex.init.HowsexModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.howsex.init.HowsexModEntities;
import net.mcreator.howsex.entity.IntercontinentalThermonuclearBallisticMissileEntity;
import net.mcreator.howsex.HowsexMod;

import java.util.concurrent.atomic.AtomicReference;

public class RocketSiloRedstoneOnProcedure {

	public static boolean checkPlatform(LevelAccessor world, double xp, double yp, double zp) {
		for(int x = -3; x <= 3; x ++) {
			for(int z = -3; z <= 3; z ++) {
				if(x == 0 && z == 0) continue;

				Block block = world.getBlockState(new BlockPos(x + xp, yp, z + zp)).getBlock();

				if(!block.equals(Blocks.IRON_BARS) && !block.equals(Blocks.IRON_BLOCK)) {
					return false;
				}
			}
		}

		return true;
	}

	public static ItemStack getItemStack(int slot, LevelAccessor world, double x, double y, double z) {
		 return (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
							.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, new BlockPos(x, y, z), slot));
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		if(!checkPlatform(world, x, y, z)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("howsex:silo-platform-error")),
							SoundSource.NEUTRAL, 50, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("howsex:silo-platform-error")),
							SoundSource.NEUTRAL, 50, 1, false);
				}
			}
			return;
		}

		if(getItemStack(1, world, x, y, z).getItem().equals(HowsexModItems.GPS_LOCATOR)) {
			return;
		} else if(!getItemStack(1, world, x, y, z).getOrCreateTag().getBoolean("active")) {
			return;
		}

		double goalX = getItemStack(1, world, x, y, z).getOrCreateTag().getDouble("x");
		double goalZ = getItemStack(1, world, x, y, z).getOrCreateTag().getDouble("z");

		BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
		if (_ent != null) {
			final int _slotid = 0;
			final ItemStack _setstack = new ItemStack(Blocks.AIR);
			_setstack.setCount(1);
			_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable)
					((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
			});
		}



		if (world instanceof Level _level) {
			Entity entityToSpawn = new IntercontinentalThermonuclearBallisticMissileEntity(
					HowsexModEntities.INTERCONTINENTAL_THERMONUCLEAR_BALLISTIC_MISSILE.get(), _level);
			entityToSpawn.moveTo(x + 0.5D, (y + 1), z + 0.5D, 0, 0);
			entityToSpawn.setYBodyRot(0);
			entityToSpawn.setYHeadRot(0);
			entityToSpawn.setDeltaMovement(0, 0, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn && _level instanceof ServerLevel serverLevel)
				_mobToSpawn.finalizeSpawn(serverLevel, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
						null);
			world.addFreshEntity(entityToSpawn);

			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("howsex:silo-alarm")),
						SoundSource.NEUTRAL, 50, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("howsex:silo-alarm")), SoundSource.NEUTRAL,
						50, 1, false);
			}
			HowsexMod.queueServerWork(100, () -> {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("howsex:silo-rocket")),
							SoundSource.NEUTRAL, 50, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("howsex:silo-rocket")),
							SoundSource.NEUTRAL, 50, 1, false);
				}

				HowsexMod.queueServerWork(200, () -> {
					if(entityToSpawn instanceof IntercontinentalThermonuclearBallisticMissileEntity rocket) {
						rocket.launch(new IntercontinentalThermonuclearBallisticMissileEntity.Goal(goalX, goalZ));
					}
				});
			});
		}
	}
}
