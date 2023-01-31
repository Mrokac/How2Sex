
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.howsex.block.entity.RocketSiloBlockEntity;
import net.mcreator.howsex.HowsexMod;

public class HowsexModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, HowsexMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ROCKET_SILO = register("rocket_silo", HowsexModBlocks.ROCKET_SILO,
			RocketSiloBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
