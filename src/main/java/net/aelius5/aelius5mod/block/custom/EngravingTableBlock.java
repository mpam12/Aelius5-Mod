package net.aelius5.aelius5mod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class EngravingTableBlock extends Block{
    private static final VoxelShape SHAPE_TOP_A = Block.createCuboidShape(0,14,0, 1,16,16);
    private static final VoxelShape SHAPE_TOP_B = Block.createCuboidShape(15,14,0, 16,16,16);
    private static final VoxelShape SHAPE_TOP_C = Block.createCuboidShape(1,14,0, 14,16,1);
    private static final VoxelShape SHAPE_TOP_D = Block.createCuboidShape(1,14,15, 14,16,16);
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

    public EngravingTableBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_FULL;
    }
}
