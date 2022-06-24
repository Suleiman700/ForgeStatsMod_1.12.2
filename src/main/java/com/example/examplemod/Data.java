package com.example.examplemod;

import com.example.examplemod.chat.Chat;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;

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

    // Get self player looking direction
    public static String getSelfPlayerLookingDirection() {
        int LookingDirection2 = MathHelper.floor((double) ((Minecraft.getMinecraft().player.rotationYaw * 8F) / 360F) + 0.5D) & 7;
        Data.setLookingDirection(LookingDirection2);
        String LookingDirection = Data.getLookingDirection();
        return LookingDirection;
    }

    // Set looking direction
    public static void setLookingDirection(int direction) {
        if (direction == 0) LookingDirection = "SOUTH";
        else if (direction == 1) LookingDirection = "SOUTH_WEST";
        else if (direction == 2) LookingDirection = "WEST";
        else if (direction == 3) LookingDirection = "WEST_NORTH";
        else if (direction == 4) LookingDirection = "NORTH";
        else if (direction == 5) LookingDirection = "NORTH_EAST";
        else if (direction == 6) LookingDirection = "EAST";
        else if (direction == 7) LookingDirection = "EAST_SOUTH";
    }
    // Get looking direction
    public static String getLookingDirection() {
        return LookingDirection;
    }

    public static List getBuildingBlocks() {
        return BuildingBlocks;
    }
}
