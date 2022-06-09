//package com.example.examplemod.Gui;
//
//import com.example.examplemod.ExampleMod;
//import com.example.examplemod.events.BlockEvent;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.FontRenderer;
//import net.minecraft.client.gui.GuiButton;
//import net.minecraft.client.gui.GuiScreen;
//import net.minecraft.util.ResourceLocation;
//
//import java.io.IOException;
//
//public class Gui extends GuiScreen {
//
//    final ResourceLocation texture = new ResourceLocation(ExampleMod.MODID, "textures/gui/book.png");
//    int guiWidth = 203;
//    int guiHeight = 142;
//
//
//    @Override
//    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
//        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
//
//        int centerX = (width / 2) - guiWidth / 2;
//        int centerY = (height / 2) - guiHeight / 2;
//
//        drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
//        String PlacedBlocks = "Placed blocks: " + String.valueOf(BlockEvent.PlacedBlocks);
//        drawString(Minecraft.getMinecraft().fontRenderer, PlacedBlocks, centerX, centerY, 0xffffff);
//
////        FontRenderer fontRendererObj = Minecraft.getMinecraft().fontRenderer;
////        drawString(fontRendererObj, "Tutorial", centerX, centerY, 0x6028ff);
//
//        super.drawScreen(mouseX, mouseY, partialTicks);
//    }
//
//    @Override
//    public void initGui() {
//        super.initGui();
//    }
//
//    @Override
//    protected void actionPerformed(GuiButton button) throws IOException {
//        super.actionPerformed(button);
//    }
//
//    @Override
//    protected void keyTyped(char typedChar, int keyCode) throws IOException {
//        super.keyTyped(typedChar, keyCode);
//    }
//
//    @Override
//    public boolean doesGuiPauseGame() {
//        return false;
//    }
//}
