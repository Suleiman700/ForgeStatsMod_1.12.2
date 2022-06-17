package com.example.examplemod.Movements;

import com.example.examplemod.chat.Chat;

public class BlockEdgeEvent {

    public static boolean Enabled = false;
    public static boolean Sneak = false;
    public static boolean LockView = true;
    public static boolean AutoPlace = false;

    public static float playerX_BK = 0;
    public static float playerY_BK = 0;
    public static float playerZ_BK = 0;

    // Enable / Disable
    public static void toggle() {
        if (Enabled) {
            Enabled = false;
//            Chat.SendMessage("Scaffold Disabled", "red");
        }
        else if (!Enabled) {
            Enabled = true;
//            Chat.SendMessage("Scaffold Enabled", "green");
        }
        Sneak = Enabled;
    }

    public static boolean getEnabled() {
        return Enabled;
    }

    // Get sneak state
    public static boolean getSneak() {
        return Sneak;
    }

    // Toggle AutoPlace
    public static void toggleAutoPlace() {
        if (AutoPlace) AutoPlace = false;
        else AutoPlace = true;
//        Chat.SendMessage("Scaffold AutoPlace: " + AutoPlace, "green");
    }

    // Toggle LockView
    public static void toggleLockView() {
        if (LockView) LockView = false;
        else LockView = true;
//        Chat.SendMessage("Scaffold LockView: " + LockView, "green");
    }


//
//
//    @SubscribeEvent
//    public void onTick(TickEvent.PlayerTickEvent event) {
//        if (event.phase != TickEvent.Phase.START) return; // see EntityPlayer.onUpdate
//        if (event.player instanceof EntityPlayerSP) {
//            final EntityPlayerSP player = (EntityPlayerSP) event.player;
////            final EntityPlayerSP player = (EntityPlayerSP) event.player;
//
//            player.movementInput.sneak = true;
//            Minecraft.getMinecraft().player.setSneaking(true);
//
//
//            // Store player looking at direction
//            int LookingDirection2 = MathHelper.floor((double)((event.player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
//            Data.setLookingDirection(LookingDirection2);
//            String LookingDirection = Data.getLookingDirection();
//
//            // Get player held item
//            String playerHeldItemName = player.getHeldItemMainhand().getUnlocalizedName();
//            int playerHeldItemCount = player.getHeldItemMainhand().getCount();
//
//            // Get building blocks
//            List BuildingBlocks = Data.getBuildingBlocks();
//
//            float playerX = (float) player.posX;
//            float playerY = (float) player.posY;
//            float playerZ = (float) player.posZ;
//            float playerHeadPitch = player.rotationPitch;
//            float blockUnderX = player.getPosition().down().getX();
//            float blockUnderY = player.getPosition().down().getY();
//            float blockUnderZ = player.getPosition().down().getZ();
//
//            // Get bottom block behind player
//            Block blockClicked = Minecraft.getMinecraft().world.getBlockState(new BlockPos(blockUnderX, blockUnderY, blockUnderZ)).getBlock();
//            String playerBlockBehind = blockClicked.getUnlocalizedName();
////             Chat.SendMessage(playerBlockBehind, "green");
//            if (!Enabled) return;
//
//
////            if (player.rotationPitch > 86) {
////                LockView = false;
////            }
//
//
//            if (LookingDirection=="NORTH") {
//                if (playerZ > blockUnderZ) {
//                    if (LockView) {
//                        player.rotationPitch = Float.parseFloat("82.5"); // Set camera pitch
//                        player.rotationYaw = Float.parseFloat("-180"); // Set camera yaw
//                    }
//
//                    if (AutoPlace) {
//                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
//                    }
//
//                    Sneak = true;
//                } else {
//                    Sneak = false;
//                }
//            }
//
//            else if (LookingDirection=="EAST") {
//                if (playerX < blockUnderX) {
//                    Sneak = true;
//
//                    if (LockView) {
//                        player.rotationPitch = Float.parseFloat("82.9"); // Set camera pitch
//                        player.rotationYaw = Float.parseFloat("-90"); // Set camera yaw
//                    }
//
//                    if (AutoPlace) {
//                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
//                    }
//                } else {
//                    Sneak = false;
//                }
//            }
//
//            else if (LookingDirection=="WEST") {
//                if (playerX > blockUnderX) {
//                    Sneak = true;
//
//                    if (LockView) {
//                        player.rotationPitch = Float.parseFloat("82.9"); // Set camera pitch
//                        player.rotationYaw = Float.parseFloat("90"); // Set camera yaw
//                    }
//
//                    if (AutoPlace) {
//                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
//                    }
//                } else {
//                    Sneak = false;
//                }
//            }
//
//            else if (LookingDirection=="SOUTH"){
//                if (playerZ < blockUnderZ) {
//                    // System.out.println("SOUTH OUT");
//                    Sneak = true;
//
//                    if (LockView) {
//                        player.rotationPitch = Float.parseFloat("82.9"); // Set camera pitch
//                        player.rotationYaw = Float.parseFloat("0"); // Set camera yaw
//                    }
//
//                    if (AutoPlace) {
//                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
//                    }
//                } else {
//                    Sneak = false;
//                }
//                if (playerHeadPitch > 65 && playerHeadPitch < 86) {
//                }
//            }
//        }
//    }
}
