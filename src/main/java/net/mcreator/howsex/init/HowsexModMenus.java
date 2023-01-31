
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.howsex.world.inventory.ZbieraniegazuMenu;
import net.mcreator.howsex.HowsexMod;

public class HowsexModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HowsexMod.MODID);
	public static final RegistryObject<MenuType<ZbieraniegazuMenu>> ZBIERANIEGAZU = REGISTRY.register("zbieraniegazu",
			() -> IForgeMenuType.create(ZbieraniegazuMenu::new));
}
