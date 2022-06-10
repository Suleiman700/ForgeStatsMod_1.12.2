package com.example.examplemod;

import com.example.examplemod.chat.Chat;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static String MCPlayerName = ""; //Minecraft.getMinecraft().player.getDisplayNameString(); // Minecraft player name
    public static String PlayerNameCustom = ""; // Custom name that can be set by player
    public static String LookingDirection = ""; // Direction that player is looking at
    public static final List<String> BuildingBlocks = Arrays.asList("clay", "tile.clay"); // Blocks that considered as building blocks

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

    // Set looking direction
    public static void setLookingDirection(int direction) {
        if (direction == 0) LookingDirection = "SOUTH";
        else if (direction == 1) LookingDirection = "WEST";
        else if (direction == 2) LookingDirection = "NORTH";
        else if (direction == 3) LookingDirection = "EAST";
    }
    // Get looking direction
    public static String getLookingDirection() {
        return LookingDirection;
    }

    public static List getBuildingBlocks() {
        return BuildingBlocks;
    }
}
