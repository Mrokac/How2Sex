
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.howsex.world.inventory.SiloGUIMenu;
import net.mcreator.howsex.world.inventory.QuestionMenu;
import net.mcreator.howsex.HowsexMod;

public class HowsexModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HowsexMod.MODID);
	public static final RegistryObject<MenuType<SiloGUIMenu>> SILO_GUI = REGISTRY.register("silo_gui", () -> IForgeMenuType.create(SiloGUIMenu::new));
	public static final RegistryObject<MenuType<QuestionMenu>> QUESTION = REGISTRY.register("question",
			() -> IForgeMenuType.create(QuestionMenu::new));
}
