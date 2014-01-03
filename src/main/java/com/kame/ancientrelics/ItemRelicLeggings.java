package com.kame.ancientrelics;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRelicLeggings extends ItemArmor {

	public ItemRelicLeggings(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		// TODO Auto-generated constructor stub
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon) {
		this.itemIcon = par1RegisterIcon
				.registerIcon("random:derpyniumLeggings");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			int layer) {
		return "random:textures/models/armor/derpy_2.png";
	}
}
