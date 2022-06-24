package com.example.examplemod.FindInWorld;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;


// Get block player looking at from a long distance
public class LookingAtBlockFromDistance {

    public static int reachDistance = 500; // Distance
    public static int partialTicks = 100;

    public static BlockPos getCoords() {
        RayTraceResult mop = Minecraft.getMinecraft().player.rayTrace(reachDistance, partialTicks);
        BlockPos blockPos = mop.getBlockPos();
        float x = mop.getBlockPos().getX();
        float y = mop.getBlockPos().getY();
        float z = mop.getBlockPos().getZ();
//        Chat.SendMessage(String.valueOf(blockPos), "red");
//        String name = blockNameAtPos(blockPos);
//        Chat.SendMessage(name, "red");
        return blockPos;
    }

    // Get block name from coordinates
    public static String blockNameAtPos(BlockPos blockpos) {
        Block Block = Minecraft.getMinecraft().world.getBlockState(new BlockPos(blockpos.getX(), blockpos.getY(), blockpos.getZ())).getBlock();
        return Block.getLocalizedName();
    }

}
