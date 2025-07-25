package com.draxxmaxx24.genomecraft.item;

import com.draxxmaxx24.genomecraft.GenomeCraft;
import com.draxxmaxx24.genomecraft.item.custom.EmptySyringeItem;
import com.draxxmaxx24.genomecraft.item.custom.ModFoodComponents;
import com.draxxmaxx24.genomecraft.item.custom.OrganicWasteItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FILLED_SYRINGE_CONTAMINATED = registerItem("filled_syringe_contaminated", new Item(new Item.Settings().maxCount(1)));
    public static final Item FILLED_SYRINGE_CLEAN = registerItem("filled_syringe_clean", new Item(new Item.Settings().maxCount(1)));
    public static final Item CRUSHED_BLAZE_ROD = registerItem("crushed_blaze_rod", new Item(new Item.Settings()));
    public static final Item CRUSHED_BREEZE_ROD = registerItem("crushed_breeze_rod", new Item(new Item.Settings()));
    public static final Item WITHER_BONE = registerItem("wither_bone", new Item(new Item.Settings()));
    public static final Item CRUSHED_WITHER_BONE = registerItem("crushed_wither_bone", new Item(new Item.Settings()));
    public static final Item CRUSHED_BONE = registerItem("crushed_bone", new Item(new Item.Settings()));

    public static final Item EMPTY_SYRINGE = registerItem("empty_syringe", new EmptySyringeItem(new Item.Settings().maxCount(1)));

    public static final Item ORGANIC_WASTE = registerItem("organic_waste", new OrganicWasteItem(new Item.Settings().food(ModFoodComponents.ORGANIC_WASTE).maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GenomeCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GenomeCraft.LOGGER.info("Registering Mod Items for " + GenomeCraft.MOD_ID);
    }
}
