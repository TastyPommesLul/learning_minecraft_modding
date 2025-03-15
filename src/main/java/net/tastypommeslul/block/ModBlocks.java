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

public class ModBlocks {
    public static final Block BLUE_GEM_BLOCK = registerBlock("blue_gem_block",
            AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERITE));
    public static final Block BLUE_GEM_ORE = registerBlock("blue_gem_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)).getSettings());
    public static final Block BLUE_GEM_DEEPSLATE_ORE = registerBlock("blue_gem_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)).getSettings());

    /// public static final Block BLUE_GEM_BLOCK = registerBlock("blue_gem_block",
    ///             AbstractBlock.Settings.create().strength(4f)
    ///                     .requiresTool().sounds(BlockSoundGroup.NETHERITE), RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, "blue_gem_block")));
    ///     public static final Block BLUE_GEM_ORE = registerBlock("blue_gem_ore",
    ///             new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
    ///                     AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)).getSettings(), RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, "blue_gem_ore")));
    ///     public static final Block BLUE_GEM_DEEPSLATE_ORE = registerBlock("blue_gem_deepslate_ore",
    ///             new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
    ///                     AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)).getSettings(), RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, "blue_gem_deepslate_ore")));


    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, name));
        System.out.println("Registering block with key: " + key);
        Block block = new Block(blockSettings.registryKey(key));
        Registry.register(Registries.BLOCK, key, block);
        registerBlockItem(name, block, key);
        return block;
    }

    /// private static Block registerBlock(String name, AbstractBlock.Settings blockSettings, RegistryKey<Block> key</Block>) {
    ///         System.out.println("Registering block with key: " + key);
    ///         Block block = new Block(blockSettings.registryKey(key));
    ///         Registry.register(Registries.BLOCK, key, block);
    ///         registerBlockItem(name, block, key);
    ///         return block;
    ///     }


    private static void registerBlockItem(String name, Block block, RegistryKey<Block> key) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(YoltronzMod4J.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(itemKey));
        System.out.println("Registering block item with block ID: " + key.getValue()); // Use the getValue method
        Registry.register(Registries.ITEM, itemKey, item);
    }

    public static void registerModBlocks() {
        YoltronzMod4J.LOGGER.info("Registering Mod Blocks for " + YoltronzMod4J.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(BLUE_GEM_BLOCK);
            entries.add(BLUE_GEM_ORE);
            entries.add(BLUE_GEM_DEEPSLATE_ORE);
        });
    }
}
