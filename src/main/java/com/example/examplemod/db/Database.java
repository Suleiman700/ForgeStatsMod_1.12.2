package com.example.examplemod.db;

import com.example.examplemod.Functions.Time;
import com.example.examplemod.chat.Chat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private static String DB_Name = "forgestatsmod";
    private static String DB_Username = "root";
    private static String DB_Password = "";
    private static String BASE_URL = "C:\\ForgeStatsMod\\";

    // Create DB directory if not found
    private static void checkDBDirectory() {
        File directory = new File(BASE_URL);
        if (! directory.exists()){
            directory.mkdir();
        }
    }

    // Reset diamond stats
    public static void ResetDiamond() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_Name, DB_Username, DB_Password);
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate("UPDATE `diamond` SET `Total` = '0', `Gathered` = '0', `Spent` = '0' WHERE `diamond`.`id` = 0;");
            Chat.SendMessage("[DB] Diamond stats has been rested", "red");
//            System.out.println(rs);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void UpdateDiamond(int current, int gathered, int spent) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "Diamond.txt");
            myWriter.write("TOTAL:" + current + ",GATHERED:" + gathered + ",SPENT:" + spent);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_Name, DB_Username, DB_Password);
//            Statement stmt = con.createStatement();
//            int rs = stmt.executeUpdate("UPDATE `diamond` SET `Total` = '" + current + "', `Gathered` = '" + gathered + "', `Spent` = '" + spent + "' WHERE `id` = 0;");
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    public static void UpdateGold(int current, int gathered, int spent) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "Gold.txt");
            myWriter.write("TOTAL:" + current + ",GATHERED:" + gathered + ",SPENT:" + spent);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_Name, DB_Username, DB_Password);
//            Statement stmt = con.createStatement();
//            int rs = stmt.executeUpdate("UPDATE `diamond` SET `Total` = '" + current + "', `Gathered` = '" + gathered + "', `Spent` = '" + spent + "' WHERE `id` = 0;");
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    public static void UpdateIron(int current, int gathered, int spent) {
        checkDBDirectory();
        System.out.println("TOTAL:" + current + ",GATHERED:" + gathered + ",SPENT:" + spent);
        try {
            FileWriter myWriter = new FileWriter(BASE_URL + "Iron.txt");
            myWriter.write("TOTAL:" + current + ",GATHERED:" + gathered + ",SPENT:" + spent);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void UpdateDirt(int current, int gathered, int spent) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "Dirt.txt");
            myWriter.write("TOTAL:" + current + ",GATHERED:" + gathered + ",SPENT:" + spent);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void UpdateTerracotta(int current, int gathered, int spent) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "Terracotta.txt");
            myWriter.write("TOTAL:" + current + ",GATHERED:" + gathered + ",SPENT:" + spent);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void UpdateJump(int total) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "Jump.txt");
            myWriter.write("TOTAL:" + total);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void UpdateHealth(float health) {
        checkDBDirectory();

        // Save current
        try {
            FileWriter myWriter = new FileWriter(BASE_URL + "Health.txt");
            myWriter.write("HEALTH:"+health);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Save log
        try {
            String dateTime = Time.getDateTime();
            FileWriter myWriter = new FileWriter(BASE_URL + "Health_LOG.txt", true);
            myWriter.write(dateTime + ":" + health + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Save players health
    public static void UpdatePlayersHealth(String playerName, float playerHealth) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "PlayersHealth.txt", true);
            myWriter.write(playerName + ":" + playerHealth + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Delete players health
    public static void DeletePlayersHealth() {
        try {
            Path fileToDeletePath = Paths.get(BASE_URL + "PlayersHealth.txt");
            Files.delete(fileToDeletePath);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Save sneak
    public static void UpdateSneak(int count) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "Sneak.txt");
            myWriter.write("TOTAL:" + count);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Save sneak live state
    public static void SaveSneakLiveState(boolean state) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "SneakLiveState.txt");
            myWriter.write("SNEAKING:" + state);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Save sneak live state
    public static void SaveDeath(int count) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "Death.txt");
            myWriter.write("TOTAL:" + count);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Save players coordinates
    public static void SavePlayersCoords(String playerName, String playerCoordinates) {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "PlayersCoords.txt", true);
            myWriter.write(playerName + ":" + playerCoordinates + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Save players coordinates
    public static void DeletePlayersCoords() {
        try {
            checkDBDirectory();
            FileWriter myWriter = new FileWriter(BASE_URL + "PlayersCoords.txt");
            myWriter.write("");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
