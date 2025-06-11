package net.aelius5.aelius5mod;

import net.aelius5.aelius5mod.block.entity.custom.ModBlockEntities;
import net.aelius5.aelius5mod.block.entity.renderer.EngravingTableBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class Aelius5ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.ENGRAVING_TABLE_BLOCK_ENTITY, EngravingTableBlockEntityRenderer::new);
    }
}
