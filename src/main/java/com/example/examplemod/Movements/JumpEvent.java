package com.example.examplemod.Movements;

import com.example.examplemod.chat.Chat;
import com.example.examplemod.db.Database;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class JumpEvent {

    static int Jumps = 0;
    public static boolean isJumping = false;

    public static void showCounter() {
        Chat.SendMessage("[JUMPS] " + Jumps + " times", "red");
    }

    // Reset counter
    public static void resetCounter() {
        Jumps = 0;
    }

    @SubscribeEvent(priority= EventPriority.HIGHEST, receiveCanceled=true)
    public void onEvent(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            Database.UpdateJump(Jumps);
            Jumps++;
        }
    }
}
