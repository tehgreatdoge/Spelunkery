package com.ordana.spelunkery.forge;

import com.ordana.spelunkery.SpelunkeryClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SpelunkeryForge.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpelunkeryForgeClient {

    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {
        // TODO 1.19.2 :: Needed?
//        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_PORTAL_FLUID.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(ModFluids.PORTAL_FLUID.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SPRING_WATER.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(ModFluids.SPRING_WATER.get(), RenderType.translucent());
        event.enqueueWork(SpelunkeryClient::setup);
    }
}
