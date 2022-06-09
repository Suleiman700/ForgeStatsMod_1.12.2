package com.example.examplemod.Combact;

import com.example.examplemod.chat.Chat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ProjectileImpact {

    static int Falls = 0;
    public float FallMinVal = 4.0F; // 4 blocks are considered as a fall

    public static void ShowJumps() {
        Chat.SendMessage("[Falls]: " + Falls + " times", "red");
    }

    // Reset counter
    public static void resetCounters() {
        Falls = 0;
    }

    @SubscribeEvent(priority= EventPriority.HIGHEST, receiveCanceled=true)
    public void onEvent(ProjectileImpactEvent event) {
        Chat.SendMessage("ProjectileImpactEvent", "green");
//        if (event.getEntity() instanceof EntityPlayer) {
//            float distance = event.getDistance();
//            if (distance >= FallMinVal) {
//                Falls++;
//            }
//        }
    }
}
