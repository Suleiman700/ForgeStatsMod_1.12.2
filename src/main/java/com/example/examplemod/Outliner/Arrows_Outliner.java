package com.example.examplemod.Outliner;

import com.example.examplemod.chat.Chat;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityArrow;

import java.util.List;

public class Arrows_Outliner {

    public static boolean Enabled = false;

    public static boolean getState() {
        return Enabled;
    }

    public static void re_enable() {
        List<Entity> entities = Minecraft.getMinecraft().world.loadedEntityList;
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof EntityArrow && entities.get(i) instanceof EntityArrow) {
                entities.get(i).setGlowing(Enabled);
            }
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
