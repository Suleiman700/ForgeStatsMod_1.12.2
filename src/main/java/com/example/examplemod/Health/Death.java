package com.example.examplemod.Health;

import com.example.examplemod.Data;
import com.example.examplemod.chat.Chat;
import com.example.examplemod.db.Database;
import com.example.examplemod.events.PlayerTick;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Death {
    public static int count = 0;
    public static boolean saveToDB = true;

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        Entity entity = event.getEntity();
        // If player died
        if (entity instanceof EntityPlayer) {
            String entityPlayerName = entity.getDisplayName().getFormattedText();
//            String playerName = PlayerTick.getPlayerName();
            String playerName = Data.getCustomPlayerName();
            System.out.println(playerName);

//            System.out.println(playerName);
//            System.out.println(entityPlayerName);

            if (entityPlayerName.contains(playerName) || playerName.contains(entityPlayerName) || playerName == entityPlayerName) {
                count++;
                if (saveToDB) {
                    Database.SaveDeath(count);
                }
            }
        }
        // If non-player died
        else {
            String name = event.getEntity().getName();
            Chat.SendMessage("Died: " + name, "yellow");
        }
    }

    // Reset death counter
    public static void resetCount() {
        count = 0;
    }
}
