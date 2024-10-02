package net.ethershade.harrowinghallows.item;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.ethershade.harrowinghallows.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HarrowingHallows.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HARROWING_HALLOWS_TAB = CREATIVE_MODE_TABS.register("harrowing_hallows_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STYXITE_INGOT.get()))
                    .title(Component.translatable("creativetab.harrowing_hallows_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.STYXITE_INGOT.get());
                        pOutput.accept(ModItems.STYXITE_NUGGET.get());
                        pOutput.accept(ModItems.RAW_STYXITE.get());
                        pOutput.accept(ModBlocks.STYXITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_STYXITE_BLOCK.get());
                        pOutput.accept(ModBlocks.STYXITE_ORE.get());
                        pOutput.accept(ModItems.STYXITE_SWORD.get());
                        pOutput.accept(ModItems.STYXITE_PICKAXE.get());
                        pOutput.accept(ModItems.STYXITE_AXE.get());
                        pOutput.accept(ModItems.STYXITE_SHOVEL.get());
                        pOutput.accept(ModItems.STYXITE_HOE.get());
                        pOutput.accept(ModItems.STYXITE_HELMET.get());
                        pOutput.accept(ModItems.STYXITE_CHESTPLATE.get());
                        pOutput.accept(ModItems.STYXITE_LEGGINGS.get());
                        pOutput.accept(ModItems.STYXITE_BOOTS.get());

                        pOutput.accept(ModItems.HALLOWED_SIGN.get());
                        pOutput.accept(ModItems.HALLOWED_HANGING_SIGN.get());
                        pOutput.accept(ModItems.HALLOWED_BOAT.get());
                        pOutput.accept(ModItems.HALLOWED_CHEST_BOAT.get());
                        pOutput.accept(ModBlocks.HALLOWED_LOG.get());
                        pOutput.accept(ModBlocks.HALLOWED_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_HALLOWED_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_HALLOWED_WOOD.get());
                        pOutput.accept(ModBlocks.HALLOWED_PLANKS.get());
                        pOutput.accept(ModBlocks.HALLOWED_LEAVES.get());
                        pOutput.accept(ModBlocks.HALLOWED_SAPLING.get());

                        pOutput.accept(ModBlocks.HALLOWSTONE.get());

                        pOutput.accept(ModBlocks.HALLOWED_PORTAL.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
