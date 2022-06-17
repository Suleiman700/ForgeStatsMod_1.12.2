package com.example.examplemod.Items;

import com.example.examplemod.chat.Chat;
import com.example.examplemod.db.Database;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;

public class Gold {
    private static String ItemName = "Gold";
    public static boolean ShowStats = true;
    public static boolean UpdateDB = false; // Update to database

    public static int Current = 0;
    private static int BackUp = 0;
    public static int Gathered = 0; // Total gathered Iron
    public static int Spent = 0; // Total Spent Iron

    // Set current Iron
    public static void set(int count) {
        Current = count;
    }

    // Get backup Iron
    public int getBackup() {
        return BackUp;
    }


    // Reset all counter
    public static void resetCounters() {
        Current = 0;
        BackUp = 0;
        Gathered = 0;
        Spent = 0;
    }

    // Show stats
    public static String getStats() {
//        Chat.SendMessage("[Gold] Current: " + BackUp + " | Gathered: " + Gathered + " | Spent: " + Spent, "yellow");
//        System.out.println("[Gold] Current: " + BackUp + " | Gathered: " + Gathered + " | Spent: " + Spent);
        String stats = "[Gold] Current: " + BackUp + " | Gathered: " + Gathered + " | Spent: " + Spent;
        return stats;
    }

    // Get gathered Iron
    public static int getGathered() {
        Chat.SendMessage("[Iron] Gathered: " + Spent, "red");
        return Gathered;
    }

    // Reset gathered counter
    public static void resetGathered() {
        Gathered = 0;
        Chat.SendMessage("[Iron] Set gathered counter to: 0", "red");
    }

    // Get Spent Iron
    public static int getSpent() {
        Chat.SendMessage("[Iron] Spent: " + Spent, "red");
        return Spent;
    }

    // Reset Spent counter
    public static void resetSpent() {
        Spent = 0;
        Chat.SendMessage("[Iron] Set Spent counter to: 0", "red");
    }

    // Check Iron after update
    public static void checkQty() {
        if (Current > BackUp) {
            Gathered += Current - BackUp; // Store in gathered
            BackUp = Current; // Set backup as current amount
        }
        else if (Current < BackUp) {
            Spent += BackUp - Current; // Store in Spent
            BackUp = Current; // Set backup as current amount
        }

//        if (ShowStats) getStats();
        if (UpdateDB) Database.UpdateGold(BackUp, Gathered, Spent);
    }

    // Show commands to player
    public static void ShowCommands() {
        EntityPlayer player = Minecraft.getMinecraft().player;
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("===[ Stats Iron ] ===").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("#stats_Iron_help => This message").setStyle(new Style().setColor(TextFormatting.RED)));
        player.sendMessage(new TextComponentString("#stats_Iron_get_stats => Get stats").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_Iron_get_stats"))));
        player.sendMessage(new TextComponentString("#stats_Iron_get_gathered => Get gathered counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_Iron_get_gathered"))));
        player.sendMessage(new TextComponentString("#stats_Iron_reset_gathered => Reset gathered counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_Iron_reset_gathered"))));
        player.sendMessage(new TextComponentString("#stats_Iron_get_Spent => Get Spent counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_Iron_get_Spent"))));
        player.sendMessage(new TextComponentString("#stats_Iron_reset_Spent => Reset Spent counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_Iron_reset_Spent"))));
        player.sendMessage(new TextComponentString("#stats_Iron_reset_db => Reset Database stats").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_Iron_reset_db"))));
        player.sendMessage(new TextComponentString("=====================").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
    }
}
