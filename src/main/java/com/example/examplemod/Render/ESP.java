package com.example.examplemod.Render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ESP {

    public static boolean Enabled = false;
    public static boolean Enabled_Items = true;

    public static boolean getState() {
        return Enabled;
    }

    public static void toggleState() {
        if (Enabled) {
            Enabled = false;
        }
        else {
            Enabled = true;
        }

        for (EntityPlayer p : Minecraft.getMinecraft().world.playerEntities) {
            p.setGlowing(Enabled);
        }
    }
}
