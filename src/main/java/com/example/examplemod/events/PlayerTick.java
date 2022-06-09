package com.example.examplemod.events;

import com.example.examplemod.Data;
import com.example.examplemod.Health.Health;
import com.example.examplemod.Inventory.InventoryCheck;
import com.example.examplemod.Players.PlayersCoords;
import com.example.examplemod.Players.PlayersHealth;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerTick {
    private int tickCounter = 0;
    private int tickCounter2 = 0;
//    public static String PlayerName = ""; // Toy_HuNi
    public static boolean CheckOtherPlayersHealth = true; // Check and store other players health
    public static boolean CheckOtherPlayersCoords = true; // Check and store other players coordinates


    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent event) {

        String MCPlayerName = Data.getCustomPlayerName();

        // Save global players health
        if (CheckOtherPlayersHealth) {
            EntityPlayer globalPlayer = event.player;
            String globalPlayerName = globalPlayer.getDisplayNameString();
            float globalPlayerHealth = globalPlayer.getHealth();

            boolean found = PlayersHealth.healthFound(globalPlayerName);
            // Add player health
            if (!found) PlayersHealth.addHealth(globalPlayerName, globalPlayerHealth);
            // Update player health
            else if (found) PlayersHealth.updateHealth(globalPlayerName, globalPlayerHealth);
        }

        // Save global players coordinates
        if (CheckOtherPlayersCoords) {
            EntityPlayer globalPlayer = event.player;
            String globalPlayerName = globalPlayer.getDisplayNameString();

            double posX = globalPlayer.posX;
            double posY = globalPlayer.posY;
            double posZ = globalPlayer.posZ;
            PlayersCoords.saveCoords(globalPlayerName, posX+","+posY+","+posZ);
        }


        if (MCPlayerName == "") {
            // Chat.SendMessage("Please set your player name using: #set_name <player_name>", "red");
        }
        else {

            String eventPlayerName = event.player.getName();

            if (eventPlayerName.contains(MCPlayerName) || MCPlayerName.contains(eventPlayerName)) {

                if (tickCounter % 100 == 0 && tickCounter < 500) {
                    EntityPlayer player = event.player;

                    // Check player inventory
                    InventoryCheck.checkInventory(player);

                    // Check player health
                    float playerHealth = player.getHealth();
                    Health.checkHealth(player, playerHealth);

                    // Check sneaking
//                    boolean sneakState = player.isSneaking();
//                    Sneak.storeSneaking(sneakState);
                }

                else if (tickCounter > 500) tickCounter = 0;
                tickCounter++;
            }
        }
    }
}
