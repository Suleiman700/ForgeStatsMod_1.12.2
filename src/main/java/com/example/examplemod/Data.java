package com.example.examplemod;

import com.example.examplemod.chat.Chat;
import net.minecraft.client.Minecraft;

public class Data {
    public static String MCPlayerName = ""; //Minecraft.getMinecraft().player.getDisplayNameString(); // Minecraft player name

    public static String PlayerNameCustom = ""; // Custom name that can be set by player


    // Get minecraft player name
    public static String getPlayerName() {
        return MCPlayerName;
    }


    // Set custom player name
    public static void setCustomPlayerName(String name) {
        PlayerNameCustom = name;
        Chat.SendMessage("Custom player name has been set to: " + PlayerNameCustom, "red");
    }

    // Get custom player name
    public static String getCustomPlayerName() {
        return PlayerNameCustom;
    }


}
