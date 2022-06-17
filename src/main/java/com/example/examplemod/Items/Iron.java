package com.example.examplemod.Items;

import com.example.examplemod.chat.Chat;
import com.example.examplemod.db.Database;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;

public class Iron {
    public static boolean ShowStats = false;
    public static boolean UpdateDB = false; // Update to database

    public static int IronCurrent = 0;
    private static int IronBackUp = 0;
    
    public static int IronGathered = 0; // Total gathered Iron
    public static int IronSpent = 0; // Total spent Iron

    // Set current Iron
    public static void setIron(int Iron) {
        IronCurrent = Iron;
    }

    // Get backup Iron
    public int getBackup() {
        return IronBackUp;
    }

    // Reset all counter
    public static void resetCounters() {
        IronCurrent = 0;
        IronBackUp = 0;
        IronGathered = 0;
        IronSpent = 0;
    }


    // Show stats
    public static String getStats() {
//        Chat.SendMessage("[Iron] Current: " + IronBackUp + " | Gathered: " + IronGathered + " | Spent: " + IronSpent, "white");
//        System.out.println("[Iron] Current: " + IronBackUp + " | Gathered: " + IronGathered + " | Spent: " + IronSpent);
        String stats = "[Iron] Current: " + IronBackUp + " | Gathered: " + IronGathered + " | Spent: " + IronSpent;
        return stats;
    }

    // Get gathered Iron
    public static int getGathered() {
        Chat.SendMessage("[Iron] Gathered: " + IronSpent, "red");
        return IronGathered;
    }

    // Reset gathered counter
    public static void resetGathered() {
        IronGathered = 0;
        Chat.SendMessage("[Iron] Set gathered counter to: 0", "red");
    }

    // Get spent Iron
    public static int getSpent() {
        Chat.SendMessage("[Iron] Spent: " + IronSpent, "red");
        return IronSpent;
    }

    // Reset spent counter
    public static void resetSpent() {
        IronSpent = 0;
        Chat.SendMessage("[Iron] Set spent counter to: 0", "red");
    }

    // Check Iron after update
    public static void checkQty() {
        if (IronCurrent > IronBackUp) {
            IronGathered += IronCurrent - IronBackUp; // Store in gathered
            IronBackUp = IronCurrent; // Set backup as current amount
        }
        else if (IronCurrent < IronBackUp) {
            IronSpent += IronBackUp - IronCurrent; // Store in spent
            IronBackUp = IronCurrent; // Set backup as current amount
        }

//        if (ShowStats) getStats();
        if (UpdateDB) Database.UpdateIron(IronBackUp, IronGathered, IronSpent);
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
        player.sendMessage(new TextComponentString("#stats_Iron_get_spent => Get spent counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_Iron_get_spent"))));
        player.sendMessage(new TextComponentString("#stats_Iron_reset_spent => Reset spent counter").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_Iron_reset_spent"))));
        player.sendMessage(new TextComponentString("#stats_Iron_reset_db => Reset Database stats").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#stats_Iron_reset_db"))));
        player.sendMessage(new TextComponentString("=====================").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
    }
}
