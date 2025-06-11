package net.aelius5.aelius5mod.block.custom;

import com.mojang.serialization.MapCodec;
import net.aelius5.aelius5mod.block.entity.custom.EngravingTableBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EngravingTableBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE_TOP_A = Block.createCuboidShape(0,14,0, 1,16,16);
    private static final VoxelShape SHAPE_TOP_B = Block.createCuboidShape(15,14,0, 16,16,16);
    private static final VoxelShape SHAPE_TOP_C = Block.createCuboidShape(1,14,0, 15,16,1);
    private static final VoxelShape SHAPE_TOP_D = Block.createCuboidShape(1,14,15, 15,16,16);
    private static final VoxelShape SHAPE_TOP_E = Block.createCuboidShape(0,13,0, 16,14,16);
    private static final VoxelShape SHAPE_TOP_F = Block.createCuboidShape(4,11,4, 12,12,12);
    private static final VoxelShape SHAPE_TOP_G = Block.createCuboidShape(2,12,2, 14,13,14);
    private static final VoxelShape SHAPE_TOP_AB = VoxelShapes.union(SHAPE_TOP_A,SHAPE_TOP_B);
    private static final VoxelShape SHAPE_TOP_CD = VoxelShapes.union(SHAPE_TOP_C,SHAPE_TOP_D);
    private static final VoxelShape SHAPE_TOP_EF = VoxelShapes.union(SHAPE_TOP_E,SHAPE_TOP_F);
    private static final VoxelShape SHAPE_TOP_ABCD = VoxelShapes.union(SHAPE_TOP_AB, SHAPE_TOP_CD);
    private static final VoxelShape SHAPE_TOP_ABCDEF = VoxelShapes.union(SHAPE_TOP_ABCD, SHAPE_TOP_EF);
    private static final VoxelShape SHAPE_TOP = VoxelShapes.union(SHAPE_TOP_ABCDEF, SHAPE_TOP_G);
    private static final VoxelShape SHAPE_BOTTOM_A = Block.createCuboidShape(3,0,3, 13,2,13);
    private static final VoxelShape SHAPE_BOTTOM_B = Block.createCuboidShape(4,2,4, 12,2,12);
    private static final VoxelShape SHAPE_BOTTOM = VoxelShapes.union(SHAPE_BOTTOM_A, SHAPE_BOTTOM_B);
    private static final VoxelShape SHAPE_MID = Block.createCuboidShape(5,3,5, 11,11,11);
    private static final VoxelShape SHAPE_TOP_MID = VoxelShapes.union(SHAPE_TOP, SHAPE_MID);
    private static final VoxelShape SHAPE_FULL = VoxelShapes.union(SHAPE_TOP_MID, SHAPE_BOTTOM);

    public static final MapCodec<EngravingTableBlock> CODEC = EngravingTableBlock.createCodec(EngravingTableBlock::new);

    public EngravingTableBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_FULL;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EngravingTableBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof EngravingTableBlockEntity) {
                ItemScatterer.spawn(world, pos, ((EngravingTableBlockEntity) blockEntity))   ;
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if(world.getBlockEntity(pos) instanceof EngravingTableBlockEntity engravingTableBlockEntity){
            if(engravingTableBlockEntity.isEmpty() && !stack.isEmpty()) {
                engravingTableBlockEntity.setStack(0,stack);
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 2f);
                stack.decrement(1);
            } else if(stack.isEmpty()){
                ItemStack stackOnEngravingTable = engravingTableBlockEntity.getStack(0);
                player.setStackInHand(Hand.MAIN_HAND,stackOnEngravingTable);
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
                engravingTableBlockEntity.clear();
            }
        }

        return ItemActionResult.SUCCESS;
    }
}
