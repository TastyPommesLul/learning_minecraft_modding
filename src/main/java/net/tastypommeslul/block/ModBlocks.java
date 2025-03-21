
package net.tastypommeslul.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.tastypommeslul.YoltronzMod4J;
import net.tastypommeslul.block.custom.InstantSmeltBlock;

public class ModBlocks {
    public static final Block BLUE_GEM_BLOCK = registerBlock("blue_gem_block",
            new Block(AbstractBlock.Settings.create().strength(5f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERITE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, "blue_gem_block")))));

    public static final Block BLUE_GEM_ORE = registerBlock("blue_gem_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create()
                    .strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, "blue_gem_ore")))));

    public static final Block BLUE_GEM_DEEPSLATE_ORE = registerBlock("blue_gem_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create()
                    .strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, "blue_gem_deepslate_ore")))));

    public static final Block INSTANT_SMELT_BLOCK = registerBlock("instant_smelt_block",
            new InstantSmeltBlock(AbstractBlock.Settings.create()
                    .strength(2f).requiresTool().sounds(BlockSoundGroup.VAULT)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, "instant_smelt_block")))));


    private static Block registerBlock(String name, Block block) {
        Registry.register(Registries.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, name), block);
        registerBlockItem(name, block);
        return block;
    }

    private static void registerBlockItem(String name, Block block) {
        BlockItem item = new BlockItem(block, new Item.Settings()
                .useBlockPrefixedTranslationKey()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(YoltronzMod4J.MOD_ID, name))));
        Registry.register(Registries.ITEM, Identifier.of(YoltronzMod4J.MOD_ID, name), item);
    }

    public static void registerModBlocks() {
        YoltronzMod4J.LOGGER.info("Registering Mod Blocks for " + YoltronzMod4J.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(BLUE_GEM_BLOCK);
            entries.add(BLUE_GEM_ORE);
            entries.add(BLUE_GEM_DEEPSLATE_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(INSTANT_SMELT_BLOCK);
        });
    }
}