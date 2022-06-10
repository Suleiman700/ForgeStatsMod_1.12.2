package com.example.examplemod.Movements;

import com.example.examplemod.Data;
import com.ibm.icu.impl.Utility;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static com.mojang.authlib.Agent.MINECRAFT;

public class BlockEdgeEvent {


    
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return; // see EntityPlayer.onUpdate
        if (event.player instanceof EntityPlayerSP) {
            final EntityPlayerSP player = (EntityPlayerSP) event.player;

            // Store player looking at direction

            int LookingDirection2 = MathHelper.floor((double)((event.player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
            Data.setLookingDirection(LookingDirection2);
            String LookingDirection = Data.getLookingDirection();

            float playerX = (float) player.posX;
            float playerZ = (float) player.posZ;
            float playerHeadPitch = player.rotationPitch;
            float blockUnderX = player.getPosition().down().getX();
            float blockUnderZ = player.getPosition().down().getZ();

            if (playerHeadPitch > 80 && playerHeadPitch < 84.5) {
                System.out.println("Can place block");

                Minecraft mc = Minecraft.getMinecraft();
                KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode());
            }


            if (LookingDirection=="NORTH") {
//                System.out.println("NORTH");

                System.out.println(blockUnderZ - playerZ);

                if (playerZ > blockUnderZ) {
//                    System.out.println("OUT NORTH");


                    if (blockUnderZ-playerZ>-0.22) {
                        player.rotationPitch = Float.parseFloat("82.5"); // Set camera pitch
                        player.rotationYaw = Float.parseFloat("-180"); // Set camera yaw
                        player.setSneaking(true);
                        System.out.println(player.isSneaking());
                        player.setVelocity(0, 0, 0);
                    }

                }
            } else if (LookingDirection=="EAST") {
//                System.out.println("EAST");
                if (playerX < blockUnderX) {
                    System.out.println("OUT");
                }
            } else if (LookingDirection=="WEST") {
//                System.out.println("WEST");
                if (playerX > blockUnderX) {
                    System.out.println("OUT");
                }
            } else if (LookingDirection=="SOUTH"){
//                System.out.println("SOUTH");
                if (playerZ < blockUnderZ) {
                    System.out.println("OUT");
                }
            }

//            System.out.println(playerHeadPitch);

//            System.out.println(playerX + " " + blockUnderX);


        }
    }
}
