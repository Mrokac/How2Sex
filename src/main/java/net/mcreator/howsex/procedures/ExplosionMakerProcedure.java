package net.mcreator.howsex.procedures;

import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class ExplosionMakerProcedure {
	public static double distance(BlockPos pos, BlockPos center) {
		double a = Math.abs(pos.getX() - center.getX());
		double b = Math.abs(pos.getY() - center.getY());
		double c = Math.abs(pos.getZ() - center.getZ());
		return Math.floor(Math.sqrt(a*a + b*b + c*c));
	}

	public static void execute(LevelAccessor world, double xp, double yp, double zp, double radius) {
		for(int x = (int) (xp - radius); x < (int) (xp + radius); x ++) {
			for(int y = (int) (yp - radius); y < (int) (yp + radius); y ++) {
				for(int z = (int) (zp - radius); z < (int) (zp + radius); z ++) {
					BlockPos pos = new BlockPos(x, y, z);
					BlockPos center = new BlockPos(xp, yp, zp);

					if(distance(pos, center) <= radius) {
						world.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
					}
				}
			}
		}
	}
}
