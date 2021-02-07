/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions.worldproviders.orbit;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOverworldOrbit;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.celestial.spacestations.ZGSpaceStations;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderOrbitZG;

public class WorldProviderOrbitExodus extends WorldProviderOverworldOrbit {
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGSpaceStations.EXODUS_SPACE_STATION;
	}
	
	@Override
	public float getSolarSize() {
		return 1.8F;
	}
	
	@Override
	public Vector3 getFogColor() {
		float f = 1.1F - this.getStarBrightness(1.0F);
		return new Vector3(20F / 255F * f, 6F / 255F * f, 248F / 255F * f);
	}
	
	@Override
	public Vector3 getSkyColor() {
		if (this.world.isRaining()) {
			float f = 1.15F - this.getStarBrightness(1.0F);
			return new Vector3(120 / 255F * f, 170 / 255F * f, 190 / 255F * f);
		}
		float f = 1.15F - this.getStarBrightness(1.0F);
		return new Vector3(140 / 255F * f, 161 / 255F * f, 255 / 255F * f);
	}
	
	@Override
	public boolean canRainOrSnow() {
		return false;
	}
	
	@Override
	public boolean hasSunset() {
		return false;
	}
	
	@Override
	public long getDayLength() {
		return 36527L;
	}
	
	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderOrbitZG.class;
	}
	
	@Override
	public boolean isDaytime() {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		float f1 = this.world.getCelestialAngle(par1);
		float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.30F);
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		return f2 * f2 * 1.4F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getSunBrightness(float par1) {
		float f1 = this.world.getCelestialAngle(1.0F);
		float f2 = 0.9F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		f2 = 1.0F - f2;
		return f2 * 1.6F;
	}
	
	@Override
	public boolean isSkyColored() {
		return false;
	}
	
	@Override
	public double getHorizon() {
		return 44.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 44;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}
	
	@Override
	public float getGravity() {
		return 0.073F;// 0.073F;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return true;
	}
	
	@Override
	public double getMeteorFrequency() {
		return 0;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 6.5D;
	}
	
	@Override
	public String getPlanetToOrbit() {
		return "planet.exodus";
	}
	
	@Override
	public String getSaveFolder() {
		return "space_stations/exodus";
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return ConfigManagerCore.spaceStationEnergyScalar;
	}
	
	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier > ZGPlanets.planetExodus.getTierRequirement();
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.24F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 50.0F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		return 0;
	}
	
	@Override
	public float getWindLevel() {
		return 0.5F;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ZGDimensions.EXODUS_ORBIT;
	}
}