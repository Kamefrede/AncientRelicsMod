package com.kame.ancientrelics;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class RelicGenerator implements IWorldGenerator {
      
       @Override
       public void generate(Random random, int chunkX, int chunkZ, World world,
                       IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
               switch (world.provider.dimensionId) {
               case -1:
                       generateNether();
                       break;
               case 0:
                       generateSurface(world, random, chunkX * 16, chunkZ * 16);
                       break;
               case 1:
                       generateEnd();
                       break;
               }
       }

       public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
               for (int i = 0; i < 20; i++) {
                       int randPosX = chunkX + rand.nextInt(16);
                       int randPosY = rand.nextInt(12); // CHANGE 64 TO THE MAX Y LEVEL YOU WANT TO SEE YOUR ORE
                       int randPosZ = chunkZ + rand.nextInt(16);

                       // CHANGE THE 6 BELOW TO THE MAX AMOUNT OF NODES YOU WANT IN A VEIN
                       (new WorldGenMinable(com.kame.ancientrelics.AncientRelics.RelicOre.blockID, 2)).generate(world, rand, randPosX, randPosY, randPosZ);
               }
       }

       public void generateNether() {
       }

       public void generateEnd() {
       }

}