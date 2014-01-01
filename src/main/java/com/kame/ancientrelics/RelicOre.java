package com.kame.ancientrelics;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RelicOre extends Block {

	public RelicOre(int id, Material material) {
		super(id, material);
		
		setHardness(4.0f);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("RelicOre");
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3){
	 return com.kame.ancientrelics.AncientRelics.InertRelicOrb.itemID;
	}
	
}
