package mods.roborave.edm.helper.ore.generate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGenCore 
implements IWorldGenerator {
	public static List<WorldGenOre> oreGenOverworld = new ArrayList<WorldGenOre>();
	public static List<WorldGenOre> oreGenNether = new ArrayList<WorldGenOre>();
	public static List<WorldGenOre> oreGenEnd = new ArrayList<WorldGenOre>();

	public static Collection<String> biomeListBauxite = new ArrayList<String>();
	public static Collection<String> biomeListCassiterite = new ArrayList<String>();
	public static Collection<String> biomeListColdiron = new ArrayList<String>();
	public static Collection<String> biomeListMithral = new ArrayList<String>();
	public static Collection<String> biomeListNickel = new ArrayList<String>();
	public static Collection<String> biomeListRuby = new ArrayList<String>();
	public static Collection<String> biomeListSapphire = new ArrayList<String>();
	public static Collection<String> biomeListSaltpeter = new ArrayList<String>();
	public static Collection<String> biomeListSulfur = new ArrayList<String>();
	public static Collection<String> biomeListTetrahedrite = new ArrayList<String>();

	public WorldGenCore(){

		GameRegistry.registerWorldGenerator(this, 1);
	}

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		doWorldGen(random, world, chunkX, chunkZ, true);
	}

	public void doWorldGen(Random random, World world, int chunkX, int chunkZ, boolean newChunk) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX*16, chunkZ*16, newChunk);
			break;
		case 1:
			generateEnd(world, random, chunkX*16, chunkZ*16, newChunk);
			break;
		default: 
			generateSurface(world, random, chunkX*16, chunkZ*16, newChunk);
		}

		if (!newChunk)
			world.getChunkFromChunkCoords(chunkX, chunkZ).setChunkModified();
	}

	public void generateEnd(World world, Random random, int blockX, int blockZ, boolean newChunk){
		for (WorldGenOre oreGen : WorldGenCore.oreGenEnd)
			if(newChunk || oreGen.doRegen)
			{
				oreGen.generate(world, random, blockX, blockZ);
			}
	}

	public void generateNether(World world, Random random, int blockX, int blockZ, boolean newChunk){
		for (WorldGenOre oreGen : WorldGenCore.oreGenNether)
			if (newChunk || oreGen.doRegen) {
				oreGen.generate(world, random, blockX, blockZ);
			}

	}

	public void generateSurface(World world, Random random, int blockX, int blockZ, boolean newChunk){

		for (WorldGenOre oreGen : WorldGenCore.oreGenOverworld)
			if (newChunk || oreGen.doRegen) {
				oreGen.generate(world, random, blockX, blockZ);
			}
	}

	static {
		biomeListBauxite.add(BiomeGenBase.plains.biomeName);
		biomeListBauxite.add(BiomeGenBase.forest.biomeName);
		biomeListBauxite.add(BiomeGenBase.forestHills.biomeName);
		biomeListCassiterite.add(BiomeGenBase.taiga.biomeName);
		biomeListCassiterite.add(BiomeGenBase.taigaHills.biomeName);
		biomeListCassiterite.add(BiomeGenBase.icePlains.biomeName);
		biomeListCassiterite.add(BiomeGenBase.iceMountains.biomeName);
		biomeListCassiterite.add(BiomeGenBase.mushroomIsland.biomeName);
		biomeListCassiterite.add(BiomeGenBase.mushroomIslandShore.biomeName);
		biomeListCassiterite.add(BiomeGenBase.extremeHills.biomeName);
		biomeListCassiterite.add(BiomeGenBase.extremeHillsEdge.biomeName);
		biomeListColdiron.add(BiomeGenBase.frozenOcean.biomeName);
		biomeListColdiron.add(BiomeGenBase.frozenRiver.biomeName);
		biomeListColdiron.add(BiomeGenBase.icePlains.biomeName);
		//biomeListColdiron.add(BiomeGenBase.icePlainsSpikes.biomeName);
		biomeListColdiron.add(BiomeGenBase.iceMountains.biomeName);
		//biomeListColdiron.add(BiomeGenBase.coldBeach.biomeName);
		biomeListColdiron.add(BiomeGenBase.coldTaiga.biomeName); // Cold Taiga
		biomeListColdiron.add(BiomeGenBase.coldTaigaHills.biomeName); // Cold Taiga Hills
		//biomeListColdiron.add(BiomeGenBase.coldTaigaM.biomeName);
		biomeListColdiron.add(BiomeGenBase.extremeHills.biomeName);
		biomeListColdiron.add(BiomeGenBase.extremeHillsEdge.biomeName);
		//biomeListColdiron.add(BiomeGenBase.extremeHillsM.biomeName);
		biomeListColdiron.add(BiomeGenBase.taiga.biomeName);
		biomeListColdiron.add(BiomeGenBase.taigaHills.biomeName);
		//biomeListColdiron.add(BiomeGenBase.taigM.biomeName);
		biomeListColdiron.add(BiomeGenBase.megaTaiga.biomeName); // Mega Taiga
		biomeListColdiron.add(BiomeGenBase.megaTaigaHills.biomeName); // Mega Taiga Hills
		//biomeListColdiron.add(BiomeGenBase.megaSpruceTaiga.biomeName);
		biomeListColdiron.add(BiomeGenBase.extremeHillsPlus.biomeName); // Extreme Hills +
		//biomeListColdiron.add(BiomeGenBase.extremeHillsPlusM.biomeName);
		//biomeListColdiron.add(BiomeGenBase.stoneBeach.biomeName);
		biomeListMithral.add(BiomeGenBase.extremeHills.biomeName);
		biomeListMithral.add(BiomeGenBase.extremeHillsEdge.biomeName);
		biomeListNickel.add(BiomeGenBase.extremeHills.biomeName);
		biomeListNickel.add(BiomeGenBase.extremeHillsEdge.biomeName);
		biomeListRuby.add(BiomeGenBase.desert.biomeName);
		biomeListRuby.add(BiomeGenBase.desertHills.biomeName);
		biomeListSaltpeter.add(BiomeGenBase.desert.biomeName);
		biomeListSaltpeter.add(BiomeGenBase.desertHills.biomeName);
		biomeListSapphire.add(BiomeGenBase.beach.biomeName);
		biomeListSapphire.add(BiomeGenBase.ocean.biomeName);
		biomeListSulfur.add(BiomeGenBase.extremeHills.biomeName);
		biomeListSulfur.add(BiomeGenBase.extremeHillsEdge.biomeName);
		biomeListTetrahedrite.add(BiomeGenBase.jungle.biomeName);
		biomeListTetrahedrite.add(BiomeGenBase.jungleHills.biomeName);
		biomeListTetrahedrite.add(BiomeGenBase.swampland.biomeName);
		biomeListTetrahedrite.add(BiomeGenBase.mushroomIsland.biomeName);
		biomeListTetrahedrite.add(BiomeGenBase.mushroomIslandShore.biomeName);
		biomeListTetrahedrite.add(BiomeGenBase.extremeHills.biomeName);
		biomeListTetrahedrite.add(BiomeGenBase.extremeHillsEdge.biomeName);
	}
}