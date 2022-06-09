package com.example.examplemod.Items;

import com.example.examplemod.chat.Chat;
import com.example.examplemod.db.Database;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;

public class Diamond {
    public static boolean ShowStats = true;
    public static boolean UpdateDB = true; // Update to database

    public static int DiamondCurrent = 0;
    private static int DiamondBackUp = 0;
    
    public static int DiamondGathered = 0; // Total gathered diamond
    public static int DiamondSpent = 0; // Total spent diamond

    // Set current diamond
    public static void setDiamond(int diamond) {
        DiamondCurrent = diamond;
    }

    // Get backup diamond
    public int getBackup() {
        return DiamondBackUp;
    }


    // Reset all counter
    public static void resetCounters() {
        DiamondCurrent = 0;
        DiamondBackUp = 0;
        DiamondGathered = 0;
        DiamondSpent = 0;
    }

    // Show stats
    public static void getStats() {
        Chat.SendMessage("[DIAMOND] Current: " + DiamondBackUp + " | Gathered: " + DiamondGathered + " | Spent: " + DiamondSpent, "blue");
//        System.out.println("[DIAMOND] Current: " + DiamondBackUp + " | Gathered: " + DiamondGathered + " | Spent: " + DiamondSpent);
    }

    // Get gathered diamond
    public static int getGathered() {
        Chat.SendMessage("[DIAMOND] Gathered: " + DiamondSpent, "red");
        return DiamondGathered;
    }

    // Reset gathered counter
    public static void resetGathered() {
        DiamondGathered = 0;
        Chat.SendMessage("[DIAMOND] Set gathered counter to: 0", "red");
    }

    // Get spent diamond
    public static int getSpent() {
        Chat.SendMessage("[DIAMOND] Spent: " + DiamondSpent, "red");
        return DiamondSpent;
    }

    // Reset spent counter
    public static void resetSpent() {
        DiamondSpent = 0;
        Chat.SendMessage("[DIAMOND] Set spent counter to: 0", "red");
    }

    // Check Diamond after update
    public static void checkQty() {
        if (DiamondCurrent > DiamondBackUp) {
            DiamondGathered += DiamondCurrent - DiamondBackUp; // Store in gathered
            DiamondBackUp = DiamondCurrent; // Set backup as current amount
        }
        else if (DiamondCurrent < DiamondBackUp) {
            DiamondSpent += DiamondBackUp - DiamondCurrent; // Store in spent
            DiamondBackUp = DiamondCurrent; // Set backup as current amount
        }

//        if (ShowStats) getStats();
        if (UpdateDB) Database.UpdateDiamond(DiamondBackUp, DiamondGathered, DiamondSpent);
    }

    // Show commands to player
    public static void ShowCommands() {
        EntityPlayer player = Minecraft.getMinecraft().player;
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("===[ Stats Diamond ] ===").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("#stats_diamond_help => This message").setStyle(new Style().setColor(TextFormatting.RED)));
        player.sendMessage(new TextComponentString("#stats_diamond_get_stats => Get stats").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_diamond_get_stats"))));
        player.sendMessage(new TextComponentString("#stats_diamond_get_gathered => Get gathered counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_diamond_get_gathered"))));
        player.sendMessage(new TextComponentString("#stats_diamond_reset_gathered => Reset gathered counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_diamond_reset_gathered"))));
        player.sendMessage(new TextComponentString("#stats_diamond_get_spent => Get spent counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_diamond_get_spent"))));
        player.sendMessage(new TextComponentString("#stats_diamond_reset_spent => Reset spent counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_diamond_reset_spent"))));
        player.sendMessage(new TextComponentString("#stats_diamond_reset_db => Reset Database stats").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_diamond_reset_db"))));
        player.sendMessage(new TextComponentString("=====================").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
    }
}
