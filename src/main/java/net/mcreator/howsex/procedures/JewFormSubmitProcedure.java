package net.mcreator.howsex.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.howsex.network.HowsexModVariables;

import java.util.HashMap;

public class JewFormSubmitProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (guistate.containsKey("checkbox:answer") ? ((Checkbox) guistate.get("checkbox:answer")).selected() : false) {
			{
				double _setval = 1;
				entity.getCapability(HowsexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isJew = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = 2;
				entity.getCapability(HowsexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isJew = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
