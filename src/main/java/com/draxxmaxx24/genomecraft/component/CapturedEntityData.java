package com.draxxmaxx24.genomecraft.component;

import com.mojang.serialization.Codec;
import net.minecraft.util.Identifier;

public record CapturedEntityData(Identifier entityTypeId) {
    public static final Codec<CapturedEntityData> CODEC = Identifier.CODEC
            .fieldOf("entity_type_id")
            .xmap(CapturedEntityData::new, CapturedEntityData::entityTypeId)
            .codec();
}
