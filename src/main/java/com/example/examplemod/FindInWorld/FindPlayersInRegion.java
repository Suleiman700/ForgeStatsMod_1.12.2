package com.example.examplemod.FindInWorld;

import com.example.examplemod.Render.TextOnScreen;
import com.example.examplemod.chat.Chat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class FindPlayersInRegion {

    // Region settings
    private static int start_x = 20;
    private static int end_x = 20;
    private static int start_y = 10;
    private static int end_y = 10;
    private static int start_z = 20;
    private static int end_z = 20;

    // Coordinates for the search base position
    public static int posStartX = 0;
    public static int posStartY = 0;
    public static int posStartZ = 0;

    public static void setSearchBasePosition(BlockPos blockpos) {
        posStartX = blockpos.getX();
        posStartY = blockpos.getY();
        posStartZ = blockpos.getZ();
    }

    public static void find() {
        boolean found_players = false;
        int count_players = 0;
        String players_string = "";

        // Get looking at position
        BlockPos blockPos = LookingAtBlockFromDistance.getCoords();
        setSearchBasePosition(blockPos);

        EntityPlayerSP player = Minecraft.getMinecraft().player;

        // Get living entities in region
        List EntitiesAround = player.world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(posStartX - start_x, posStartY - start_y, posStartZ - start_z, posStartX + end_x, posStartY + end_y, posStartZ + end_z));

        // Get multiplayer players only
        for (Object entityLivingAround : EntitiesAround) {
            if (entityLivingAround instanceof EntityOtherPlayerMP || entityLivingAround instanceof EntityPlayerMP) {
                found_players = true;
                count_players++;
                players_string += ((EntityPlayer) entityLivingAround).getName() + " ";
            }
        }
        Chat.SendMessage(count_players + " Players In Region " + players_string, "green");
//        TextOnScreen.obsidianAroundEgg = count_players;
    }

}
