package net.ethershade.harrowinghallows.worldgen.tree;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.ethershade.harrowinghallows.worldgen.tree.custom.HallowedTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, HarrowingHallows.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<HallowedTrunkPlacer>> PINE_TRUNK_PLACER =
            TRUNK_PLACER.register("pine_trunk_placer", () -> new TrunkPlacerType<>(HallowedTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
