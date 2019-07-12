package zollerngalaxy.biomes.purgot;

import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.SPOOKY;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorPurgot;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeLimbo extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x00008b;
	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;
	public BiomeDecoratorPurgot biomeDecor = this.getBiomeDecorator();
	
	public BiomeLimbo(BiomeProperties props) {
		super("limbo", props);
		props.setRainDisabled();
		props.setBaseHeight(2.0F);
		this.enableSnow = true;
		this.decorator.flowersPerChunk = -999;
		this.decorator.treesPerChunk = -999;
		this.decorator.grassPerChunk = -999;
		this.decorator.mushroomsPerChunk = -999;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = ZGBlocks.purgBlackRock.getDefaultState();
		this.fillerBlock = ZGBlocks.purgWhiteRock.getDefaultState();
		this.stoneBlock = ZGBlocks.purgStone;
		this.setPlanetForBiome(ZGPlanets.planetPurgot);
	}
	
	@Override
	public void registerTypes(Biome biome) {
		CommonZGRegisterHelper.registerBiomeType(biome, SPOOKY, DEAD);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorPurgot();
	}
	
	protected BiomeDecoratorPurgot getBiomeDecorator() {
		return (BiomeDecoratorPurgot) this.decorator;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
}