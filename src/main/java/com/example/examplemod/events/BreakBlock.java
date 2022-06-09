package com.example.examplemod.events;

import net.minecraftforge.fml.common.Mod;

public class BreakBlock {

    @Mod.EventHandler
    private void onBlockPlace() {

    }

//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent e) {
//        Chat.SendMessage("onBlockPlace!", "red");
//
////        if(e.getAct == Action.RIGHT_CLICK_BLOCK){
////            if(e.isCancelable()) e.setCanceled(true);
////        }
//    }

//    @SubscribeEvent
//    public void onInteract(PlayerInteractEvent.RightClickBlock event) {
//        EntityPlayer player = event.getEntityPlayer();
//        String item = player.getHeldItemMainhand().getDisplayName(); // Better name (Display name)
//        String item2 = player.getHeldItemMainhand().getUnlocalizedName(); // Gets name but ads (item.) in the start
//
//
//        Chat.SendMessage(item + " | " + item2, "pink");
//
//
//    }

//    @SubscribeEvent
//    public void onBlockPlaced(BlockEvent.PlaceEvent event)
//    {
//                Chat.SendMessage("onBlockPlaced", "pink");
//
//        if (!event.getWorld().isRemote)
//        {
//            if (event.getPlacedBlock().getBlock() == Blocks.DIRT)
//            {
//                event.setCanceled(true);
//            }
//        }
//    }

//    @SubscribeEvent
//    public static void block_break(net.minecraftforge.event.world.BlockEvent.PlaceEvent event)
//    {
//        Chat.SendMessage("BlockBreakEvent 1", "pink");
//
//    }


//    @SubscribeEvent
//    public void BlockBreakEvent(BlockEvent.BreakEvent event) {
//                Chat.SendMessage("BlockBreakEvent 2", "pink");
//
//    }

}