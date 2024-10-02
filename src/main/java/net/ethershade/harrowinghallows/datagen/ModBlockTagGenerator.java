package net.ethershade.harrowinghallows.datagen;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.ethershade.harrowinghallows.block.ModBlocks;
import net.ethershade.harrowinghallows.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HarrowingHallows.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STYXITE_BLOCK.get(),
                        ModBlocks.RAW_STYXITE_BLOCK.get(),
                        ModBlocks.STYXITE_ORE.get()
                );


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.HALLOWSTONE.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.STYXITE_BLOCK.get(), ModBlocks.RAW_STYXITE_BLOCK.get(), ModBlocks.STYXITE_ORE.get()
                );

        this.tag(ModTags.Blocks.NEEDS_STYXITE_TOOL);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.HALLOWED_LOG.get())
                .add(ModBlocks.HALLOWED_WOOD.get())
                .add(ModBlocks.STRIPPED_HALLOWED_LOG.get())
                .add(ModBlocks.STRIPPED_HALLOWED_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.HALLOWED_PLANKS.get());

        this.tag(ModTags.Blocks.HALLOWSTONE_ORE_REPLACEABLES)
                .add(ModBlocks.HALLOWSTONE.get());
    }
}
