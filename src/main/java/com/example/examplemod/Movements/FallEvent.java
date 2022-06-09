package com.example.examplemod.Movements;

import com.example.examplemod.chat.Chat;
import com.example.examplemod.db.Database;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FallEvent {

    static int Falls = 0;
    public float FallMinVal = 4.0F; // 4 blocks are considered as a fall

    // Show counter in player chat
    public static void showCounter() {
        Chat.SendMessage("[Falls] " + Falls + " times", "red");
    }

    // Reset counter
    public static void resetCounter() {
        Falls = 0;
    }

    @SubscribeEvent(priority= EventPriority.HIGHEST, receiveCanceled=true)
    public void onEvent(LivingFallEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            float distance = event.getDistance();
            if (distance >= FallMinVal) {
                Falls++;
            }
        }
    }
}
