
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.howsex.HowsexMod;

public class HowsexModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HowsexMod.MODID);
	public static final RegistryObject<SoundEvent> SILO_ALARM = REGISTRY.register("silo-alarm",
			() -> new SoundEvent(new ResourceLocation("howsex", "silo-alarm")));
	public static final RegistryObject<SoundEvent> SILO_ROCKET = REGISTRY.register("silo-rocket",
			() -> new SoundEvent(new ResourceLocation("howsex", "silo-rocket")));
	public static final RegistryObject<SoundEvent> SILO_PLATFORM_ERROR = REGISTRY.register("silo-platform-error",
			() -> new SoundEvent(new ResourceLocation("howsex", "silo-platform-error")));
	public static final RegistryObject<SoundEvent> NUT = REGISTRY.register("nut", () -> new SoundEvent(new ResourceLocation("howsex", "nut")));
}
