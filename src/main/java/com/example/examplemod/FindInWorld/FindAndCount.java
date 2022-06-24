package com.example.examplemod.FindInWorld;

import com.example.examplemod.Render.TextOnScreen;
import com.example.examplemod.chat.Chat;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;

public class FindAndCount {

    // Find and count obsidian around egg at the position the player is looking at
    public static void FindAndCountObsidianAroundEgg() {
        BlockPos blockPos = LookingAtBlockFromDistance.getCoords();
        DragonEgg.setSearchBasePosition(blockPos);
        boolean dragonEggFound = DragonEgg.find();
        if (dragonEggFound) {
            int obsidian_around_egg = Obsidian.findAndCount();
            Chat.SendMessage(obsidian_around_egg + " Obsidian blocks around egg", "green");
//            TextOnScreen.obsidianAroundEgg = obsidian_around_egg;
        }
    }

}
