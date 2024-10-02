package net.ethershade.harrowinghallows.datagen;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.ethershade.harrowinghallows.block.ModBlocks;
import net.minecraft.client.model.Model;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HarrowingHallows.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.STYXITE_BLOCK);
        blockWithItem(ModBlocks.RAW_STYXITE_BLOCK);
        blockWithItem(ModBlocks.STYXITE_ORE);

        logBlock(((RotatedPillarBlock) ModBlocks.HALLOWED_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.HALLOWED_WOOD.get()), blockTexture(ModBlocks.HALLOWED_LOG.get()), blockTexture(ModBlocks.HALLOWED_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_HALLOWED_LOG.get()), blockTexture(ModBlocks.STRIPPED_HALLOWED_LOG.get()),
                new ResourceLocation(HarrowingHallows.MOD_ID, "block/stripped_hallowed_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_HALLOWED_WOOD.get()), blockTexture(ModBlocks.STRIPPED_HALLOWED_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_HALLOWED_LOG.get()));

        blockItem(ModBlocks.HALLOWED_LOG);
        blockItem(ModBlocks.HALLOWED_WOOD);
        blockItem(ModBlocks.STRIPPED_HALLOWED_LOG);
        blockItem(ModBlocks.STRIPPED_HALLOWED_WOOD);

        blockWithItem(ModBlocks.HALLOWED_PLANKS);

        leavesBlock(ModBlocks.HALLOWED_LEAVES);

        signBlock(((StandingSignBlock) ModBlocks.HALLOWED_SIGN.get()), ((WallSignBlock) ModBlocks.HALLOWED_WALL_SIGN.get()),
                blockTexture(ModBlocks.HALLOWED_PLANKS.get()));

        hangingSignBlock(ModBlocks.HALLOWED_HANGING_SIGN.get(), ModBlocks.HALLOWED_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.HALLOWED_PLANKS.get()));
        saplingBlock(ModBlocks.HALLOWED_SAPLING);

        blockWithItem(ModBlocks.HALLOWED_PORTAL);
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(HarrowingHallows.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
