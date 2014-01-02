package com.kame.ancientrelics;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class RelicFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == com.kame.ancientrelics.AncientRelics.RelicFuelOrb.itemID) {
			return 20000;
		}
		return 0;
	}

}
