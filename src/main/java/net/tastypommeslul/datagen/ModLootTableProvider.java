package net.tastypommeslul.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.tastypommeslul.block.ModBlocks;
import net.tastypommeslul.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLUE_GEM_BLOCK);
        addDrop(ModBlocks.INSTANT_SMELT_BLOCK);

        addDrop(ModBlocks.BLUE_GEM_ORE, oreDrops(ModBlocks.BLUE_GEM_ORE, ModItems.RAW_BLUE_GEM));
        addDrop(ModBlocks.BLUE_GEM_DEEPSLATE_ORE, oreDrops(ModBlocks.BLUE_GEM_DEEPSLATE_ORE, ModItems.RAW_BLUE_GEM));
    }
}
