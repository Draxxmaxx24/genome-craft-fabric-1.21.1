package com.draxxmaxx24.genomecraft.item;

import com.draxxmaxx24.genomecraft.GenomeCraft;
import com.draxxmaxx24.genomecraft.item.custom.EmptySyringeItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FILLED_SYRINGE_CONTAMINATED = registerItem("filled_syringe_contaminated", new Item(new Item.Settings().maxCount(1)));
    public static final Item FILLED_SYRINGE_CLEAN = registerItem("filled_syringe_clean", new Item(new Item.Settings().maxCount(1)));

    public static final Item EMPTY_SYRINGE = registerItem("empty_syringe", new EmptySyringeItem(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GenomeCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GenomeCraft.LOGGER.info("Registering Mod Items for " + GenomeCraft.MOD_ID);
    }
}
