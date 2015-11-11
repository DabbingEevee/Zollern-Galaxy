package galaxymod.biomes.eden;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenBloodDesert extends BiomeGenEdenBase {
	public BiomeEdenBloodDesert(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Blood Desert");
		this.setHeight(new Height(0.4F, 0.6F));
		this.setChunkHeightModifier(16);
		this.getBiomeDecorator().edenTallGrassPerChunk = 0;
		this.getBiomeDecorator().edenFlowersPerChunk = 0;
		this.grassFoilageColorMultiplier = 0xbf0000;
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.deadBushPerChunk = 2;
		this.waterColorMultiplier = 0x8b009f;
		this.temperature = 8F;
		this.topBlock = BlockList.edenBloodSand;
		this.fillerBlock = BlockList.edenBloodStone;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f2a00;
	}
}