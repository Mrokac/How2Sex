
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.howsex.block.ZiemiaokrzemkowaBlock;
import net.mcreator.howsex.HowsexMod;

public class HowsexModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, HowsexMod.MODID);
	public static final RegistryObject<Block> ZIEMIAOKRZEMKOWA = REGISTRY.register("ziemiaokrzemkowa", () -> new ZiemiaokrzemkowaBlock());
}
