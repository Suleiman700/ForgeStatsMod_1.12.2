package com.example.examplemod.events;


//import com.example.examplemod.Gui.Gui;

import com.example.examplemod.Movements.JumpEvent;
import com.example.examplemod.chat.Chat;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnChatCommand {




    @SubscribeEvent
    public void clientChat(ClientChatReceivedEvent event) {
        ITextComponent message = event.getMessage();

        String playerMessage = null;
        playerMessage = message.getFormattedText();

        System.out.println(playerMessage);

        if (playerMessage != null) {
            if (playerMessage.contains("#help")) {
                System.out.println("Here");
//
//                Minecraft.getMinecraft().displayGuiScreen((GuiScreen) new Gui());
//                Gui.test();

                Chat.SendMessage(String.valueOf(BlockEvent.PlacedBlocks), "red");
                event.setCanceled(true);
            }
            // Show commands
            else if (playerMessage.contains("#cmds")) {


                Chat.ShowHelp();
                event.setCanceled(true);
            }
            // Stats commands
            else if (playerMessage.contains("#stats")) {
                if (playerMessage.contains("#stats_jumps")) {
                    JumpEvent.showCounter();
                }
                event.setCanceled(true);
            }
            // Placed blocks commands
            else if (playerMessage.contains("#placedblocks_")) {
                if (playerMessage.contains("#placedblocks_cmds")) {
                    Chat.ShowCmds_PlacedBlocks();
                }
                else if (playerMessage.contains("#placedblocks_count")) {
                    BlockEvent.ShowBlockPlacedCount();
                }
                else if (playerMessage.contains("#placedblocks_resetcount")) {
                    BlockEvent.ResetBlockPlacedCount();
                }
                event.setCanceled(true);
            }

            // Broken blocks commands
            else if (playerMessage.contains("#brokenblocks_")) {
                if (playerMessage.contains("#brokenblocks_cmds")) {
                    Chat.ShowCmds_BrokenBlocks();
                }
                else if (playerMessage.contains("#brokenblocks_count")) {
                    BlockEvent.ShowBlockBrokenCount();
                }
                else if (playerMessage.contains("#brokenblocks_resetcount")) {
                    BlockEvent.ResetBlockBrokenCount();
                }
                event.setCanceled(true);
            }

            else if (playerMessage.contains("#onattack_")) {
                if (playerMessage.contains("#onattack_cmds")) {
                    Chat.ShowCmds_OnAttackEntity();
                } else if (playerMessage.contains("#onattack_set true")) {
                    OnAttackEntity.toggleState(true);
                } else if (playerMessage.contains("#onattack_set false")) {
                    OnAttackEntity.toggleState(false);
                } else if (playerMessage.contains("#onattack_state")) {
                    OnAttackEntity.getState();
                }
                event.setCanceled(true);
            }

//            // Toggle onAttackEntity
//            else if (playerMessage.contains("#toggle_onattack")) {
//                if (playerMessage.contains("#toggle_onattack true")) {
//                    OnAttackEntity.ToggleEvent(true);
//                }
//                else if (playerMessage.contains("#toggle_onattack false")) {
//                    OnAttackEntity.ToggleEvent(false);
//                }
//                event.setCanceled(true);
//            }
        }
    }
}
