package com.example.examplemod.Items;

import com.example.examplemod.chat.Chat;
import com.example.examplemod.db.Database;

public class Terracotta {
    private static String ItemName = "Terracotta";
    public static boolean ShowStats = true;
    public static boolean UpdateDB = false; // Update to database

    public static int Current = 0;
    private static int BackUp = 0;
    public static int Gathered = 0; // Total gathered Iron
    public static int Spent = 0; // Total Spent Iron

    // Set current count
    public static void set(int count) {
        Current = count;
    }

    // Reset all counter
    public static void resetCounters() {
        Current = 0;
        BackUp = 0;
        Gathered = 0;
        Spent = 0;
    }

    // Print stats
    public static void printStats() {
        String string = String.format("[%s] Current %s | Gathered: %s | Spent: %s", ItemName, BackUp, Gathered, Spent);
        System.out.println(string);
    }

    // Show stats
    public static String getStats() {
        String stats = "[Terracotta] Current: " + Current + " | Gathered: " + Gathered + " | Spent: " + Spent;
        return stats;
//        Chat.SendMessage("[Terracotta] Current: " + Current + " | Gathered: " + Gathered + " | Spent: " + Spent, "red");
//        System.out.println("[DIAMOND] Current: " + DiamondBackUp + " | Gathered: " + DiamondGathered + " | Spent: " + DiamondSpent);
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

//        if (ShowStats) printStats();
        if (UpdateDB) Database.UpdateTerracotta(BackUp, Gathered, Spent);
    }
}
