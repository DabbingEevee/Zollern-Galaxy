/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.dimensions.providers.eden;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerEdenBiomeStabilize extends GenLayer {
	
	public GenLayerEdenBiomeStabilize(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int nx = x - 1;
		int nz = z - 1;
		int nwidth = width + 2;
		int ndepth = depth + 2;
		int[] input = this.parent.getInts(nx, nz, nwidth, ndepth);
		int[] output = IntCache.getIntCache(width * depth);
		int offX = x & 0x3;
		int offZ = z & 0x3;
		
		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				int centerX = (dx + offX + 1 & 0xFFFFFFFC) - offX;
				int centerZ = (dz + offZ + 1 & 0xFFFFFFFC) - offZ;
				
				if (dx <= centerX + 1 && dx >= centerX - 1 && dz <= centerZ + 1
						&& dz >= centerZ - 1) {
					output[dx + dz * width] = input[centerX + 1 + (centerZ + 1)
							* nwidth];
				} else {
					output[dx + dz * width] = input[dx + 1 + (dz + 1) * nwidth];
				}
			}
		}
		return output;
	}
}