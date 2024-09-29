package net.ethershade.harrowinghallows.worldgen.biome;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(HarrowingHallows.MOD_ID, "overworld"), 5));
    }
}
