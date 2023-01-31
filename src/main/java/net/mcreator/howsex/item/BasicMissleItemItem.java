
package net.mcreator.howsex.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class BasicMissleItemItem extends Item {

	public BasicMissleItemItem() {
		super(new Item.Properties().tab(HowsexModTabs.TAB_HOW_2_SEX_TAB).stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}

}
