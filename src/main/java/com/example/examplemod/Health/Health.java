package com.example.examplemod.Health;

import com.example.examplemod.db.Database;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class Health {

    private static boolean SaveHealthToDB = true;

    private static boolean playSoundOnLowHealth = true; // Play sound when player health is low
    private static float LowHealth = 3.0F; // Flag 3.0 as a low health

    public static void checkHealth(EntityPlayer player, float playerHealth) {
        if (SaveHealthToDB) {
            Database.UpdateHealth(playerHealth);
        }

        // Play sound on low health
        if (playSoundOnLowHealth && playerHealth <= LowHealth) {
//            Chat.SendMessage("LOW HEALTH", "red");

//            double x = player.posX;
//            double y = player.posY;
//            double z = player.posZ;

            player.playSound(SoundEvents.ENTITY_GHAST_HURT, 0.5F, 0.1F);
        }
    }

    PositionedSoundRecord sound = new PositionedSoundRecord(SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.HOSTILE, 1, 1, new BlockPos(0, 0, 0));

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        if (!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(sound)) {
            sound = new PositionedSoundRecord(SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.HOSTILE, 1, 1, playerIn.getPosition());
            Minecraft.getMinecraft().getSoundHandler().playSound(sound);
        }
    }


}
