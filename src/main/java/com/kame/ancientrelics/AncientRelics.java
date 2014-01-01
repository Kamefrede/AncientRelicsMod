package com.kame.ancientrelics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="ancientrelics", name="Kame's Ancient Relics", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class AncientRelics {
	
	public static CreativeTabs kame_random = new RelicTab(CreativeTabs.getNextID(), "Ancient Relics");

    public static Item RelicHelmet;
    public static Item RelicChestplate;
    public static Item RelicLeggings;
    public static Item RelicBoots;
 
    public static EnumArmorMaterial RelicM = EnumHelper.addArmorMaterial("derpyniumam", 66, new int[] {3, 7, 7, 3}, 30);
    public static EnumToolMaterial RelicT = EnumHelper.addToolMaterial("derpyniumtm", 3, 3500, 8.0F, 3.0F, 30);
    
		
	public final static Block randomStone = new RelicBlock(500, Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("HardStone").setCreativeTab(kame_random).setHardness(50.0F).setTextureName("random:RandomStone");
	
	public static Item RelicPickaxe = (new ItemPickaxe(5012, RelicT)).setUnlocalizedName("RelicPickaxe").setTextureName("random:derpyniumPickaxe").setCreativeTab(kame_random);
	
	public static Item RelicAxe = (new ItemAxe(5013, RelicT)).setUnlocalizedName("RelicAxe").setTextureName("random:derpyniumAxe").setCreativeTab(kame_random);
	
	public static Item RelicShovel = (new ItemSpade(5014, RelicT)).setUnlocalizedName("RelicShovel").setTextureName("random:derpyniumShovel").setCreativeTab(kame_random);
	
	public static Item RelicSword = (new ItemSword(5015, RelicT)).setUnlocalizedName("RelicSword").setTextureName("random:derpyniumSword").setCreativeTab(kame_random);
	
	public static Item RelicHoe = (new ItemHoe(5016, RelicT)).setUnlocalizedName("RelicHoe").setTextureName("random:derpyniumHoe").setCreativeTab(kame_random);
	
	public final static Block RelicOre = new RelicOre(501, Material.rock).setTextureName("random:derpyniumOre").setCreativeTab(kame_random);
	
	public final static Block RelicBlock = new RelicBlock(502, Material.rock).setTextureName("random:derpyniumBlock").setUnlocalizedName("RelicBlock").setCreativeTab(kame_random).setHardness(50.0F);
		
	public final static Item InertRelicOrb = new RelicItem(5001).setTextureName("random:derpyniumIngot").setCreativeTab(kame_random).setUnlocalizedName("InertRelicOrb");	
	
	public final static Item kame_wand = new RelicWand(5020).setTextureName("random:derpyniumWand").setCreativeTab(kame_random);

	public final static Item ActivatedRelicOrb = new RelicItem(5096).setCreativeTab(kame_random).setUnlocalizedName("ActivatedRelicOrb");
	
	public final static Item RelicFuelOrb = new RelicItem(5097).setCreativeTab(kame_random).setUnlocalizedName("RelicFuelOrb");
	
	public final static Item RelicWandCore = new RelicItem(5000).setCreativeTab(kame_random).setUnlocalizedName("RelicWandCore");
       // The instance of your mod that Forge uses.
       @Instance("AncientRelics")
       public static AncientRelics instance;
      
       // Says where the client and server 'proxy' code is loaded.
       @SidedProxy(clientSide="com.kame.ancientrelics.client.ClientProxy", serverSide="com.ancientrelics.random.CommonProxy")
       public static CommonProxy proxy;
      
       @EventHandler
       public void preInit(FMLPreInitializationEvent event) {
    	   GameRegistry.registerWorldGenerator(new RelicGenerator());
    	   
      RelicHelmet = new ItemRelicHelmet(5046, RelicM, proxy.addArmor("RelicArmor"),0).setUnlocalizedName("RelicHelmet").setCreativeTab(kame_random);
      RelicChestplate = new ItemRelicChestplate(5047, RelicM, proxy.addArmor("RelicArmor"),1).setUnlocalizedName("RelicChestplate").setCreativeTab(kame_random);
      RelicLeggings = new ItemRelicLeggings(5048, RelicM, proxy.addArmor("RelicArmor"),2).setUnlocalizedName("RelicLeggings").setCreativeTab(kame_random);
      RelicBoots = new ItemRelicBoots(5049, RelicM, proxy.addArmor("RelicArmor"),3).setUnlocalizedName("RelicBoots").setCreativeTab(kame_random);
       }
      
       @EventHandler
       public void load(FMLInitializationEvent event) {
    	   proxy.registerRenderers();
    	   
    	       
    	   
    	       GameRegistry.registerItem(RelicWandCore, "RelicWandCore");
    	       LanguageRegistry.addName(RelicWandCore, "Inert Wand Core");
    	   
    	       GameRegistry.registerItem(RelicFuelOrb, "RelicFuelOrb");
    	       LanguageRegistry.addName(RelicFuelOrb, "Relic Infused Coal");
                                          
    	       GameRegistry.registerItem(ActivatedRelicOrb, "ActivatedRelicOrb");
    	       LanguageRegistry.addName(ActivatedRelicOrb, "Activated Relic Orb");
    	   
               GameRegistry.registerBlock(randomStone, "HardStone");
               LanguageRegistry.addName(randomStone, "Hardened Stone");
               
               GameRegistry.registerBlock(RelicOre, "RelicOre");
               LanguageRegistry.addName(RelicOre, "Relic Infused Ore");
               
               GameRegistry.registerBlock(RelicBlock, "RelicBlock");
               LanguageRegistry.addName(RelicBlock, "Relic Infused Block");
               
               
               GameRegistry.registerItem(InertRelicOrb, "InertRelicOrb");
               LanguageRegistry.addName(InertRelicOrb, "Inert Relic Orb");
               
               GameRegistry.registerItem(RelicAxe, "RelicAxe");
               LanguageRegistry.addName(RelicAxe, "Relic infused Axe");
               
               GameRegistry.registerItem(RelicShovel, "RelicShovel");
               LanguageRegistry.addName(RelicShovel, "Relic infused Shovel");
               
               GameRegistry.registerItem(RelicHoe, "RelicHoe");
               LanguageRegistry.addName(RelicHoe, "Relic infused Hoe");
               
               GameRegistry.registerItem(RelicSword, "RelicSword");
               LanguageRegistry.addName(RelicSword, "Relic infused Shovel");
               
               GameRegistry.registerItem(kame_wand, "kame_wand");
               LanguageRegistry.addName(kame_wand, "Relic Infused Wand");
               
               GameRegistry.registerItem(RelicHelmet, "RelicHelmet");
               LanguageRegistry.addName(RelicHelmet, "Relic infused Helmet");
               
               GameRegistry.registerItem(RelicChestplate, "RelicChestplate");
               LanguageRegistry.addName(RelicChestplate, "Relic infused Chestplate");
               
               GameRegistry.registerItem(RelicLeggings, "RelicLeggings");
               LanguageRegistry.addName(RelicLeggings, "Relic infused Leggings");
               
               GameRegistry.registerItem(RelicBoots, "RelicBoots");
               LanguageRegistry.addName(RelicBoots, "Relic infused Boots");
               
               GameRegistry.registerItem(RelicPickaxe, "RelickPickaxe");
               LanguageRegistry.addName(RelicPickaxe, "Relic Infused Pickaxe");
               
               GameRegistry.registerFuelHandler(new RelicFuelHandler());
                  
               LanguageRegistry.instance().addStringLocalization("itemGroup.kame_random", "en_US", "Ancient Relics");
               
               MinecraftForge.setBlockHarvestLevel(RelicOre, "pickaxe", 3);
               MinecraftForge.setBlockHarvestLevel(randomStone, "pickaxe", 2);
               
               ItemStack activatedRelicStack = new ItemStack(ActivatedRelicOrb);
               ItemStack goldStack = new ItemStack(Item.ingotGold, 1);
               ItemStack diamondStack = new ItemStack(Item.diamond, 1);
               ItemStack stoneStack = new ItemStack(1, 32, 0);
               ItemStack ironStack = new ItemStack(Item.ingotIron);
               ItemStack coalStack = new ItemStack(Item.coal);
               ItemStack InertRelicStack = new ItemStack(InertRelicOrb);
               ItemStack relicBlockStack = new ItemStack(RelicBlock);
               ItemStack hardstoneStack = new ItemStack(randomStone);
               ItemStack cobbleStack = new ItemStack(Block.cobblestone);
               ItemStack dimablockStack = new ItemStack(Block.blockDiamond);
               ItemStack milkStack = new ItemStack(Item.bucketMilk);
               ItemStack stickStack = new ItemStack(Item.stick);
               ItemStack relichovelStack = new ItemStack(RelicShovel);
               ItemStack relicswordStack = new ItemStack(RelicSword);
               ItemStack relicaxeStack = new ItemStack(RelicAxe);
               ItemStack relichoeStack = new ItemStack(RelicHoe);
               ItemStack relicpickStack = new ItemStack(RelicPickaxe);
               ItemStack relicwand = new ItemStack(kame_wand);
               ItemStack reliclegsStack = new ItemStack(RelicLeggings);
               ItemStack relicHatStack = new ItemStack(RelicHelmet);
               ItemStack relicbootsStack = new ItemStack(RelicBoots);
               ItemStack relicchestStack = new ItemStack(RelicChestplate);
               ItemStack shovelStack = new ItemStack(Item.shovelIron);
               ItemStack swordStack = new ItemStack(Item.swordIron);
               ItemStack axeStack = new ItemStack(Item.axeIron);
               ItemStack pickaxeStack = new ItemStack(Item.pickaxeIron);
               ItemStack hoeStack = new ItemStack(Item.hoeIron);
               ItemStack wandcoreStack = new ItemStack(RelicWandCore);
               ItemStack relicFuelStack = new ItemStack(RelicFuelOrb);
               ItemStack coalBlockStack = new ItemStack(Block.coalBlock);
               ItemStack enderpearlStack = new ItemStack(Item.enderPearl);
               ItemStack ironhStack = new ItemStack(Item.helmetIron);
               ItemStack ironcStack = new ItemStack(Item.plateIron);
               ItemStack ironlStack = new ItemStack(Item.legsIron);
               ItemStack ironbStack = new ItemStack(Item.bootsIron);
                             
               GameRegistry.addRecipe(wandcoreStack, "xyx", "xox", "xyx",
            		   'x', goldStack, 'y', stickStack, 'o', enderpearlStack);
               
               GameRegistry.addRecipe(relicFuelStack, " x ", "xyx", "x",
            		   'x', coalBlockStack, 'y', activatedRelicStack);
               
               GameRegistry.addRecipe(activatedRelicStack, " y ", "yxy", " y ",
            		  'y', coalStack, 'x', InertRelicStack);
               
               GameRegistry.addRecipe(relicBlockStack, "xyx", "yxy", "yxy",
                       'y', InertRelicOrb, 'x', hardstoneStack);
               
               GameRegistry.addRecipe(hardstoneStack, "xxx", "xxx", "xxx",
            		   'x', cobbleStack);
       
               GameRegistry.addRecipe(relichovelStack, " x ", " y ",
            		   'x', activatedRelicStack, 'y', shovelStack);
               
               GameRegistry.addRecipe(relicswordStack, " x ", " x ",
            		 'x', activatedRelicStack, 'y', swordStack  );
               
               GameRegistry.addRecipe(relicaxeStack, " x ", " y ",
            		   'x', activatedRelicStack, 'y', axeStack);
               
               GameRegistry.addRecipe(relicpickStack, " x ", " y ",
            		   'x', activatedRelicStack, 'y', pickaxeStack);
               
               GameRegistry.addRecipe(relichoeStack, " x ", " y ",
            		   'x', activatedRelicStack, 'y', hoeStack);
               
               GameRegistry.addRecipe(relicwand, " x ", " y ", "   ",
            		   'x', activatedRelicStack, 'y', wandcoreStack);
               
               GameRegistry.addRecipe(relicHatStack, " x ", " y ",
            		   'x', activatedRelicStack, 'y', ironhStack);
               
               GameRegistry.addRecipe(relicbootsStack, " x ", " y ",
            		   'x', activatedRelicStack, 'y', ironbStack);
               
               GameRegistry.addRecipe(relicchestStack, " x ", " y ",
            		   'x', activatedRelicStack, 'y', ironcStack);
               
               GameRegistry.addRecipe(reliclegsStack, " x ", " y ",
            		   'x', activatedRelicStack, 'y', ironlStack);
               
              
               
             
               //FurnaceRecipes.smelting().addSmelting(Block.cloth.blockID, 15, whiteWoolStack, 1.0f);O
       }
      
       @EventHandler
       public void postInit(FMLPostInitializationEvent event) {
               // Stub Method
    	   
       }
}