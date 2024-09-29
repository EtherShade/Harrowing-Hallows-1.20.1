package net.ethershade.harrowinghallows.worldgen.tree;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.ethershade.harrowinghallows.worldgen.tree.custom.HallowedFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, HarrowingHallows.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<HallowedFoliagePlacer>> HALLOWED_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("hallowed_foliage_placer", () -> new FoliagePlacerType<>(HallowedFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
