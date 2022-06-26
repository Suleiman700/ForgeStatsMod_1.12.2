package com.example.examplemod.Render;

import com.example.examplemod.FindInWorld.LookingAtBlockFromDistance;
import com.example.examplemod.chat.Chat;
import com.mojang.authlib.GameProfile;
import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

import java.util.UUID;

import static net.minecraft.client.gui.inventory.GuiInventory.drawEntityOnScreen;

public class RemoteCamera {
    public static boolean Enabled = false;

    private static FakePlayer fakePlayer = null;

    // Fake player position
    static double fakePlayerX = 0;
    static double fakePlayerY = 0;
    static double fakePlayerZ = 0;
    static float fakePlayerRotationYaw = 0;
    static float fakePlayerRotationPitch = 0;

    // Camera position
    int camPosX = 0;
    int camPosY = 0;
    int camPosZ = 0;
    int camRotationYaw = 0;
    int camRotationPitch = 0;

    public static void genFakePlayer() {
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "FakePlayer");
        FakePlayer newFakePlayer = new FakePlayer(DimensionManager.getWorld(0), gameProfile);
        fakePlayer = newFakePlayer;
    }

    // Toggle remote camera
    public static void toggleRemoteCam() {
        if (Enabled) {
            turnOffRemoteCam();
            Enabled = false;
        } else {
            setRemoteCamPosition();
            Enabled = true;
        }
    }

    // Turn off remote camera
    public static void turnOffRemoteCam() {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;

        mc.setRenderViewEntity(player);
//        mc.updateDisplay();
    }

    // Remote camera above player
    public static void turnOnRemoteCam() {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;

        // Check pre-generated fake player
        if (fakePlayer == null) {
            genFakePlayer();
        }

        // offset slightly so not looking at inside of player model:
        Vec3d vec3d = mc.player.getLookVec();
        double dx = (mc.gameSettings.thirdPersonView > 0 ? 0.0D : vec3d.x);
        double dz = (mc.gameSettings.thirdPersonView > 0 ? 0.0D : vec3d.z);

        // Save fake player position
        fakePlayerX = player.posX + dx;
        fakePlayerY = player.posY + 10;
        fakePlayerZ = player.posZ + dz;
        fakePlayerRotationYaw = player.rotationYaw;
        fakePlayerRotationPitch = player.rotationPitch;

        fakePlayer.setLocationAndAngles(fakePlayerX, fakePlayerY, fakePlayerZ, fakePlayerRotationYaw, fakePlayerRotationPitch);

        // set previous values to prevent camera from freaking out:
        fakePlayer.prevRotationPitch = player.prevRotationPitch;
        fakePlayer.prevRotationYaw = player.prevRotationYaw;
        fakePlayer.rotationYawHead = player.rotationYawHead;
        fakePlayer.prevPosX = player.prevPosX + 1;
        fakePlayer.prevPosY = player.prevPosY;
        fakePlayer.prevPosZ = player.prevPosZ + 1;
        mc.setRenderViewEntity(fakePlayer);
//        mc.updateDisplay();
    }

    // Set remote camera position at the block player is looking at
    public static void setRemoteCamPosition() {
        // Check pre-generated fake player
        if (fakePlayer == null) {
            genFakePlayer();
        }

        BlockPos blockPos = LookingAtBlockFromDistance.getCoords();

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;

        // Save fake player position
        fakePlayerX = blockPos.getX();
        fakePlayerY = blockPos.getY() + 10;
        fakePlayerZ = blockPos.getZ();
        fakePlayerRotationYaw = player.rotationYaw;
        fakePlayerRotationPitch = player.rotationPitch;

        fakePlayer.setLocationAndAngles(fakePlayerX, fakePlayerY, fakePlayerZ, fakePlayerRotationYaw, fakePlayerRotationPitch);

        // set previous values to prevent camera from freaking out:
        fakePlayer.prevRotationPitch = player.prevRotationPitch;
        fakePlayer.prevRotationYaw = player.prevRotationYaw;
        fakePlayer.rotationYawHead = player.rotationYawHead;
        fakePlayer.prevPosX = fakePlayerX;
        fakePlayer.prevPosY = fakePlayerY;
        fakePlayer.prevPosZ = fakePlayerZ;
        mc.setRenderViewEntity(fakePlayer);
    }

    // Update remote camera rotation as the player rotation
    public static void updateCamRotation() {
        // Check pre-generated fake player
        if (fakePlayer == null) {
            genFakePlayer();
        }

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;

        // Save fake player position
        fakePlayerRotationYaw = player.rotationYaw;
        fakePlayerRotationPitch = player.rotationPitch;

        fakePlayer.setLocationAndAngles(fakePlayerX, fakePlayerY, fakePlayerZ, fakePlayerRotationYaw, fakePlayerRotationPitch);

        // set previous values to prevent camera from freaking out:
        fakePlayer.prevRotationPitch = fakePlayerRotationPitch;
        fakePlayer.prevRotationYaw = fakePlayerRotationYaw;
        fakePlayer.rotationYawHead = player.rotationYawHead;
        mc.setRenderViewEntity(fakePlayer);
    }

    // Remote camera go up or down
    public static void verticalMove(String direction) {
        if (Enabled) {
            // Check pre-generated fake player
            if (fakePlayer == null) {
                genFakePlayer();
            }

            Minecraft mc = Minecraft.getMinecraft();

            // Save fake player position
            if (direction.equals("up")) {
                fakePlayerY = fakePlayerY + 2;
            } else if (direction.equals("down")) {
                fakePlayerY = fakePlayerY - 2;
            }

            fakePlayer.setLocationAndAngles(fakePlayerX, fakePlayerY, fakePlayerZ, fakePlayerRotationYaw, fakePlayerRotationPitch);

            // set previous values to prevent camera from freaking out:
            fakePlayer.prevPosY = fakePlayerY;
            mc.setRenderViewEntity(fakePlayer);
        }
    }
}
