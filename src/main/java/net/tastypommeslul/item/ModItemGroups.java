package net.tastypommeslul.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tastypommeslul.YoltronzMod4J;
import net.tastypommeslul.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup BLUE_GEM_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(YoltronzMod4J.MOD_ID, "blue_gem_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.BLUE_GEM))
                    .displayName(Text.translatable("itemgroup.yoltronzmod4j.blue_gem_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BLUE_GEM);
                        entries.add(ModItems.RAW_BLUE_GEM);

                        entries.add(ModItems.TEST_ITEM);
                    }).build());
    public static final ItemGroup BLUE_GEM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(YoltronzMod4J.MOD_ID, "blue_gem_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.BLUE_GEM_BLOCK))
                    .displayName(Text.translatable("itemgroup.yoltronzmod4j.blue_gem_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BLUE_GEM_BLOCK);
                        entries.add(ModBlocks.BLUE_GEM_ORE);
                        entries.add(ModBlocks.BLUE_GEM_DEEPSLATE_ORE);
                        entries.add(ModBlocks.INSTANT_SMELT_BLOCK);
                    }).build());
    public static final ItemGroup YOLTRONZ4J_UTILITY = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(YoltronzMod4J.MOD_ID, "yoltronz4j_utility"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.BLUE_GEM_BLOCK))
                    .displayName(Text.translatable("itemgroup.yoltronzmod4j.utility"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CAULIFLOWER);

                    }).build());

    public static void registerModItemGroups() {
        YoltronzMod4J.LOGGER.info("Registering Item Groups for " + YoltronzMod4J.MOD_ID);
    }
}
