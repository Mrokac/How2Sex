
package net.mcreator.howsex.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.howsex.init.HowsexModTabs;

public class BasicMissleItemItem extends Item {
	public BasicMissleItemItem() {
		super(new Item.Properties().tab(HowsexModTabs.TAB_HOW_2_SEX_TAB).stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}
}
