
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.howsex.entity.IntercontinentalThermonuclearBallisticMissileEntity;
import net.mcreator.howsex.HowsexMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HowsexModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HowsexMod.MODID);
	public static final RegistryObject<EntityType<IntercontinentalThermonuclearBallisticMissileEntity>> INTERCONTINENTAL_THERMONUCLEAR_BALLISTIC_MISSILE = register(
			"intercontinental_thermonuclear_ballistic_missile",
			EntityType.Builder
					.<IntercontinentalThermonuclearBallisticMissileEntity>of(IntercontinentalThermonuclearBallisticMissileEntity::new,
							MobCategory.MONSTER)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(IntercontinentalThermonuclearBallisticMissileEntity::new)

					.sized(1f, 9f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			IntercontinentalThermonuclearBallisticMissileEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(INTERCONTINENTAL_THERMONUCLEAR_BALLISTIC_MISSILE.get(),
				IntercontinentalThermonuclearBallisticMissileEntity.createAttributes().build());
	}
}
