package com.jun2040.unixmod.items;


import com.jun2040.unixmod.UnixMod;
import net.minecraft.item.Item;

public class AlienFeces extends Item {
    public AlienFeces() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(UnixMod.setup.subnautica));
        setRegistryName("alien_feces");
    }
}
