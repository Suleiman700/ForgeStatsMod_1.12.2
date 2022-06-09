package com.example.examplemod.events;


import com.example.examplemod.chat.Chat;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockEvent {

    static int PlacedBlocks = 0;
    static int BrokenBlocks = 0;
    boolean enabled = true;

    // Set state <true/false>
    public void SetBlockPlaced(boolean state) {
        enabled = state;
    }

    // Show count of placed blocks in chat
    public static void ShowBlockPlacedCount() {
        Chat.SendMessage("Placed blocks: " + Integer.toString(PlacedBlocks), "red");
    }

    // Show count of broken blocks in chat
    public static void ShowBlockBrokenCount() {
        Chat.SendMessage("Broken blocks: " + Integer.toString(BrokenBlocks), "red");
    }

    // Reset count of placed blocks
    public static void ResetBlockPlacedCount() {
        PlacedBlocks = 0;
        Chat.SendMessage("Number of placed blocks has been set to 0", "red");
    }

    // Reset count of broken blocks
    public static void ResetBlockBrokenCount() {
        BrokenBlocks = 0;
        Chat.SendMessage("Number of broken blocks has been set to 0", "red");
    }

    @SubscribeEvent
    public void onBlockPlaceEvent(net.minecraftforge.event.world.BlockEvent.PlaceEvent event) {
//        if (!enabled) return;
//
//        if (event.getPlayer() != null) {
//            ResourceLocation blockName = event.getState().getBlock().getRegistryName();
//            PlacedBlocks++;
////            if (blockName.getResourceDomain().equals(Reference.MOD_ID)) {
////            }
////            OverdriveExtendedProperties extendedProperties = MOPlayerCapabilityProvider.GetExtendedCapability(event.getPlayer());
////            if (extendedProperties != null) {
////                extendedProperties.onEvent(event);
////            }
//        }
    }

    @SubscribeEvent
    public void onBlockBreakEvent(net.minecraftforge.event.world.BlockEvent.BreakEvent event) {
//        Chat.SendMessage("onBlockBreakEvent: ", "red");
//        if (!enabled) return;
//        BrokenBlocks++;
    }
}
