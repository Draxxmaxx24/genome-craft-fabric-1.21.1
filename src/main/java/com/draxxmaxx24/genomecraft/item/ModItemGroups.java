package com.draxxmaxx24.genomecraft.item;

import com.draxxmaxx24.genomecraft.GenomeCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup GENOMECRAFT_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GenomeCraft.MOD_ID, "genomecraft_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FILLED_SYRINGE_CLEAN))
                    .displayName(Text.translatable("itemgroup.genomecraft.genomecraft_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.EMPTY_SYRINGE);

                        entries.add(ModItems.FILLED_SYRINGE_CONTAMINATED);
                        entries.add(ModItems.FILLED_SYRINGE_CLEAN);
                        entries.add(ModItems.CRUSHED_BLAZE_ROD);
                        entries.add(ModItems.CRUSHED_BREEZE_ROD);
                        entries.add(ModItems.CRUSHED_BONE);
                        entries.add(ModItems.CRUSHED_WITHER_BONE);
                        entries.add(ModItems.WITHER_BONE);

                        entries.add(ModItems.ORGANIC_WASTE);
                    }).build());



    public static void registerItemGroups() {
        GenomeCraft.LOGGER.info("Registering Item Groups for " + GenomeCraft.MOD_ID);
    }
}
