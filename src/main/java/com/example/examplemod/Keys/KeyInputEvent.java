package com.example.examplemod.Keys;

import com.example.examplemod.Outliner.Arrows_Outliner;
import com.example.examplemod.Outliner.Blocks_Outliner;
import com.example.examplemod.Outliner.Items_Outliner;
import com.example.examplemod.Outliner.Players_Outliner;
import com.example.examplemod.Render.Gui;
import com.example.examplemod.Movements.BlockEdgeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
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
            Players_Outliner.toggleState();
            Items_Outliner.toggleState();
            Arrows_Outliner.toggleState();
            Blocks_Outliner.toggleState();
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
