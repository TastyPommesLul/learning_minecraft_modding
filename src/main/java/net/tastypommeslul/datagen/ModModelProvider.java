package net.tastypommeslul.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.tastypommeslul.block.ModBlocks;
import net.tastypommeslul.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_GEM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INSTANT_SMELT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_GEM_DEEPSLATE_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TEST_ITEM, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BLUE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BLUE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);

    }
}
