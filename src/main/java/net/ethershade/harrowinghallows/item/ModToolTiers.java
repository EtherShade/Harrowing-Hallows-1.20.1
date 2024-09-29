package net.ethershade.harrowinghallows.item;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.ethershade.harrowinghallows.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier STYXITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_STYXITE_TOOL, () -> Ingredient.of(ModItems.STYXITE_INGOT.get())),
            new ResourceLocation(HarrowingHallows.MOD_ID, "styxite"), List.of(Tiers.NETHERITE), List.of());

}
