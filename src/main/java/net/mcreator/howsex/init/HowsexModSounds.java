
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
	public static final RegistryObject<SoundEvent> ODKURZACZ = REGISTRY.register("odkurzacz",
			() -> new SoundEvent(new ResourceLocation("howsex", "odkurzacz")));
}
