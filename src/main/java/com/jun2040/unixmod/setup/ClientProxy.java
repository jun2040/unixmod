package com.jun2040.unixmod.setup;

import com.jun2040.unixmod.UnixMod;
import com.jun2040.unixmod.blocks.BioreactorScreen;
import com.jun2040.unixmod.blocks.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJLoader;

public class ClientProxy implements IProxy {

    @Override
    public void init() {
        ScreenManager.registerFactory(ModBlocks.BIOREACTOR_CONTAINER, BioreactorScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
