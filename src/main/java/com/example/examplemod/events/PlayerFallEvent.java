package com.example.examplemod.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class PlayerFallEvent extends Event {
    private final EntityPlayer player;

    private float distance;

    public PlayerFallEvent(EntityPlayer player, float distance) {

        this.player = player;
        this.distance = distance;
    }

    public EntityPlayer getPlayer() {

        return this.player;
    }

    public float getDistance() {

        return this.distance;
    }

    public void setDistance(float distance) {

        this.distance = distance;
    }
}
