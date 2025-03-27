package net.tastypommeslul.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.tastypommeslul.YoltronzMod4J;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(YoltronzMod4J.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag();

        private static TagKey<Item> createTag() {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(YoltronzMod4J.MOD_ID, "transformable_items"));
        }
    }
}
