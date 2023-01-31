
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.howsex.block.RocketSiloBlock;
import net.mcreator.howsex.block.GazCyklonBBlock;
import net.mcreator.howsex.HowsexMod;

public class HowsexModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, HowsexMod.MODID);
	public static final RegistryObject<Block> ROCKET_SILO = REGISTRY.register("rocket_silo", () -> new RocketSiloBlock());
	public static final RegistryObject<Block> GAZ_CYKLON_B = REGISTRY.register("gaz_cyklon_b", () -> new GazCyklonBBlock());
}
