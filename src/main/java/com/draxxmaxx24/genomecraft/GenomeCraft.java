package com.draxxmaxx24.genomecraft;

import com.draxxmaxx24.genomecraft.component.ComponentChecker;
import com.draxxmaxx24.genomecraft.component.ModDataComponentTypes;
import com.draxxmaxx24.genomecraft.item.ModItemGroups;
import com.draxxmaxx24.genomecraft.item.ModItems;
import com.draxxmaxx24.genomecraft.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GenomeCraft implements ModInitializer {
	public static final String MOD_ID = "genomecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();

		ModDataComponentTypes.registerDataComponentTypes();

		ModLootTableModifiers.modifyLootTables();
	}
}