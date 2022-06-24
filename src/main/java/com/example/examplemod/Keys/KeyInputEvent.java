package com.example.examplemod.Keys;

import com.example.examplemod.FindInWorld.FindAndCount;
import com.example.examplemod.FindInWorld.FindPlayersInRegion;
import com.example.examplemod.Outliner.*;
import com.example.examplemod.Render.Gui;
import com.example.examplemod.Movements.BlockEdgeEvent;
import com.example.examplemod.chat.Chat;
import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import static clojure.lang.RT.box;

public class KeyInputEvent {

//    public static boolean Sneak = false;

//    @SubscribeEvent
//    public void RenderBlockOverlay(RenderBlockOverlayEvent event) {
//        Chat.SendMessage("here", "green");
//    }


//    @SubscribeEvent
//    public void render(RenderWorldLastEvent event){
////        DoMyRendering(event.getPartialTicks());
////        Chat.SendMessage(String.valueOf(event.getListenerList().), "green");
////        RenderGlobal name = event.getContext();
////        GL11.glDisable(GL11.GL_TEXTURE_2D);
////        GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.4F);
//    }


    public void DoMyRendering(float partialTickTime)
    {
        EntityPlayerSP player = Minecraft.getMinecraft().player;
        double x = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTickTime;
        double y = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTickTime;
        double z = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTickTime;

        GL11.glPushMatrix();
        GL11.glTranslated(-x, -y, -z); //go from cartesian x,y,z coordinates to in-world x,y,z coordinates
        GL11.glEnable(GL11.GL_DEPTH_TEST);

        double minX = 0 + 0.02;
        double maxX = 1 - 0.02;
        double maxY = 10 + 0.02;
        double minZ = 0 + 0.02;
        double maxZ = 1 - 0.02;

        //render an "X" using 2 lines at (0, 10, 0) in game
        GL11.glBegin(GL11.GL_LINES); //begin drawing lines defined by 2 vertices

        GL11.glColor4f(1f, 1f, 1f, 0.5f); //alpha must be > 0.1
        GL11.glVertex3d(maxX, maxY, maxZ);
        GL11.glVertex3d(minX, maxY, minZ);
        GL11.glVertex3d(maxX, maxY, minZ);
        GL11.glVertex3d(minX, maxY, maxZ);

        GL11.glEnd();

        //cleanup
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }

    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event) {
//        Chat.SendMessage(String.valueOf(Keyboard.getEventKey()), "green");


        // Toggle scaffold
        if (Keyboard.isKeyDown(Keyboard.KEY_F8)) {
            BlockEdgeEvent.toggle();
        }

        // Show GUI
        else if (Keyboard.isKeyDown(Keyboard.KEY_F12)) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen) new Gui());
        }

        // Find dragon egg and count obsidian
        else if (Keyboard.isKeyDown(Keyboard.KEY_F9)) {
            FindAndCount.FindAndCountObsidianAroundEgg();
            FindPlayersInRegion.find();

//            Minecraft.getMinecraft().fontRenderer.drawString("works", 50, 50, 0xfff, false);
        }

        // ESP
        else if (Keyboard.isKeyDown(Keyboard.KEY_F10)) {
            Controller_Outliner.toggleState();
//            Players_Outliner.toggleState();
//            Items_Outliner.toggleState();
//            Arrows_Outliner.toggleState();
//            Blocks_Outliner.toggleState();
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
