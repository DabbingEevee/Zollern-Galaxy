package galaxymod.blocks.eden.ores;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.ModInfo;
import java.util.Random;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class EdenDeshOre extends BlockNova {
	
	public EdenDeshOre() {
		super(Material.rock);
		this.setBlockName(ModInfo.MODID + "_edendeshore");
		this.setBlockTextureName(ModInfo.MODID + ":edendeshore");
		this.setHardness(4.0F);
		this.setResistance(2.0F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return MarsItems.marsItemBasic;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		if (p_149745_1_.nextInt(10) == 2) {
			return 2;
		} else {
			return 1;
		}
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 6, 11);
			
			return j1;
		}
		return 0;
	}
}