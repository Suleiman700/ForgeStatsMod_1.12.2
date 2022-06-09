package com.example.examplemod.Items;

import com.example.examplemod.chat.Chat;
import com.example.examplemod.db.Database;

public class Dirt {
    public static boolean ShowStats = true;
    public static boolean UpdateDB = true; // Update to database

    public static int DirtCurrent = 0;
    private static int DirtBackUp = 0;

    public static int DirtGathered = 0; // Total gathered Dirt
    public static int DirtSpent = 0; // Total spent Dirt

    // Set current Dirt
    public static void setDirt(int Dirt) {
        DirtCurrent = Dirt;
    }

    // Get backup Dirt
    public int getBackup() {
        return DirtBackUp;
    }



    // Show stats
    public static void getStats() {
        Chat.SendMessage("[Dirt] Current: " + DirtBackUp + " | Gathered: " + DirtGathered + " | Spent: " + DirtSpent, "red");
        System.out.println("[Dirt] Current: " + DirtBackUp + " | Gathered: " + DirtGathered + " | Spent: " + DirtSpent);
    }

    // Get gathered Dirt
    public static int getGathered() {
        Chat.SendMessage("[Dirt] Gathered: " + DirtSpent, "red");
        return DirtGathered;
    }

    // Reset gathered counter
    public static void resetGathered() {
        DirtGathered = 0;
        Chat.SendMessage("[Dirt] Set gathered counter to: 0", "red");
    }

    // Get spent Dirt
    public static int getSpent() {
        Chat.SendMessage("[Dirt] Spent: " + DirtSpent, "red");
        return DirtSpent;
    }

    // Reset spent counter
    public static void resetSpent() {
        DirtSpent = 0;
        Chat.SendMessage("[Dirt] Set spent counter to: 0", "red");
    }

    // Check Dirt after update
    public static void checkQty() {
        if (DirtCurrent > DirtBackUp) {
            DirtGathered += DirtCurrent - DirtBackUp; // Store in gathered
            DirtBackUp = DirtCurrent; // Set backup as current amount
        }
        else if (DirtCurrent < DirtBackUp) {
            DirtSpent += DirtBackUp - DirtCurrent; // Store in spent
            DirtBackUp = DirtCurrent; // Set backup as current amount
        }

//        if (ShowStats) getStats();
        if (UpdateDB) Database.UpdateDirt(DirtBackUp, DirtGathered, DirtSpent);
    }
}