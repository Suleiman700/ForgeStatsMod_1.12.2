package com.example.examplemod;

//import net.minecraft.init.Blocks;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventHandler;
//import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import org.apache.logging.log4j.Logger;

import com.example.examplemod.chat.Chat;
import com.example.examplemod.events.BlockEvent;
import com.example.examplemod.events.OnAttackEntity;
import com.example.examplemod.events.OnChatCommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

//import net.minecraft.init.Blocks;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraftforge.event.entity.living.LivingDeathEvent;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
//
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";


//    private static Logger logger;

//    @EventHandler
//    public void preInit(FMLPreInitializationEvent event)
//    {
//        logger = event.getModLog();
//    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
//        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        MinecraftForge.EVENT_BUS.register(new PlayerTick());
        MinecraftForge.EVENT_BUS.register(new OnTakeDamage());
        MinecraftForge.EVENT_BUS.register(new OnAttackEntity());
        MinecraftForge.EVENT_BUS.register(new OnChatCommand());
        MinecraftForge.EVENT_BUS.register(new Chat());
        MinecraftForge.EVENT_BUS.register(new BlockEvent());



    }

//    @SubscribeEvent
//    public static void onPlayerFall(PlayerFallEvent event) {
//
//        event.setDistance(event.getDistance() / 2);
//        System.out.println("onPlayerFall");
//    }


}
