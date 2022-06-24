package com.example.examplemod.Render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TextOnScreen {
    public static int obsidianAroundEgg = 0;
    public static int playersInRegion = 0;

    public static void setObsidianString(int obsidian_count) {
        obsidianAroundEgg = obsidian_count;
    }

    public static void setPlayersInRegion(int players_count) {
        playersInRegion = players_count;
    }

//    @SideOnly(Side.CLIENT)
//    @SubscribeEvent
//    public void render(RenderGameOverlayEvent event) {
//        Minecraft.getMinecraft().fontRenderer.drawString("Obsidian " + obsidianAroundEgg, 10, 200, 0xFFFFFFFF, false);
//        Minecraft.getMinecraft().fontRenderer.drawString("Players " + playersInRegion, 10, 215, 0xFFFFFFFF, false);
//
////        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
////            Minecraft.getMinecraft().fontRenderer.drawString("works", 2, 2, 0xFFFFFFFF, false);
////        }
//    }
}
