package net.ethershade.harrowinghallows.datagen;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.ethershade.harrowinghallows.item.ModItems;
import net.ethershade.harrowinghallows.loot.AddItemModifier;
import net.ethershade.harrowinghallows.loot.AddSusSandItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, HarrowingHallows.MOD_ID);
    }

    @Override
    protected void start() {

    }
}
