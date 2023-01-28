
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.howsex.client.renderer.IntercontinentalThermonuclearBallisticMissileRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HowsexModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(HowsexModEntities.INTERCONTINENTAL_THERMONUCLEAR_BALLISTIC_MISSILE.get(),
				IntercontinentalThermonuclearBallisticMissileRenderer::new);
	}
}
