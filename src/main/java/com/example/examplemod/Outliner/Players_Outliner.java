package com.example.examplemod.Outliner;

import com.example.examplemod.chat.Chat;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class Players_Outliner {

    public static boolean Enabled = false;

    public static boolean getState() {
        return Enabled;
    }

    public static void setState(boolean state) {
        Enabled = state;
        re_enable();
    }

    public static void re_enable() {
        for (EntityPlayer p : Minecraft.getMinecraft().world.playerEntities) {
            p.setGlowing(Enabled);
        }
    }

    public static void toggleState() {
        if (Enabled) {
            Enabled = false;
        }
        else {
            Enabled = true;
        }

        re_enable();
    }
}
