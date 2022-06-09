package com.example.examplemod;

//import net.minecraft.entity.Entity;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraftforge.event.entity.living.LivingDeathEvent;
//
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraft.init.Blocks;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventHandler;
//import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//
//import net.minecraftforge.event.entity.living.LivingDeathEvent;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import com.example.examplemod.events.PlayerFallEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

//import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//
//import net.minecraft.init.Items;
//import net.minecraft.item.ItemStack;
//import net.minecraftforge.event.world.BlockEvent;
//
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.projectile.EntityArrow;
//import net.minecraft.entity.projectile.EntityFireball;
//import net.minecraft.world.Explosion;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PlayerTick {





//    @SubscribeEvent
//    public void playerTick(PlayerTickEvent event) {
//        System.out.println("Starting Player Tick for: ");
//        Double x = event.player.posX;
//        Double y = event.player.posY;
//        Double z = event.player.posZ;
//        Float health = event.player.getHealth();
//        String info = "Player POS: " + x + " " + y + " " + z + " HEALTH: " + health;
//        System.out.println(info);
//



//        try {
//            FileWriter myWriter = new FileWriter("C:\\abcfolder\\textfile.txt");
//            myWriter.write("X:" + x + ",Y:" + y + ",Z:" + z + ",HEALTH:" + health);
//            myWriter.close();
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
}
