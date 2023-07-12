package io.github.andrew6rant.sandyglass;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class SandyGlassClient implements ClientModInitializer {

    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SandyGlass.SANDY_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SandyGlass.RED_SANDY_GLASS, RenderLayer.getTranslucent());
    }
}
