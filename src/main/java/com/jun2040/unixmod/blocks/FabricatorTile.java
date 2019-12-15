package com.jun2040.unixmod.blocks;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

import static com.jun2040.unixmod.blocks.ModBlocks.FABRICATOR_TILE;

public class FabricatorTile extends TileEntity implements ITickableTileEntity {

    public FabricatorTile() {
        super(FABRICATOR_TILE);
    }

    @Override
    public void tick() {
    }

}
