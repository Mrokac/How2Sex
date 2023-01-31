
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
import net.mcreator.howsex.item.GPSLocatorItem;
import net.mcreator.howsex.item.BasicMissleItemItem;
import net.mcreator.howsex.HowsexMod;

public class HowsexModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, HowsexMod.MODID);
	public static final RegistryObject<Item> PENIS = REGISTRY.register("penis", () -> new PenisItem());
	public static final RegistryObject<Item> ROCKET_SILO = block(HowsexModBlocks.ROCKET_SILO, HowsexModTabs.TAB_HOW_2_SEX_TAB);
	public static final RegistryObject<Item> GPS_LOCATOR = REGISTRY.register("gps_locator", () -> new GPSLocatorItem());
	public static final RegistryObject<Item> BASIC_MISSILE_ITEM = REGISTRY.register("basic_missile_item", () -> new BasicMissleItemItem());
	public static final RegistryObject<Item> GAZ_CYKLON_B = block(HowsexModBlocks.GAZ_CYKLON_B, HowsexModTabs.TAB_HOW_2_SEX_TAB);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
