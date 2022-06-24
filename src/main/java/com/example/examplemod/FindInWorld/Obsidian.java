package com.example.examplemod.FindInWorld;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;

// Find and count obsidian around dragon egg
public class Obsidian {

    // Region settings around the dragon egg
    private static int start_x = 7;
    private static int end_x = 7;
    private static int start_y = 2;
    private static int end_y = 7;
    private static int start_z = 7;
    private static int end_z = 7;

    public static int findAndCount() {
        int count_obsidian = 0;

        // Coordinated of the found dragon egg
        int FoundDragonEggPos_X = DragonEgg.dragonEggX;
        int FoundDragonEggPos_Y = DragonEgg.dragonEggY;
        int FoundDragonEggPos_Z = DragonEgg.dragonEggZ;

        BlockPos pos1 = new BlockPos(FoundDragonEggPos_X-start_x, FoundDragonEggPos_Y-start_y, FoundDragonEggPos_Z-start_z);
        BlockPos pos2 = new BlockPos(FoundDragonEggPos_X+end_x, FoundDragonEggPos_Y+end_y, FoundDragonEggPos_Z+end_z);

        for (BlockPos blockPosAroundEgg : BlockPos.getAllInBox(pos1, pos2)) {
            Block blockAroundEgg = Minecraft.getMinecraft().world.getBlockState(blockPosAroundEgg).getBlock();
            String blockNameAroundEgg = blockAroundEgg.getLocalizedName();

            if (blockNameAroundEgg.equals("Obsidian")) {
                count_obsidian++;
            }
        }

        return count_obsidian;
    }
}
