package net.ethershade.harrowinghallows.util;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_STYXITE_TOOL = tag("needs_sapphire_tool");
        public static final TagKey<Block> HALLOWSTONE_ORE_REPLACEABLES = tag("hallowstone_ore_replaceables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(HarrowingHallows.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(HarrowingHallows.MOD_ID, name));
        }
    }
}
