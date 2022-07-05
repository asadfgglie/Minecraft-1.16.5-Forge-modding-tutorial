package net.asadfgglie.tutorial.examplemod.Block.TileEntity;

import net.asadfgglie.tutorial.examplemod.Block.MyBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

import java.util.HashSet;

public class HahaBlockTileEntity extends TileEntity implements ITickableTileEntity {
    public HashSet<PlayerEntity> walker = new HashSet<>();

    public HahaBlockTileEntity(){
        super(MyTileEntity.hahaBlockTileEntity.get());
    }

    @Override
    public void tick () {
        walker.removeIf(player -> player.getEntityWorld().getBlockState(new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ())).getBlock() != MyBlock.haha_block.get());
    }
}
