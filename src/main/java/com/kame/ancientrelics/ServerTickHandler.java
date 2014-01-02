package com.kame.ancientrelics;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {

	private void onPlayerTick(EntityPlayer player) {
		
		if(player.getCurrentItemOrArmor(4) != null) {
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			
			if(helmet.getItem() == AncientRelics.RelicHelmet) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 40, 0));
			}
		}
	   if(player.getCurrentItemOrArmor(3) != null) {
		   ItemStack chestplate = player.getCurrentItemOrArmor(3);
		   
		   if(chestplate.getItem() == AncientRelics.RelicChestplate) {
			   player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 40, 0));
			   player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 40, 0));
		   }
	   }
	   if(player.getCurrentItemOrArmor(2) != null) {
		   ItemStack leggings = player.getCurrentItemOrArmor(2);
		   
		   if(leggings.getItem() == AncientRelics.RelicLeggings) {
			 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 1));
		   }
	   }
	   if(player.getCurrentItemOrArmor(1) != null) {
		   ItemStack boots = player.getCurrentItemOrArmor(1);
		   
		   if(boots.getItem() == AncientRelics.RelicBoots) {
			   player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 40, 1));
		   }
		   
	   }
	}
	
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(type.equals(EnumSet.of(TickType.PLAYER))) {
			onPlayerTick((EntityPlayer) tickData[0]);
		}

	}

	@Override
	public EnumSet<TickType> ticks() {
      return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

}
