package com.ordana.spelunkery.reg;

import net.mehvahdjukaar.moonlight.api.platform.RegHelper;

public class ModCompostable {
    public static void register() {
        RegHelper.registerCompostable(ModBlocks.CAVE_MUSHROOM_STEM.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.INKCAP_MUSHROOM_BLOCK.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.WHITE_INKCAP_MUSHROOM_BLOCK.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.PHOSPHOR_FUNGUS_BLOCK.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.MUSHGLOOM_BLOCK.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.CONK_FUNGUS_BLOCK.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.PORTABELLA_BLOCK.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.MILLY_BUBCAP_BLOCK.get(), 0.85f);
        RegHelper.registerCompostable(ModItems.GRILLED_PORTABELLA.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.SPOROPHYTE.get(), 0.5f);
        RegHelper.registerCompostable(ModBlocks.TALL_SPOROPHYTE.get(), 0.5f);
        RegHelper.registerCompostable(ModBlocks.PORTABELLA.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.CRIMINI.get(), 0.65f);
        RegHelper.registerCompostable(ModBlocks.BUTTON_MUSHROOM.get(), 0.5f);
        RegHelper.registerCompostable(ModBlocks.INKCAP_MUSHROOM.get(), 0.65f);
        RegHelper.registerCompostable(ModBlocks.WHITE_INKCAP_MUSHROOM.get(), 0.65f);
        RegHelper.registerCompostable(ModBlocks.PHOSPHOR_FUNGUS.get(), 0.65f);
        RegHelper.registerCompostable(ModBlocks.MUSHGLOOM_BLOCK.get(), 0.65f);
        RegHelper.registerCompostable(ModBlocks.CONK_FUNGUS.get(), 0.5f);
        RegHelper.registerCompostable(ModBlocks.TANGLE_ROOTS.get(), 0.5f);
        RegHelper.registerCompostable(ModBlocks.TANGLE_ROOTS_BLOCK.get(), 0.85f);
        RegHelper.registerCompostable(ModBlocks.MILLY_BUBCAP.get(), 0.01f);
    }
}