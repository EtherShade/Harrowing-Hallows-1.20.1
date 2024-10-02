package net.ethershade.harrowinghallows.datagen.loot;

import net.ethershade.harrowinghallows.block.ModBlocks;
import net.ethershade.harrowinghallows.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.STYXITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_STYXITE_BLOCK.get());

        this.add(ModBlocks.STYXITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.STYXITE_ORE.get(), ModItems.RAW_STYXITE.get()));

        this.dropSelf(ModBlocks.HALLOWED_LOG.get());
        this.dropSelf(ModBlocks.HALLOWED_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_HALLOWED_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_HALLOWED_WOOD.get());
        this.dropSelf(ModBlocks.HALLOWED_PLANKS.get());
        this.add(ModBlocks.HALLOWED_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.HALLOWED_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.HALLOWED_SIGN.get(), block ->
                createSingleItemTable(ModItems.HALLOWED_SIGN.get()));
        this.add(ModBlocks.HALLOWED_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.HALLOWED_SIGN.get()));
        this.add(ModBlocks.HALLOWED_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.HALLOWED_HANGING_SIGN.get()));
        this.add(ModBlocks.HALLOWED_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.HALLOWED_HANGING_SIGN.get()));
        this.dropSelf(ModBlocks.HALLOWED_SAPLING.get());

        this.dropSelf(ModBlocks.HALLOWSTONE.get());

        this.dropSelf(ModBlocks.HALLOWED_PORTAL.get());
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
