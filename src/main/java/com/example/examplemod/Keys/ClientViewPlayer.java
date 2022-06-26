package com.example.examplemod.Keys;

import java.util.UUID;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientViewPlayer extends EntityPlayer {

    public ClientViewPlayer(World world) {
        super(world, new GameProfile(UUID.fromString("41C82C87-7AfB-4024-BA57-13D2C99CAE77"), "[Minecraft]"));
    }

    @Override
    public void onUpdate() {
        return;
    }

    @Override
    public void onLivingUpdate() {
        return;
    }

    @Override
    public void onEntityUpdate() {
        return;
    }

    @Override
    public boolean isCreative() {
        return false;
    }

    @Override
    public boolean isSpectator() {
        return false;
    }

}
