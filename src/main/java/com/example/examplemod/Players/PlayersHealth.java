package com.example.examplemod.Players;

import com.example.examplemod.chat.Chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayersHealth {
    static HashMap<String, Float> healths = new HashMap<String, Float>();

    // Add player health to hashmap
    public static void addHealth(String playerName, float playerHealth) {
        healths.put(playerName, playerHealth);
    }

    // Update player health
    public static void updateHealth(String playerName, float playerHealth) {
        List keys = new ArrayList(healths.keySet());
        healths.replace(playerName, playerHealth);
    }

    // Check if player health found
    public static boolean healthFound(String playerName) {
        boolean Found = healths.containsKey(playerName);
        return Found;
    }

    // Get player health
    public static float getHealth(String playerName) {
        return healths.get(playerName);
    }

    // Delete all healths from hashmap
    public static void clearHealths() {
        healths.clear();
    }

    // Show players healths
    public static void showHealths() {
        healths.forEach((playerName, playerHealth) -> {
            Chat.SendMessage(">>> PLAYERS HEALTHS <<<", "green");
            Chat.SendMessage(playerName + ":" + playerHealth, "green");
            Chat.SendMessage("", "green");
        });
    }

}
