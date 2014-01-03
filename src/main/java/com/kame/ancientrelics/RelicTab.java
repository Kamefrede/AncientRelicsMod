package com.kame.ancientrelics;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class RelicTab extends CreativeTabs {
	public RelicTab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	// sets the image for the creative tab
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		// there is a difference between items and blocks. will give an example
		// of both
		return com.kame.ancientrelics.AncientRelics.InertRelicOrb.itemID;
	}

	// sets the title/name for the creative tab
	@Override
	public String getTranslatedTabLabel() {
		return "Ancient Relics";
	}
}