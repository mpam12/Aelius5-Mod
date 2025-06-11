package net.aelius5.aelius5mod.block.entity.renderer;

import net.aelius5.aelius5mod.block.entity.custom.EngravingTableBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class EngravingTableBlockEntityRenderer implements BlockEntityRenderer<EngravingTableBlockEntity> {
    public EngravingTableBlockEntityRenderer(BlockEntityRendererFactory.Context context){

    }

    @Override
    public void render(EngravingTableBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getStack(0);
        matrices.push();
        matrices.translate(0.5f,1.3f,0.5f);
        matrices.scale(0.5f,0.5f,0.5f);

        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(entity.getrenderingrotation()));

        itemRenderer.renderItem(stack, ModelTransformationMode.GUI,
                getLightLevel(entity.getWorld(),
                entity.getPos()),
                OverlayTexture.DEFAULT_UV, matrices,
                vertexConsumers, entity.getWorld(), 1);
        matrices.pop();


    }

    private int getLightLevel(World world, BlockPos position)
    {
        int BLight = world.getLightLevel(LightType.BLOCK, position);
        int SLight = world.getLightLevel(LightType.SKY, position);
        return LightmapTextureManager.pack(BLight, SLight);
    }
}
