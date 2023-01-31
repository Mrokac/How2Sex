package net.mcreator.howsex.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

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
