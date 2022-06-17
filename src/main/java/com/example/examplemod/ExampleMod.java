package com.example.examplemod;

import com.example.examplemod.Render.Gui;
import com.example.examplemod.Keys.KeyInputEvent;
import com.example.examplemod.Movements.BlockEdgeEvent;
import com.example.examplemod.chat.Chat;
import com.example.examplemod.chat.Commands;
import com.example.examplemod.events.OnAttackEntity;
import com.example.examplemod.events.PlayerTick;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    public static String MCPlayerName123 = "123";


    //    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new Commands());
        MinecraftForge.EVENT_BUS.register(new Chat());

        // Data
        MinecraftForge.EVENT_BUS.register(new Data());
        FMLCommonHandler.instance().bus().register(new PlayerTick());

        FMLCommonHandler.instance().bus().register(new Gui());

        // Combat
        MinecraftForge.EVENT_BUS.register(new OnAttackEntity());

        // Keybindings
        MinecraftForge.EVENT_BUS.register(new KeyInputEvent());

        // Movement
//        FMLCommonHandler.instance().bus().register(new JumpEvent());
//        FMLCommonHandler.instance().bus().register(new SneakEvent());
//        FMLCommonHandler.instance().bus().register(new FallEvent());
        FMLCommonHandler.instance().bus().register(new BlockEdgeEvent());

//        FMLCommonHandler.instance().bus().register(new EnderPearlEvent());
//        FMLCommonHandler.instance().bus().register(new ProjectileImpact());


//        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
//        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
//        MinecraftForge.EVENT_BUS.register(new OnTakeDamage());
//        MinecraftForge.EVENT_BUS.register(new OnChatCommand());
//        MinecraftForge.EVENT_BUS.register(new BlockEvent());
//        FMLCommonHandler.instance().bus().register(new BlockEvent());
//        FMLCommonHandler.instance().bus().register(new OnAttackEntity());
//        FMLCommonHandler.instance().bus().register(new BreakBlock());
//        FMLCommonHandler.instance().bus().register(new Iron());



//        FMLCommonHandler.instance().bus().register(new OnTakeDamage());

//        FMLCommonHandler.instance().bus().register(new Death());

//        FMLCommonHandler.instance().bus().register(new PlayerTick());

//        FMLCommonHandler.instance().bus().register(new InventoryCheck());
//        FMLCommonHandler.instance().bus().register(new Diamond());
//        FMLCommonHandler.instance().bus().register(new Dirt());

    }

//    @SubscribeEvent
//    public static void onPlayerFall(PlayerFallEvent event) {
//
//        event.setDistance(event.getDistance() / 2);
//        System.out.println("onPlayerFall");
//    }


}
