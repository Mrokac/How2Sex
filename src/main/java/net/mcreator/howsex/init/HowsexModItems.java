
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.howsex.item.PenisItem;
import net.mcreator.howsex.item.PancerzykOkrzemekItem;
import net.mcreator.howsex.item.OpalItem;
import net.mcreator.howsex.item.OkrzemkiItem;
import net.mcreator.howsex.HowsexMod;

public class HowsexModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, HowsexMod.MODID);
	public static final RegistryObject<Item> PENIS = REGISTRY.register("penis", () -> new PenisItem());
	public static final RegistryObject<Item> OKRZEMKI = REGISTRY.register("okrzemki", () -> new OkrzemkiItem());
	public static final RegistryObject<Item> OPAL = REGISTRY.register("opal", () -> new OpalItem());
	public static final RegistryObject<Item> PANCERZYK_OKRZEMEK = REGISTRY.register("pancerzyk_okrzemek", () -> new PancerzykOkrzemekItem());
	public static final RegistryObject<Item> ZIEMIAOKRZEMKOWA = block(HowsexModBlocks.ZIEMIAOKRZEMKOWA, CreativeModeTab.TAB_BUILDING_BLOCKS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
