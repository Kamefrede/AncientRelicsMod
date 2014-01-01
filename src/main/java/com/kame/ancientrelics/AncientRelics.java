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
	
	public final static Block smeltedIron = new RelicBlock(600, Material.iron).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("smeltedIron").setCreativeTab(kame_random).setHardness(50.0F).setTextureName("random:smeltedIron");

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
                                          
               GameRegistry.registerBlock(randomStone, "HardStone");
               LanguageRegistry.addName(randomStone, "Hardened Stone");
               
               GameRegistry.registerBlock(RelicOre, "DerpyniumOre");
               LanguageRegistry.addName(RelicOre, "Derpynium Ore");
               
               GameRegistry.registerBlock(RelicBlock, "DerpyniumBlock");
               LanguageRegistry.addName(RelicBlock, "Derpynium Block");
               
               
               GameRegistry.registerItem(InertRelicOrb, "InertRelicOrb");
               LanguageRegistry.addName(InertRelicOrb, "Derpynium Ingot");
               
               GameRegistry.registerItem(RelicAxe, "RelicAxe");
               LanguageRegistry.addName(RelicAxe, "Relic infused Axe");
               
               GameRegistry.registerItem(RelicShovel, "RelicShovel");
               LanguageRegistry.addName(RelicShovel, "Relic infused Shovel");
               
               GameRegistry.registerItem(RelicHoe, "RelicHoe");
               LanguageRegistry.addName(RelicHoe, "Relic infused Hoe");
               
               GameRegistry.registerItem(RelicSword, "Relic");
               LanguageRegistry.addName(RelicSword, "Relic infused Shovel");
               
               GameRegistry.registerItem(kame_wand, "kame_wand");
               LanguageRegistry.addName(kame_wand, "Magical Relic Wand");
               
               GameRegistry.registerItem(RelicHelmet, "RelicHelmet");
               LanguageRegistry.addName(RelicHelmet, "Relic infused Helmet");
               
               GameRegistry.registerItem(RelicChestplate, "RelicChestplate");
               LanguageRegistry.addName(RelicChestplate, "Relic infused Chestplate");
               
               GameRegistry.registerItem(RelicLeggings, "RelicLeggings");
               LanguageRegistry.addName(RelicLeggings, "Relic infused Leggings");
               
               GameRegistry.registerItem(RelicBoots, "RelicBoots");
               LanguageRegistry.addName(RelicBoots, "Relic infused Boots");
               
               GameRegistry.registerBlock(smeltedIron, "smeltedIron");
               LanguageRegistry.addName(smeltedIron, "Smelted Iron block");
               
               LanguageRegistry.instance().addStringLocalization("itemGroup.kame_random", "en_US", "Ancient Relics");
               
               MinecraftForge.setBlockHarvestLevel(RelicOre, "pickaxe", 3);
               MinecraftForge.setBlockHarvestLevel(randomStone, "pickaxe", 2);
               
               ItemStack diamondStack = new ItemStack(Item.diamond, 1);
               ItemStack stoneStack = new ItemStack(1, 32, 0);
               ItemStack ironStack = new ItemStack(Item.ingotIron);
               ItemStack coalStack = new ItemStack(Item.coal);
               ItemStack derpyniumStack = new ItemStack(InertRelicOrb);
               ItemStack derpyblockStack = new ItemStack(RelicBlock);
               ItemStack hardstoneStack = new ItemStack(randomStone);
               ItemStack cobbleStack = new ItemStack(Block.cobblestone);
               ItemStack dimablockStack = new ItemStack(Block.blockDiamond);
               ItemStack milkStack = new ItemStack(Item.bucketMilk);
               ItemStack stickStack = new ItemStack(Item.stick);
               ItemStack derpyshovelStack = new ItemStack(RelicShovel);
               ItemStack derpyswordStack = new ItemStack(RelicSword);
               ItemStack derpyaxeStack = new ItemStack(RelicAxe);
               ItemStack derpyhoeStack = new ItemStack(RelicHoe);
               ItemStack derpypickStack = new ItemStack(RelicPickaxe);
               ItemStack derpywand = new ItemStack(kame_wand);
               ItemStack smeltedIronStack = new ItemStack(smeltedIron);
               ItemStack derpylegsStack = new ItemStack(RelicLeggings);
               ItemStack derpyHatStack = new ItemStack(RelicHelmet);
               ItemStack derpybootsStack = new ItemStack(RelicBoots);
               ItemStack derpychestStack = new ItemStack(RelicChestplate);
                             
          
               
               GameRegistry.addRecipe(derpyblockStack, "xxx", "xxx", "xxx",
                       'x', InertRelicOrb);
               
               GameRegistry.addRecipe(hardstoneStack, "xxx", "xxx", "xxx",
            		   'x', cobbleStack);
       
               GameRegistry.addRecipe(derpyshovelStack, " x ", " y ", " y ",
            		   'x', derpyniumStack, 'y', stickStack);
               
               GameRegistry.addRecipe(derpyswordStack, " x ", " x ", " y ",
            		 'x', derpyniumStack, 'y', stickStack  );
               
               GameRegistry.addRecipe(derpyaxeStack, "xx ", "xy ", " y ",
            		   'x', derpyniumStack, 'y', stickStack);
               
               GameRegistry.addRecipe(derpypickStack, "xxx", " y ", " y ",
            		   'x', derpyniumStack, 'y', stickStack);
               
               GameRegistry.addRecipe(derpyhoeStack, "xx ", " y ", " y ",
            		   'x', derpyniumStack, 'y', stickStack);
               
               GameRegistry.addRecipe(derpywand, "xyx", "yoy", "xyx",
            		   'x', derpyblockStack, 'y', dimablockStack, 'o', derpyniumStack);
               
               GameRegistry.addRecipe(derpyHatStack, "xxx", "x x",
            		   'x', derpyniumStack);
               
               GameRegistry.addRecipe(derpybootsStack, "x x", "x x",
            		   'x', derpyniumStack);
               
               GameRegistry.addRecipe(derpychestStack, "x x", "xxx", "xxx",
            		   'x', derpyniumStack);
               
               GameRegistry.addRecipe(derpylegsStack, "xxx", "x x", "x x",
            		   'x', derpyniumStack);
               
              
               
             
               //FurnaceRecipes.smelting().addSmelting(Block.cloth.blockID, 15, whiteWoolStack, 1.0f);O
       }
      
       @EventHandler
       public void postInit(FMLPostInitializationEvent event) {
               // Stub Method
    	   
       }
}