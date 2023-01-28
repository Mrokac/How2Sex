
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.howsex.item.PenisItem;
import net.mcreator.howsex.HowsexMod;

public class HowsexModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, HowsexMod.MODID);
	public static final RegistryObject<Item> PENIS = REGISTRY.register("penis", () -> new PenisItem());
}
