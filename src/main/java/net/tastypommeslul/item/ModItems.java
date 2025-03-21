package net.tastypommeslul.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tastypommeslul.YoltronzMod4J;
import net.tastypommeslul.item.custom.TestItem;
import net.tastypommeslul.item.food.ModConsumableComponents;
import net.tastypommeslul.item.food.ModFoodComponents;

public class ModItems {
    public static final Item BLUE_GEM = registerItem("blue_gem", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(YoltronzMod4J.MOD_ID, "blue_gem")))));
    public static final Item RAW_BLUE_GEM = registerItem("raw_blue_gem", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(YoltronzMod4J.MOD_ID, "raw_blue_gem")))));

    public static final Item TEST_ITEM = registerItem("test_item", new TestItem(new Item.Settings().maxDamage(32)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(YoltronzMod4J.MOD_ID, "test_item")))));

    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER, ModConsumableComponents.CAULIFLOWER)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(YoltronzMod4J.MOD_ID, "cauliflower")))));

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(YoltronzMod4J.MOD_ID, name), item);
    }

    public static void registerModItems() {
        YoltronzMod4J.LOGGER.info("Registering Mod Items for " + YoltronzMod4J.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BLUE_GEM);
            entries.add(RAW_BLUE_GEM);
        });
    }
}
