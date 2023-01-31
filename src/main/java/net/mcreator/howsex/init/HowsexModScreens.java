
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.howsex.client.gui.SiloGUIScreen;
import net.mcreator.howsex.client.gui.QuestionScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HowsexModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(HowsexModMenus.SILO_GUI.get(), SiloGUIScreen::new);
			MenuScreens.register(HowsexModMenus.QUESTION.get(), QuestionScreen::new);
		});
	}
}
