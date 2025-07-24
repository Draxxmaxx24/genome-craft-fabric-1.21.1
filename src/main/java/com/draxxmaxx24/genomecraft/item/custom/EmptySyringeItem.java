package com.draxxmaxx24.genomecraft.item.custom;

import com.draxxmaxx24.genomecraft.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class EmptySyringeItem extends Item {
    public EmptySyringeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient && entity instanceof MobEntity) {
            ItemStack filled = createFilledSyringe(entity);
            user.setStackInHand(hand, filled);

            entity.damage(entity.getDamageSources().generic(), 2.0F);
            user.playSound(SoundEvents.ITEM_BOTTLE_FILL, 1.0F, 0.8F);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ItemStack filled = createFilledSyringe(user);
            user.setStackInHand(hand, filled);

            user.damage(user.getDamageSources().generic(), 2.0F);
            user.playSound(SoundEvents.ITEM_BOTTLE_FILL, 1.0F, 0.8F);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    private ItemStack createFilledSyringe(LivingEntity entity) {

        RegistryWrapper.WrapperLookup registryLookup = entity.getWorld().getRegistryManager();


        NbtCompound nbt = new NbtCompound();
        nbt.putString("id", Registries.ITEM.getId(ModItems.FILLED_SYRINGE_CONTAMINATED).toString());
        nbt.putByte("Count", (byte)1);

        Identifier entityId = Registries.ENTITY_TYPE.getId(entity.getType());
        String displayName = entity.getName().getString();
        nbt.putString("StoredEntityId", entityId.toString());

        NbtCompound display = new NbtCompound();
        NbtList lore = new NbtList();
        lore.add(NbtString.of("{\"text\":\"Entity: " + displayName + "\",\"italic\":false,\"color\":\"gray\"}"));
        display.put("Lore", lore);
        nbt.put("display", display);

        return ItemStack.fromNbtOrEmpty(registryLookup, nbt);
    }
}