package net.ethershade.harrowinghallows.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.ethershade.harrowinghallows.worldgen.tree.ModFoliagePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class HallowedFoliagePlacer extends FoliagePlacer {
    public static final Codec<HallowedFoliagePlacer> CODEC = RecordCodecBuilder.create(pineFoliagePlacerInstance
            -> foliagePlacerParts(pineFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(pineFoliagePlacerInstance, HallowedFoliagePlacer::new));
    private final int height;

    public HallowedFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.HALLOWED_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {

        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0), 2, 2, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(1), 2, 2, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2), 2, 2, pAttachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
