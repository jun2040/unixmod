package com.jun2040.unixmod.setup;

import com.jun2040.unixmod.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
    public ItemGroup itemGroup = new ItemGroup("subnautica") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.FABRICATOR);
        }
    };

    public void init() {

    }

}
