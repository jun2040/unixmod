package com.jun2040.unixmod.blocks;

import com.jun2040.unixmod.blocks.Fabricator;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("unixmod:fabricator")
    public static Fabricator FABRICATOR;

    @ObjectHolder("unixmod:fabricator")
    public static TileEntityType<FabricatorTile> FABRICATOR_TILE;

    @ObjectHolder("unixmod:bioreactor")
    public static Bioreactor BIOREACTOR;

    @ObjectHolder("unixmod:bioreactor")
    public static TileEntityType<BioreactorTile> BIOREACTOR_TILE;

    @ObjectHolder("unixmod:bioreactor")
    public static ContainerType<BioreactorContainer> BIOREACTOR_CONTAINER;
}
