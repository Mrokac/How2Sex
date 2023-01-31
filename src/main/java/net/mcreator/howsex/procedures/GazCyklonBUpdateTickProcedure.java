package net.mcreator.howsex.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.howsex.init.HowsexModBlocks;

import java.util.Random;

public class GazCyklonBUpdateTickProcedure {
	static Random random = new Random();

	public static boolean attemptPlace(LevelAccessor world, double x, double y, double z, double prevX, double prevY, double prevZ) {
		BlockPos pos = new BlockPos(x, y, z);
		if(world.getBlockState(pos).getBlock().equals(Blocks.AIR) ||
				world.getBlockState(pos).getBlock().equals(Blocks.VOID_AIR) ||
				world.getBlockState(pos).getBlock().equals(Blocks.CAVE_AIR)) {
			world.setBlock(pos, HowsexModBlocks.GAZ_CYKLON_B.get().defaultBlockState(), 3);
			world.setBlock(new BlockPos(prevX, prevY, prevZ), Blocks.AIR.defaultBlockState(), 3);
			return true;
		}
		return false;
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		if(!attemptPlace(world, x, y - 1, z, x, y, z)) {
			int rnd = random.nextInt(4);
			if (rnd == 0) {
				if (attemptPlace(world, x + 1, y, z, x, y, z)) {
					return;
				}
			}
			if (rnd == 1) {
				if (attemptPlace(world, x - 1, y, z, x, y, z)) {
					return;
				}
			}
			if (rnd == 2) {
				if (attemptPlace(world, x, y, z + 1, x, y, z)) {
					return;
				}
			}
			if (rnd == 3) {
				if (attemptPlace(world, x, y, z - 1, x, y, z)) {
					return;
				}
			}
		}
	}
}
