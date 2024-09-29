package net.ethershade.harrowinghallows.datagen;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.ethershade.harrowinghallows.block.ModBlocks;
import net.ethershade.harrowinghallows.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, HarrowingHallows.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.STYXITE_HELMET.get(),
                        ModItems.STYXITE_CHESTPLATE.get(),
                        ModItems.STYXITE_LEGGINGS.get(),
                        ModItems.STYXITE_BOOTS.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.HALLOWED_LOG.get().asItem())
                .add(ModBlocks.HALLOWED_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_HALLOWED_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_HALLOWED_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.HALLOWED_PLANKS.get().asItem());
    }
}
