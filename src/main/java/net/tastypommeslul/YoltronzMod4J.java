package net.tastypommeslul;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.tastypommeslul.block.ModBlocks;
import net.tastypommeslul.item.ModItemGroups;
import net.tastypommeslul.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YoltronzMod4J implements ModInitializer {
	public static final String MOD_ID = "yoltronzmod4j";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistryEvents.BUILD.register(((builder, context) -> {
			builder.add(ModItems.STARLIGHT_ASHES, 8800 /* 16k (coal) + 9600 (blazerod * 4) / 2 (average) */);
		}));
	}
}