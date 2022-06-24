package com.example.examplemod.FindInWorld;

import com.example.examplemod.chat.Chat;
import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import org.lwjgl.opengl.GL11;

public class DragonEgg {

    // Region settings
    private static int start_x = 50;
    private static int end_x = 50;
    private static int start_y = 5;
    private static int end_y = 10;
    private static int start_z = 50;
    private static int end_z = 50;

    // Coordinates for the search base position
    public static int posStartX = 0;
    public static int posStartY = 0;
    public static int posStartZ = 0;

    // Coordinates of the found dragon egg
    public static int dragonEggX = 0;
    public static int dragonEggY = 0;
    public static int dragonEggZ = 0;

    // Set the base position to search around
    public static void setSearchBasePosition(BlockPos blockpos) {
        posStartX = blockpos.getX();
        posStartY = blockpos.getY();
        posStartZ = blockpos.getZ();
    }

    // Find dragon egg in region
    public static boolean find() {
        boolean dragon_egg_found = false;

        BlockPos pos1 = new BlockPos(posStartX-start_x, posStartY-start_y, posStartZ-start_z);
        BlockPos pos2 = new BlockPos(posStartX+end_x, posStartY+end_y, posStartZ+end_z);

        // Find dragon egg in region
        for (BlockPos blockInRegion : BlockPos.getAllInBox(pos1, pos2)) {
            Block blockTypeInRegion = Minecraft.getMinecraft().world.getBlockState(blockInRegion).getBlock(); // Get block
            String blockNameInRegion = blockTypeInRegion.getLocalizedName(); // Get block name
            if (blockNameInRegion.equals("Dragon Egg")) {
                // Chat.SendMessage("Found Dragon Egg At: " + blockInRegion.getX() + " " + blockInRegion.getY() + " " + blockInRegion.getZ(), "green");
                // int dragonEggX = blockInRegion.getX();
                // int dragonEggY = blockInRegion.getY();
                // int dragonEggZ = blockInRegion.getZ();
                BlockPos dragonEggPos = new BlockPos(blockInRegion.getX(), blockInRegion.getY(), blockInRegion.getZ());
                dragonEggX = dragonEggPos.getX();
                dragonEggY = dragonEggPos.getY();
                dragonEggZ = dragonEggPos.getZ();

                if (dragonEggX > 1) {
                    dragon_egg_found = true;
                }
            }
        }

        if (!dragon_egg_found) {
            Chat.SendMessage("Dragon Egg Not Found Or You Are Out Of Reach Distance", "red");
        }

        return dragon_egg_found;
    }
}
