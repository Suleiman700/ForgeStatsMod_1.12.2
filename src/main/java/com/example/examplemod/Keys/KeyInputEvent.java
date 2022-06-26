package com.example.examplemod.Keys;

import com.example.examplemod.FindInWorld.FindAndCount;
import com.example.examplemod.FindInWorld.FindPlayersInRegion;
import com.example.examplemod.FindInWorld.LookingAtBlockFromDistance;
import com.example.examplemod.Outliner.*;
import com.example.examplemod.Render.Gui;
import com.example.examplemod.Movements.BlockEdgeEvent;
import com.example.examplemod.Render.RemoteCamera;
import com.example.examplemod.chat.Chat;
import com.mojang.authlib.GameProfile;
import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.UUID;

import static clojure.lang.RT.box;

public class KeyInputEvent {

    ClientViewPlayer view = null;
    private FakePlayer camEntity;

//    public static boolean Sneak = false;

//    @SubscribeEvent
//    public void RenderBlockOverlay(RenderBlockOverlayEvent event) {
//        Chat.SendMessage("here", "green");
//    }


//    @SubscribeEvent
//    public void render(RenderWorldLastEvent event){
////        DoMyRendering(event.getPartialTicks());
////        Chat.SendMessage(String.valueOf(event.getListenerList().), "green");
////        RenderGlobal name = event.getContext();
////        GL11.glDisable(GL11.GL_TEXTURE_2D);
////        GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.4F);
//    }


    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event) {
//        Chat.SendMessage(String.valueOf(Keyboard.getEventKey()), "green");


        // Toggle scaffold
        if (Keyboard.isKeyDown(Keyboard.KEY_F8)) {
            BlockEdgeEvent.toggle();
        }

        // Show GUI
        else if (Keyboard.isKeyDown(Keyboard.KEY_F12)) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen) new Gui());
        }

        // Remote camera go up
        else if (Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)) {
            RemoteCamera.verticalMove("up");
        }
        // Remote camera go down
        else if (Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2)) {
            RemoteCamera.verticalMove("down");
        }

        // Remote camera
        else if (Keyboard.isKeyDown(Keyboard.KEY_F7)) {
            RemoteCamera.toggleRemoteCam();
        }

        // Find dragon egg and count obsidian
        else if (Keyboard.isKeyDown(Keyboard.KEY_F9)) {
            FindAndCount.FindAndCountObsidianAroundEgg();
            FindPlayersInRegion.find();
        }

        // ESP
        else if (Keyboard.isKeyDown(Keyboard.KEY_F10)) {
            Controller_Outliner.toggleState();





//            Minecraft mc = Minecraft.getMinecraft();
//            GameProfile gameprofile = mc.player.getGameProfile();
//            EntityLivingBase e;
//            e = new EntityOtherPlayerMP(mc.world, gameprofile);
////            e.posX = mc.player.posX;
//            e.posX = 218;
//            e.posY = 75;
//            e.posZ = 269;
//            e.cameraPitch = -36;
//            e.rotationPitch = 31;
//            mc.setRenderViewEntity(e);




//            Minecraft mc = Minecraft.getMinecraft();
//            EntityPlayerSP player = mc.player;

//            // Fake player 1
//            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "FakePlayer");
//            camEntity = new FakePlayer(DimensionManager.getWorld(0), gameProfile);
//            camEntity.noClip = true;
//            camEntity.setPositionAndRotation(218, 75, 269, -36, 31);
//            mc.setRenderViewEntity(camEntity);



//            // Fake player 2 - WORKING
//            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "FakePlayer2");
//            FakePlayer fakePlayer = new FakePlayer(DimensionManager.getWorld(0), gameProfile);
//            // offset slightly so not looking at inside of player model:
//            Vec3d vec3d = mc.player.getLookVec();
//            double dx = (mc.gameSettings.thirdPersonView > 0 ? 0.0D : vec3d.x);
//            double dz = (mc.gameSettings.thirdPersonView > 0 ? 0.0D : vec3d.z);
//            fakePlayer.setLocationAndAngles(player.posX + dx, player.posY + 10, player.posZ + dz, player.rotationYaw, player.rotationPitch);
//            // set previous values to prevent camera from freaking out:
//            fakePlayer.prevRotationPitch = mc.player.prevRotationPitch;
//            fakePlayer.prevRotationYaw = mc.player.prevRotationYaw;
//            fakePlayer.rotationYawHead = mc.player.rotationYawHead;
//            fakePlayer.prevPosX = mc.player.prevPosX + 1;
//            fakePlayer.prevPosY = mc.player.prevPosY;
//            fakePlayer.prevPosZ = mc.player.prevPosZ + 1;
//            mc.setRenderViewEntity(fakePlayer);
//            mc.updateDisplay();



//            // push the matrix to prevent everything from getting f-ed up
//            GL11.glPushMatrix();
//            // translate to get the render position to match the physical bounding box position
//            GL11.glTranslatef(0.0F, -6.325F, 0.0F);
//            // I'm rendering a giant, hard-coded for now
//            GL11.glScalef(3.0F, 3.0F, 3.0F);







//            view.setLocationAndAngles(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY + 10.0D, Minecraft.getMinecraft().player.posZ, Minecraft.getMinecraft().player.rotationYawHead, 90);
//            view.world = Minecraft.getMinecraft().player.world;
//            Minecraft.getMinecraft().setRenderViewEntity(view);


//            Players_Outliner.toggleState();
//            Items_Outliner.toggleState();
//            Arrows_Outliner.toggleState();
//            Blocks_Outliner.toggleState();
        }
    }

    @SubscribeEvent
    public void onInputUpdate(InputUpdateEvent event) {
        boolean NeedSneaking = BlockEdgeEvent.getSneak();
        boolean ScaffoldEnabled = BlockEdgeEvent.getEnabled();
        if (!ScaffoldEnabled) return;
        if (NeedSneaking) {
            event.getMovementInput().sneak = true;
        }
        else if (!NeedSneaking) {
            event.getMovementInput().sneak = false;
        }
    }
}
