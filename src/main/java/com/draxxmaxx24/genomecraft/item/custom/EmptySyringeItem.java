package com.draxxmaxx24.genomecraft.item.custom;

import com.draxxmaxx24.genomecraft.component.CapturedEntityData;
import com.draxxmaxx24.genomecraft.component.ModDataComponentTypes;
import com.draxxmaxx24.genomecraft.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Set;

public class EmptySyringeItem extends Item {
    //List of Syringeable Mobs
    public static final Set<EntityType<?>> ALLOWED_MOBS = Set.of(
            //Hostile
            EntityType.ZOMBIE,

            //Passive
            EntityType.CHICKEN

            //Bosses/Rare

    );

    public EmptySyringeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();

        if (!world.isClient) {
            EntityType<?> entityType = entity.getType();
            Identifier typeId = EntityType.getId(entityType);

            if (ALLOWED_MOBS.contains(entityType)) {
                ItemStack contaminatedSyringe = new ItemStack(ModItems.FILLED_SYRINGE_CONTAMINATED);

                contaminatedSyringe.set(ModDataComponentTypes.CAPTURED_ENTITY_ID, new CapturedEntityData(typeId));

                world.playSound(
                        null,
                        user.getBlockPos(),
                        SoundEvents.ITEM_BOTTLE_FILL,
                        SoundCategory.PLAYERS,
                        1.0F,
                        0.8F
                );

                entity.damage(world.getDamageSources().playerAttack(user), 1.0F);

                user.setStackInHand(hand, contaminatedSyringe);

                return ActionResult.SUCCESS;
            } else {
                user.sendMessage(Text.translatable("message.genomecraft.empty_syringe_fail"));
                return ActionResult.FAIL;
            }
        }

        return ActionResult.PASS;
    }
}