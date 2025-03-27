package net.tastypommeslul.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.tastypommeslul.block.ModBlocks;
import net.tastypommeslul.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        List<ItemConvertible> BLUE_GEM_SMELTABLES = List.of(ModItems.RAW_BLUE_GEM, ModBlocks.BLUE_GEM_ORE, ModBlocks.BLUE_GEM_DEEPSLATE_ORE);

        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                offerSmelting(BLUE_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.BLUE_GEM, 0.7f, 200, "blue_gem");
                offerBlasting(BLUE_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.BLUE_GEM, 0.7f, 100, "blue_gem");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_GEM, RecipeCategory.DECORATIONS, ModBlocks.BLUE_GEM_BLOCK);

            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
