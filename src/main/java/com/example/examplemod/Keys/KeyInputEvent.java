package com.example.examplemod.Keys;

import com.example.examplemod.Movements.BlockEdgeEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyInputEvent {

//    public static boolean Sneak = false;

    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event) {
//        Chat.SendMessage(String.valueOf(Keyboard.getEventKey()), "green");


        // Toggle scaffold
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && Keyboard.isKeyDown(Keyboard.KEY_Z)) {
            BlockEdgeEvent.toggle();
        }
//        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
//            if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
//            }
//        }

    }

    @SubscribeEvent
    public void onInputUpdate(InputUpdateEvent event) {
        boolean NeedSneaking = BlockEdgeEvent.getSneak();
        if (NeedSneaking) {
            event.getMovementInput().sneak = true;
        }
        else if (!NeedSneaking) {
            event.getMovementInput().sneak = false;
        }
    }
}
