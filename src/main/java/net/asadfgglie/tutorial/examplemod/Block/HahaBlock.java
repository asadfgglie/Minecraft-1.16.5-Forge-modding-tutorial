package net.asadfgglie.tutorial.examplemod.Block;

import net.asadfgglie.tutorial.examplemod.Item.MyItem;
import net.asadfgglie.tutorial.examplemod.Block.TileEntity.HahaBlockTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class HahaBlock extends Block {

    public HahaBlock (AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new HahaBlockTileEntity();
    }

    @Override
    @SuppressWarnings("deprecation") // remove warning
    // When player left-clicked this block
    public void onBlockClicked (BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if(!worldIn.isRemote()){
            player.sendStatusMessage(new TranslationTextComponent("message.tutorial.haha_block_left-clicked"), false);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    // When player right-clicked this block
    public ActionResultType onBlockActivated (BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote() && handIn == Hand.MAIN_HAND){
            HahaBlockTileEntity tile = (HahaBlockTileEntity) worldIn.getTileEntity(pos);

            player.dropItem(new ItemStack(MyItem.haha.get()), false, false).setNoPickupDelay();
            player.sendStatusMessage(new TranslationTextComponent("message.tutorial.haha_block_right-clicked"), false);

            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    @Override
    public void onEntityWalk (World worldIn, BlockPos pos, Entity entityIn) {
        if(!worldIn.isRemote() && entityIn instanceof PlayerEntity){
            HahaBlockTileEntity tile = (HahaBlockTileEntity) worldIn.getTileEntity(pos);

            if(!tile.walker.contains((PlayerEntity) entityIn)) {
                ((PlayerEntity) entityIn).sendStatusMessage(new TranslationTextComponent("message.tutorial.haha_block_onWalk"), false);
                tile.walker.add((PlayerEntity) entityIn);
            }
        }
    }
}
