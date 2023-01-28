
package net.mcreator.howsex.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.howsex.entity.IntercontinentalThermonuclearBallisticMissileEntity;
import net.mcreator.howsex.client.model.ModelballisticMissile;

public class IntercontinentalThermonuclearBallisticMissileRenderer
		extends
			MobRenderer<IntercontinentalThermonuclearBallisticMissileEntity, ModelballisticMissile<IntercontinentalThermonuclearBallisticMissileEntity>> {
	public IntercontinentalThermonuclearBallisticMissileRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelballisticMissile(context.bakeLayer(ModelballisticMissile.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(IntercontinentalThermonuclearBallisticMissileEntity entity) {
		return new ResourceLocation("howsex:textures/entities/missle.png");
	}
}
