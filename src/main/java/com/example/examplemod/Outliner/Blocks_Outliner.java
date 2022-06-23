package com.example.examplemod.Outliner;

import com.example.examplemod.chat.Chat;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class Blocks_Outliner {

    public static boolean Enabled = false;

    public static boolean getState() {
        return Enabled;
    }


    public static void re_enable() {
//        List<Entity> entities = Minecraft.getMinecraft().world.loadedEntityList;
//        for (int i = 0; i < entities.size(); i++) {
//            if (entities.get(i) instanceof EntityItem && entities.get(i) instanceof EntityItem) {
//                entities.get(i).setGlowing(Enabled);
//            }
//        }
    }

    public static void toggleState() {
        if (Enabled) {
            Enabled = false;
        }
        else {
            Enabled = true;
        }

        Chat.SendMessage("im here", "green");


        // Get block at pos
//        BlockPos pos = new BlockPos(-213, 73, 341);
//        IBlockState ibs = Minecraft.getMinecraft().world.getBlockState(pos);
//        Block block = ibs.getBlock();
//        Chat.SendMessage(block.getLocalizedName(), "green");


        re_enable();
    }




}
