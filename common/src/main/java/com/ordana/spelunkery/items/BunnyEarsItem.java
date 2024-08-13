package com.ordana.spelunkery.items;

import dev.architectury.injectables.annotations.PlatformOnly;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BunnyEarsItem extends ArmorItem {

    public BunnyEarsItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @PlatformOnly(PlatformOnly.FORGE)
    //@Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isClientSide()) {
            renderEars(stack, level, player, level);
        }
    }

    @PlatformOnly(PlatformOnly.FABRIC)
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide && entity instanceof LivingEntity livingEntity) {
            if (livingEntity.getItemBySlot(EquipmentSlot.HEAD) == stack) {
                renderEars(stack, level, entity, level);
            }
        }
        super.inventoryTick(stack, level, entity, slot, selected);
    }

    private static void renderEars(ItemStack stack, Level level, Entity entity, Level serverLevel) {

        //render ears,,, somehow??

    }
}