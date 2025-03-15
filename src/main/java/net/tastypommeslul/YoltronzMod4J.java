package net.tastypommeslul;

import net.fabricmc.api.ModInitializer;

import net.tastypommeslul.block.ModBlocks;
import net.tastypommeslul.item.ModItemGroups;
import net.tastypommeslul.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YoltronzMod4J implements ModInitializer {
	// helicopters are not just flying things >:(
	public static final String MOD_ID = "yoltronzmod4j";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}