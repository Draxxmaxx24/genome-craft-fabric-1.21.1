package com.draxxmaxx24.genomecraft.component;


import com.draxxmaxx24.genomecraft.GenomeCraft;
import net.minecraft.item.ItemStack;

public class ComponentChecker {
    public static boolean hasMyCustomComponent(ItemStack filledSyringeContaminatedItem) {
        // Check if the itemStack contains the specific data component
        return filledSyringeContaminatedItem.contains(ModDataComponentTypes.CAPTURED_ENTITY_ID);
    }
}
