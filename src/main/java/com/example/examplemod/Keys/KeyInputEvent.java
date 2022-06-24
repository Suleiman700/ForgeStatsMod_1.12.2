package com.example.examplemod.Keys;

import com.example.examplemod.Data;
import com.example.examplemod.Outliner.*;
import com.example.examplemod.Render.Gui;
import com.example.examplemod.Movements.BlockEdgeEvent;
import com.example.examplemod.chat.Chat;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import static clojure.lang.RT.box;

public class KeyInputEvent {

//    public static boolean Sneak = false;

    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event) {
//        Chat.SendMessage(String.valueOf(Keyboard.getEventKey()), "green");


        // Toggle scaffold
        if (Keyboard.isKeyDown(Keyboard.KEY_TAB)) {
            BlockEdgeEvent.toggle();
        }

        // Show GUI
        else if (Keyboard.isKeyDown(Keyboard.KEY_F12)) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen) new Gui());
        }

        // ESP
        else if (Keyboard.isKeyDown(Keyboard.KEY_F10)) {
            Controller_Outliner.toggleState();
//            Players_Outliner.toggleState();
//            Items_Outliner.toggleState();
//            Arrows_Outliner.toggleState();
//            Blocks_Outliner.toggleState();

            BlockPos posStart = Minecraft.getMinecraft().player.getPosition();
            Block block = Minecraft.getMinecraft().world.getBlockState(posStart.north(2)).getBlock();
            String blockName = block.getLocalizedName();

            // Get player looking direction
            String LookingDirection = Data.getSelfPlayerLookingDirection();
            Chat.SendMessage(LookingDirection, "green");
            int checkBlocks_PosX_Start = 0;
            int checkBlocks_PosX_End = 0;
            int checkBlocks_PosY_Start = 0;
            int checkBlocks_PosY_End = 0;
            int checkBlocks_PosZ_Start = 0;
            int checkBlocks_PosZ_End = 0;

            // Set the field to scan blocks in
            if (LookingDirection.equals("EAST")) {
                checkBlocks_PosX_Start = 0;
                checkBlocks_PosX_End = 200;

                checkBlocks_PosY_Start = 50;
                checkBlocks_PosY_End = 50;

                checkBlocks_PosZ_Start = 20;
                checkBlocks_PosZ_End = 20;
            }
            else if (LookingDirection.equals("NORTH_EAST")) {
                checkBlocks_PosX_Start = 0;
                checkBlocks_PosX_End = 200;

                checkBlocks_PosY_Start = 50;
                checkBlocks_PosY_End = 50;

                checkBlocks_PosZ_Start = 50;
                checkBlocks_PosZ_End = 50;
            }
            else if (LookingDirection.equals("EAST_SOUTH")) {
                checkBlocks_PosX_Start = 0;
                checkBlocks_PosX_End = 200;

                checkBlocks_PosY_Start = 50;
                checkBlocks_PosY_End = 50;

                checkBlocks_PosZ_Start = 0;
                checkBlocks_PosZ_End = 70;
            }
            else if (LookingDirection.equals("SOUTH_WEST")) {
                checkBlocks_PosX_Start = 200;
                checkBlocks_PosX_End = 0;

                checkBlocks_PosY_Start = 50;
                checkBlocks_PosY_End = 50;

                checkBlocks_PosZ_Start = 20;
                checkBlocks_PosZ_End = 20;
            }
            else if (LookingDirection.equals("WEST")) {
                checkBlocks_PosX_Start = 200;
                checkBlocks_PosX_End = 0;

                checkBlocks_PosY_Start = 50;
                checkBlocks_PosY_End = 50;

                checkBlocks_PosZ_Start = 20;
                checkBlocks_PosZ_End = 20;
            }
            else if (LookingDirection.equals("WEST_NORTH")) {
                checkBlocks_PosX_Start = 200;
                checkBlocks_PosX_End = 0;

                checkBlocks_PosY_Start = 50;
                checkBlocks_PosY_End = 50;

                checkBlocks_PosZ_Start = 50;
                checkBlocks_PosZ_End = 50;
            }


            BlockPos pos1 = new BlockPos(posStart.getX()-checkBlocks_PosX_Start, posStart.getY()-checkBlocks_PosY_Start, posStart.getZ()-checkBlocks_PosZ_Start);
            BlockPos pos2 = new BlockPos(posStart.getX()+checkBlocks_PosX_End, posStart.getY()+checkBlocks_PosY_End, posStart.getZ()+checkBlocks_PosZ_End);

            // Find blocks around player
            for (BlockPos blockPosAroundPlayer : BlockPos.getAllInBox(pos1, pos2)) {
                int count_obsidian = 0;
                Block blockAroundPlayer = Minecraft.getMinecraft().world.getBlockState(blockPosAroundPlayer).getBlock();
                String blockNameAroundPlayer = blockAroundPlayer.getLocalizedName();

//                Chat.SendMessage(blockNameAroundPlayer, "green");

                if (blockAroundPlayer.getUnlocalizedName().contains("Red")) {
                    Chat.SendMessage("here", "red");
                }


                if (blockNameAroundPlayer.equals("Dragon Egg")) {
                    Chat.SendMessage("Found Dragon Egg", "red");

                    // Get dragon egg position
                    float dragonEggPos_X = blockPosAroundPlayer.getX();
                    float dragonEggPos_Y = blockPosAroundPlayer.getY();
                    float dragonEggPos_Z = blockPosAroundPlayer.getZ();

                    // Find block around dragon egg
                    BlockPos pos3 = new BlockPos(dragonEggPos_X-10, dragonEggPos_Y-2, dragonEggPos_Z-10);
                    BlockPos pos4 = new BlockPos(dragonEggPos_X+10, dragonEggPos_Y+2, dragonEggPos_Z+10);
                    for (BlockPos blockPosAroundEgg : BlockPos.getAllInBox(pos3, pos4)) {
                        Block blockAroundEgg = Minecraft.getMinecraft().world.getBlockState(blockPosAroundEgg).getBlock();
                        String blockNameAroundEgg = blockAroundEgg.getLocalizedName();

                        if (blockNameAroundEgg.equals("Obsidian")) {
                            count_obsidian++;
                        }
                    }

                    Chat.SendMessage("Found " + count_obsidian + " blocks of obsidian around the egg", "green");

                    // Get block at pos
//                    BlockPos pos = new BlockPos(-213, 73, 341);
//                    IBlockState ibs = Minecraft.getMinecraft().world.getBlockState(pos);
//                    Block block = ibs.getBlock();
//                    Chat.SendMessage(block.getLocalizedName(), "green");

//                    String test = blockAroundPlayer.getBlockState().get

//                    BlockPos pos = new BlockPos(blockAroundPlayer.getBlockState(pos));
//
//                    Chat.SendMessage(String.valueOf(p1), "red");
                }


            }
        }
    }

    @SubscribeEvent
    public void onInputUpdate(InputUpdateEvent event) {
        boolean NeedSneaking = BlockEdgeEvent.getSneak();
        boolean ScaffoldEnabled = BlockEdgeEvent.getEnabled();
        if (!ScaffoldEnabled) return;
        if (NeedSneaking) {
            event.getMovementInput().sneak = true;
        }
        else if (!NeedSneaking) {
            event.getMovementInput().sneak = false;
        }
    }
}
