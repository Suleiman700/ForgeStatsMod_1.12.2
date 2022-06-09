package com.example.examplemod.chat;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;

public class Chat {
    public static void SendMessage(String message, String color) {
        EntityPlayer player = Minecraft.getMinecraft().player;

        switch (color) {
            case "purple":
                player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
                break;
            case "red":
                player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.RED)));
                break;
            default:
                player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.WHITE)));
        }
    }

    public static void ShowHelp() {
        EntityPlayer player = Minecraft.getMinecraft().player;
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("===[ Available Commands] ===").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("#cmds => Show commands").setStyle(new Style().setColor(TextFormatting.RED)));
        player.sendMessage(new TextComponentString("#onattack_cmds => OnEntityAttack commands").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#onattack_cmds"))));
        player.sendMessage(new TextComponentString("#placedblocks_cmds => PlacedBlocks commands").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#placedblocks_cmds"))));
        player.sendMessage(new TextComponentString("#brokenblocks_cmds => BrokenBlocks commands").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#brokenblocks_cmds"))));
        player.sendMessage(new TextComponentString("=====================").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));

    }

    public static void ShowCmds_OnAttackEntity() {
        EntityPlayer player = Minecraft.getMinecraft().player;
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("===[ OnAttackEntity Commands] ===").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("#onattack_state => Check if enable/disabled").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#onattack_state"))));
        player.sendMessage(new TextComponentString("#onattack_set true => Enable").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#onattack_set true"))));
        player.sendMessage(new TextComponentString("#onattack_set false => Disable").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#onattack_set false"))));
        player.sendMessage(new TextComponentString("=====================").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
    }


    // Show placed blocks commands
    public static void ShowCmds_PlacedBlocks() {
        EntityPlayer player = Minecraft.getMinecraft().player;
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("===[ Placed Blocks Commands] ===").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("#placedblocks_cmds => Placed blocks commands").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#placedblocks_cmds"))));
        player.sendMessage(new TextComponentString("#placedblocks_count => Show number of placed blocks").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#placedblocks_count"))));
        player.sendMessage(new TextComponentString("#placedblocks_resetcount => Reset number of placed blocks").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#placedblocks_resetcount"))));
        player.sendMessage(new TextComponentString("=====================").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
    }

    // Show broken blocks commands
    public static void ShowCmds_BrokenBlocks() {
        EntityPlayer player = Minecraft.getMinecraft().player;
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("===[ Broken Blocks Commands] ===").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("#brokenblocks_cmds => Broken blocks commands").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#brokenblocks_cmds"))));
        player.sendMessage(new TextComponentString("#brokenblocks_count => Show number of broken blocks").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#brokenblocks_count"))));
        player.sendMessage(new TextComponentString("#brokenblocks_resetcount => Reset number of broken blocks").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#brokenblocks_resetcount"))));
        player.sendMessage(new TextComponentString("=====================").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
    }
}
