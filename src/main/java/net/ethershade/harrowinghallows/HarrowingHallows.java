package net.ethershade.harrowinghallows;

import com.mojang.logging.LogUtils;
import net.ethershade.harrowinghallows.block.ModBlocks;
import net.ethershade.harrowinghallows.block.entity.ModBlockEntities;
import net.ethershade.harrowinghallows.entity.ModEntities;
import net.ethershade.harrowinghallows.entity.client.ModBoatRenderer;
import net.ethershade.harrowinghallows.item.ModCreativeModTabs;
import net.ethershade.harrowinghallows.item.ModItems;
import net.ethershade.harrowinghallows.loot.ModLootModifiers;
import net.ethershade.harrowinghallows.recipe.ModRecipes;
import net.ethershade.harrowinghallows.screen.ModMenuTypes;
import net.ethershade.harrowinghallows.sound.ModSounds;
import net.ethershade.harrowinghallows.util.ModWoodTypes;
import net.ethershade.harrowinghallows.villager.ModVillagers;
import net.ethershade.harrowinghallows.worldgen.biome.ModTerrablender;
import net.ethershade.harrowinghallows.worldgen.biome.surface.ModSurfaceRules;
import net.ethershade.harrowinghallows.worldgen.tree.ModFoliagePlacers;
import net.ethershade.harrowinghallows.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HarrowingHallows.MOD_ID)
public class HarrowingHallows {
    public static final String MOD_ID = "harrowinghallows";
    public static final Logger LOGGER = LogUtils.getLogger();

    public HarrowingHallows() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);

        ModFoliagePlacers.register(modEventBus);
        ModTerrablender.registerBiomes();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.STYXITE_INGOT);
            event.accept(ModItems.RAW_STYXITE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.HALLOWED);

            EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
        }
    }
}
