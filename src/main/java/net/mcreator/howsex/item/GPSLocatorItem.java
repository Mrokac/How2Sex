
package net.mcreator.howsex.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.howsex.procedures.GPSLocatorRightclickedOnBlockProcedure;
import net.mcreator.howsex.init.HowsexModTabs;

public class GPSLocatorItem extends Item {
	public GPSLocatorItem() {
		super(new Item.Properties().tab(HowsexModTabs.TAB_HOW_2_SEX_TAB).stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		GPSLocatorRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
