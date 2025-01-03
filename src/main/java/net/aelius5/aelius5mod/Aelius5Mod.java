package net.aelius5.aelius5mod;

import net.aelius5.aelius5mod.block.ModBlocks;
import net.aelius5.aelius5mod.item.ModItemGroups;
import net.aelius5.aelius5mod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aelius5Mod implements ModInitializer {
	public static final String MOD_ID = "aelius5mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		LOGGER.info("Hello Fabric world!");
	}
}