package com.ordana.spelunkery.blocks.dispenser_interactions;

import com.ordana.spelunkery.entities.ThrownGlowstickEntity;
import com.ordana.spelunkery.entities.ThrownMineomiteEntity;
import com.ordana.spelunkery.items.GlowstickItem;
import net.mehvahdjukaar.moonlight.api.util.DispenserHelper;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class GlowstickBehavior extends ProjectileBehavior {

    protected GlowstickBehavior(Item item) {
        super(item);
    }

    @Override
    protected Projectile getProjectileEntity(BlockSource source, Position position, ItemStack stackIn) {
        var entity = new ThrownGlowstickEntity(source.getLevel(), position.x(), position.y(), position.z());
        entity.setItem(stackIn.copyWithCount(1));
        if (stackIn.getItem() instanceof GlowstickItem stick) entity.setColor(stick.getColor());
        return entity;
    }
}