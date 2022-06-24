package com.example.examplemod.Render;

import com.example.examplemod.FindInWorld.FindAndCount;
import com.example.examplemod.FindInWorld.FindPlayersInRegion;
import com.example.examplemod.Items.Diamond;
import com.example.examplemod.Items.Gold;
import com.example.examplemod.Items.Iron;
import com.example.examplemod.Items.Terracotta;
import com.example.examplemod.Movements.BlockEdgeEvent;
import com.example.examplemod.Outliner.Arrows_Outliner;
import com.example.examplemod.Outliner.Items_Outliner;
import com.example.examplemod.Outliner.Players_Outliner;
import com.example.examplemod.Players.PlayerProjectileDamage;
import com.example.examplemod.Sound.Sound;
import com.example.examplemod.events.OnAttackEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiSlider;

import java.io.IOException;
import java.text.DecimalFormat;

public class Gui extends GuiScreen {

//    final ResourceLocation texture = new ResourceLocation(ExampleMod.class.getResource("/assets/textures/gui/book.png").toString());

    final ResourceLocation texture = new ResourceLocation("textures/gui/book.png");
    int guiWidth = 303;
    int guiHeight = 142;

    // Toggle scaffold button
    GuiButton toggle_scaffold;
    final int TOGGLE_SCAFFOLD = 0;

    // Toggle announce target health
    GuiButton toggle_announce_target_health;
    final int TOGGLE_ANNOUNCE_TARGET_HEALTH = 1;

    // Announce target health slider
    GuiSlider announce_target_health_volume;
    final int ANNOUNCE_TARGET_HEALTH_VOLUME = 2;

    // Reset items stats
    GuiButton reset_items_stats;
    final int RESET_ITEMS_STATS = 3;

    // Players glow effect
    GuiButton players_glow_effect;
    final int PLAYERS_GLOW_EFFECT = 4;

    GuiButton items_glow_effect;
    final int ITEMS_GLOW_EFFECT = 5;

    GuiButton arrows_glow_effect;
    final int ARROWS_GLOW_EFFECT = 6;

    GuiButton arrow_hit_target_info;
    final int ARROW_HIT_TARGET_INFO = 7;

    GuiButton find_obsidian_around_egg;
    final int FIND_OBSIDIAN_AROUND_EGG = 8;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;

        drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
//        String Scaffold = "Scaffold Enabled: " + BlockEdgeEvent.getEnabled();
//        drawString(Minecraft.getMinecraft().fontRenderer, Scaffold, centerX, centerY, 0xffffff);

//        String AnnouncePlayerHealth = "Announce Target Health: " + OnAttackEntity.getSpeakHealthNumberState();
//        drawString(Minecraft.getMinecraft().fontRenderer, AnnouncePlayerHealth, centerX, centerY+10, 0xffffff);

        drawDefaultBackground();

        drawString(Minecraft.getMinecraft().fontRenderer, Diamond.getStats(), centerX+5, centerY+5, 0xffffff);
        drawString(Minecraft.getMinecraft().fontRenderer, Gold.getStats(), centerX+5, centerY+20, 0xffffff);
        drawString(Minecraft.getMinecraft().fontRenderer, Iron.getStats(), centerX+5, centerY+35, 0xffffff);
        drawString(Minecraft.getMinecraft().fontRenderer, Terracotta.getStats(), centerX+5, centerY+50, 0xffffff);

//        Minecraft.getMinecraft().setRenderViewEntity.setPositionAndRotation(player.posX + x, player.posY - 1.63 + y, player.posZ + z, player.rotationYaw, player.rotationPitch);


//        GlStateManager.viewport(50, 50, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
//        GlStateManager.matrixMode(GL11.GL_PROJECTION);
//        FloatBuffer projection = GLAllocation.createDirectFloatBuffer(16);
//        GlStateManager.getFloat(GL11.GL_PROJECTION_MATRIX, projection);
//        GL11.glLoadMatrix(projection);
//        GlStateManager.matrixMode(GL11.GL_MODELVIEW);



//        FontRenderer fontRendererObj = Minecraft.getMinecraft().fontRenderer;
//        drawString(fontRendererObj, "Tutorial", centerX, centerY, 0x6028ff);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        buttonList.clear();
        buttonList.add(reset_items_stats = new GuiButton(RESET_ITEMS_STATS, 5, 5, 100, 20, "Reset Stats"));
        buttonList.add(toggle_scaffold = new GuiButton(TOGGLE_SCAFFOLD, 5, 30, 100, 20, "Scaffold: " + BlockEdgeEvent.getEnabled()));
        buttonList.add(toggle_announce_target_health = new GuiButton(TOGGLE_ANNOUNCE_TARGET_HEALTH, 5, 55, 200, 20, "Announce Target Health: " + OnAttackEntity.getSpeakHealthNumberState()));
        buttonList.add(announce_target_health_volume = new GuiSlider(ANNOUNCE_TARGET_HEALTH_VOLUME, 206, 55, 200, 20, "Volume ", "", 0, 1, Sound.getVolume(), true, true));

        buttonList.add(players_glow_effect = new GuiButton(PLAYERS_GLOW_EFFECT, 5, 80, 150, 20, "Players ESP: " + Players_Outliner.getState()));
        buttonList.add(items_glow_effect = new GuiButton(ITEMS_GLOW_EFFECT, 5, 105, 150, 20, "Items ESP: " + Items_Outliner.getState()));
        buttonList.add(arrows_glow_effect = new GuiButton(ARROWS_GLOW_EFFECT, 5, 130, 150, 20, "Arrows ESP: " + Arrows_Outliner.getState()));
        buttonList.add(arrow_hit_target_info = new GuiButton(ARROW_HIT_TARGET_INFO, 5, 155, 200, 20, "Arrows Hit Info: " + PlayerProjectileDamage.getState()));

        buttonList.add(find_obsidian_around_egg = new GuiButton(FIND_OBSIDIAN_AROUND_EGG, 5, 180, 200, 20, "Count Obsidian Around Egg"));
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case RESET_ITEMS_STATS:
                Diamond.resetCounters();
                Gold.resetCounters();
                Iron.resetCounters();
                Terracotta.resetCounters();
                break;
            case TOGGLE_SCAFFOLD:
                BlockEdgeEvent.toggle();
                toggle_scaffold.displayString = "Scaffold: " + BlockEdgeEvent.getEnabled();
                break;
            case TOGGLE_ANNOUNCE_TARGET_HEALTH:
                OnAttackEntity.toggleAnnouncePlayerHealthState();
                toggle_announce_target_health.displayString = "Announce Target Health: " + OnAttackEntity.getSpeakHealthNumberState();
                break;
            case ANNOUNCE_TARGET_HEALTH_VOLUME:
                double value = announce_target_health_volume.getValue();
                DecimalFormat df = new DecimalFormat("0.00");
                double volume = Double.parseDouble(df.format(value));
                Sound.setVolume(volume);
                break;
            case PLAYERS_GLOW_EFFECT:
                Players_Outliner.toggleState();
                players_glow_effect.displayString = "Players ESP: " + Players_Outliner.getState();
                break;
            case ITEMS_GLOW_EFFECT:
                Items_Outliner.toggleState();
                items_glow_effect.displayString = "Items ESP: " + Items_Outliner.getState();
                break;
            case ARROWS_GLOW_EFFECT:
                Arrows_Outliner.toggleState();
                arrows_glow_effect.displayString = "Arrows ESP: " + Arrows_Outliner.getState();
                break;
            case ARROW_HIT_TARGET_INFO:
                PlayerProjectileDamage.toggleState();
                arrow_hit_target_info.displayString = "Arrows Hit Info: " + PlayerProjectileDamage.getState();
                break;
            case FIND_OBSIDIAN_AROUND_EGG:
                FindAndCount.FindAndCountObsidianAroundEgg();
                FindPlayersInRegion.find();
                break;
        }
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
