package net.mcreator.howsex.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class GPSLocatorRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("howsex:nut")),
						SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("howsex:nut")), SoundSource.NEUTRAL, 1, 1,
						false);
			}
		}
		itemstack.getOrCreateTag().putBoolean("active", (true));
		itemstack.getOrCreateTag().putDouble("x", x);
		itemstack.getOrCreateTag().putDouble("z", z);
	}
}
