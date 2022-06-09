package com.example.examplemod.Players;

import com.example.examplemod.db.Database;

import java.util.HashMap;

public class PlayersCoords {
    public static boolean saveCoordsToDB = true; // Save players coordinates to DB

    static HashMap<String, String> coords = new HashMap<String, String>();

    // Add player coordinates to hashmap
    public static void add(String playerName, String playerCoordinates) {
        coords.put(playerName, playerCoordinates);
    }

    // Update player coordinates in hashmap
    public static void update(String playerName, String playerCoordinates) {

    }

    // Check if player coordinates found
    public static boolean coordsFound(String playerName) {
        boolean Found = coords.containsKey(playerName);
        return Found;
    }

    // Save all players coordinates
    public static void saveCoords(String playerName, String playerCoordinates) {
        boolean found = coordsFound(playerName);

        // Add player coordinates
        if (!found) add(playerName, playerCoordinates);

        // Update player coordinates
        else if (found) update(playerName, playerCoordinates);

        if (saveCoordsToDB) {
            Database.DeletePlayersCoords();
            coords.forEach((mapPlayerName, mapPlayerCoordinates) -> {
                Database.SavePlayersCoords(mapPlayerName, mapPlayerCoordinates);
            });
        }
    }
}
