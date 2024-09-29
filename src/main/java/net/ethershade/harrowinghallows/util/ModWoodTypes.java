package net.ethershade.harrowinghallows.util;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType HALLOWED = WoodType.register(new WoodType(HarrowingHallows.MOD_ID + ":hallowed", BlockSetType.OAK));
}
