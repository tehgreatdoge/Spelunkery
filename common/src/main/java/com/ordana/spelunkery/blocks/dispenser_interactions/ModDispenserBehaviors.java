package com.ordana.spelunkery.blocks.dispenser_interactions;

import com.ordana.spelunkery.reg.ModTags;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.mehvahdjukaar.moonlight.api.util.DispenserHelper;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModDispenserBehaviors {

    public static void init() {
        RegHelper.addDynamicDispenserBehaviorRegistration(ModDispenserBehaviors::registerBehaviors);
    }

    public static void registerBehaviors(DispenserHelper.Event event) {
        event.register(new CBMBehavior());
        event.register(new EggplantBehavior());
        event.register(new MineOMiteBehavior());
        BuiltInRegistries.ITEM.getTagOrEmpty(ModTags.DIAMOND_GRINDABLE).iterator().forEachRemaining(h ->
                event.register(new GrindstoneBehavior(h.value()))
        );
        BuiltInRegistries.ITEM.getTagOrEmpty(ModTags.GRINDABLE).iterator().forEachRemaining(h ->
                event.register(new GrindstoneBehavior(h.value()))
        );
        BuiltInRegistries.ITEM.getTagOrEmpty(ModTags.GLOWSTICKS).iterator().forEachRemaining(h ->
                event.register(new GlowstickBehavior(h.value()))
        );
        BuiltInRegistries.ITEM.getTagOrEmpty(ModTags.PEBBLES).iterator().forEachRemaining(h ->
                event.register(new PebbleBehavior(h.value()))
        );
    }
}