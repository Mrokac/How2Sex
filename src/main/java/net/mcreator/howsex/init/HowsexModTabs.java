
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.howsex.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class HowsexModTabs {
	public static CreativeModeTab TAB_HOW_2_SEX_TAB;

	public static void load() {
		TAB_HOW_2_SEX_TAB = new CreativeModeTab("tabhow_2_sex_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(HowsexModItems.PENIS.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
