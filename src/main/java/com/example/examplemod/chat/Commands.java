package com.example.examplemod.chat;

import com.example.examplemod.Data;
import com.example.examplemod.Health.Death;
import com.example.examplemod.Players.PlayersHealth;
import com.example.examplemod.Items.Diamond;
import com.example.examplemod.Items.Gold;
import com.example.examplemod.Items.Iron;
import com.example.examplemod.Items.Terracotta;
import com.example.examplemod.Movements.SneakEvent;
import com.example.examplemod.db.Database;
import com.example.examplemod.Movements.JumpEvent;
import com.example.examplemod.events.PlayerTick;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Commands {

    @SubscribeEvent
    public void clientChat(ClientChatReceivedEvent event) {
        ITextComponent message = event.getMessage();

        String playerMessage = null;
        playerMessage = message.getFormattedText();

        if (playerMessage != null) {
            System.out.println(playerMessage);
            if (playerMessage.contains("#stats_diamond_")) {
                if (playerMessage.contains("#stats_diamond_help")) {
                    Diamond.ShowCommands();
                } else if (playerMessage.contains("#stats_diamond_get_stats")) {
                    Diamond.getStats();
                }

                else if (playerMessage.contains("#stats_diamond_get_gathered")) {
                    Diamond.getGathered();
                } else if (playerMessage.contains("#stats_diamond_reset_gathered")) {
                    Diamond.resetGathered();
                }

                else if (playerMessage.contains("#stats_diamond_get_spent")) {
                    Diamond.getSpent();
                } else if (playerMessage.contains("#stats_diamond_reset_spent")) {
                    Diamond.resetSpent();
                }

                else if (playerMessage.contains("#stats_diamond_reset_db")) {
                    Database.ResetDiamond();
                }
                event.setCanceled(true);
            }

            if (playerMessage.contains("#stats_items_")) {
                if (playerMessage.contains("#stats_items_iron")) {
                    Iron.getStats();
                }
                event.setCanceled(true);
            }

            // Set player name
            else if (playerMessage.contains("#set_name")) {
                playerMessage = playerMessage.substring(playerMessage.indexOf("<") + 1);
                playerMessage = playerMessage.substring(0, playerMessage.indexOf(">"));
                Chat.SendMessage("Your name was set to: " + playerMessage, "red");
                Data.setCustomPlayerName(playerMessage);
//                PlayerTick.setPlayerName(playerMessage);
                event.setCanceled(true);
            }

            // Show all stats
            else if (playerMessage.contains("#all_stats")) {
                Chat.SendMessage("", "red");
                Diamond.getStats();
                Gold.getStats();
                Iron.getStats();
                Terracotta.getStats();
                JumpEvent.showCounter();
                Chat.SendMessage("", "red");
                event.setCanceled(true);
            }

            // Set new game
            else if (playerMessage.contains("#new_game")) {
                Diamond.resetCounters();
                Gold.resetCounters();
                Iron.resetCounters();
                Terracotta.resetCounters();
                JumpEvent.resetCounter();
                PlayersHealth.clearHealths();
                SneakEvent.resetCount();
                Death.resetCount();
                Chat.SendMessage("Done resetting all counters and setting a new game", "red");
                event.setCanceled(true);
            }

            // Get players healths
            else if (playerMessage.contains("#get_healths")) {
                PlayersHealth.showHealths();
                event.setCanceled(true);
            }
        }
    }
}
