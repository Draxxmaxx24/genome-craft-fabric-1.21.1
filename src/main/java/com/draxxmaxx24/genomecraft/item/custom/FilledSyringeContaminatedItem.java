package com.draxxmaxx24.genomecraft.item.custom;

import com.draxxmaxx24.genomecraft.component.CapturedEntityData;
import com.draxxmaxx24.genomecraft.component.ModDataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FilledSyringeContaminatedItem extends Item {
    public FilledSyringeContaminatedItem(Item.Settings settings) {
        super(settings);
    }

    public boolean hasCapturedEntity(ItemStack stack) {
        return stack.contains(ModDataComponentTypes.CAPTURED_ENTITY_ID);
    }

    @Nullable
    public CapturedEntityData getCapturedEntityData(ItemStack stack) {
        if (hasCapturedEntity(stack)) {
            return stack.get(ModDataComponentTypes.CAPTURED_ENTITY_ID);
        }
        return null;
    }

    @Nullable
    public Identifier getCapturedEntityId(ItemStack stack) {
        CapturedEntityData data = getCapturedEntityData(stack);
        return data != null ? data.entityTypeId() : null;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        Identifier entityId = getCapturedEntityId(stack);

        if (entityId != null) {
            EntityType<?> entityType = Registries.ENTITY_TYPE.get(entityId);

            Text label = Text.translatable("tooltip.genomecraft.contaminatedsyringe.captured_entity")
                    .styled(style -> style.withColor(Formatting.GRAY).withItalic(true));

            Text entityName = entityType != null
                    ? entityType.getName().copy().styled(style -> style.withColor(Formatting.AQUA).withBold(true))
                    : Text.literal(entityId.toString()).styled(style -> style.withColor(Formatting.DARK_RED));

            tooltip.add(label.copy().append(entityName));
        } else {
            tooltip.add(Text.translatable("tooltip.genomecraft.contaminatedsyringe.no_entity")
                    .styled(style -> style.withColor(Formatting.DARK_GRAY).withItalic(true)));
        }
    }
}

