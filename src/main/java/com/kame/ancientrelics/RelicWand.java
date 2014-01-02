package com.kame.ancientrelics;

import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RelicWand extends Item {

	public RelicWand(int id) {
		super(id);
		setMaxStackSize(1);
		setUnlocalizedName("derpyniumWand");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		if (par3EntityPlayer.isDead) {
			return par1ItemStack;
		} else {
			if (!par2World.isRemote) {

				par2World.spawnEntityInWorld(new EntityEnderPearl(par2World,
						par3EntityPlayer));
				par3EntityPlayer.addPotionEffect(new PotionEffect(
						Potion.regeneration.id, 60, 10));
			}

			return par1ItemStack;
		}
	}

}
