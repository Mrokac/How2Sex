package net.mcreator.howsex.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class GazCyklonBUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		world.setBlock(new BlockPos(x, y, z), HowsexModBlocks.GAZ_CYKLON_B.get().defaultBlockState(), 3);
	}
}
