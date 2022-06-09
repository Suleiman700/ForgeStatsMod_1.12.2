package com.example.examplemod.events;

import com.example.examplemod.Players.PlayersHealth;
import com.example.examplemod.chat.Chat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class OnAttackEntity {

    private static boolean enabled = true;

    // Toggle event state
    public static void toggleState(boolean option) {
        Chat.SendMessage("[E] OnAttackEntity state has been set to: " + enabled, "red");
        enabled = option;
    }

    // Show event state in player chat
    public static void getState() {
        Chat.SendMessage("[e] OnAttackEntity state is: " + enabled, "red");
    }


    @SubscribeEvent
    public void AttackEntityEvent(AttackEntityEvent event) {
        if (!enabled) return;
        if (event.getTarget() == null || event.getEntityPlayer() == null) return;


        EntityPlayer player = event.getEntityPlayer();
        Entity target = event.getTarget();

        // Check if player health exist
        boolean found = PlayersHealth.healthFound(target.getName());
        if (found) {
            float targetHealth = PlayersHealth.getHealth(target.getName());
            Chat.SendMessage("Attacking: " + target.getName() + " | Health: " + targetHealth, "red");
        } else {
            Chat.SendMessage("Attacking: " + target.getName(), "red");
        }
        //        String item = player.getHeldItemMainhand().getDisplayName(); // Better name (Display name)
//        String item2 = player.getHeldItemMainhand().getUnlocalizedName(); // Gets name but ads (item.) in the start
    }



//    @SubscribeEvent
//    public void BreakEvent(BlockEvent event)
//    {
//        Chat.SendMessage("BreakEvent", "red");
//
//    }


//    @SubscribeEvent
//    void onBlockDropItems(BlockEvent.HarvestDropsEvent event) {
//        Chat.SendMessage("onBlockDropItems", "red");
//    }
//
//    @SubscribeEvent
//    public void LivingEntityUseItemEvent(LivingEntityUseItemEvent e) {
//        String item = e.getItem().getDisplayName();
//        Chat.SendMessage("Using Item : " + item, "red");
//    }
//
//
//
//
//

//    @SubscribeEvent
//    public void onPlayerHurt(LivingHurtEvent event) {
//        Chat.SendMessage("onPlayerHurt", "green");
//        if (event.getSource().isProjectile()) {
//            String gamePlayerName = PlayerTick.getPlayerName(); // Game player name
//
//            // Get attacker name
//            EntityPlayerMP attacker = (EntityPlayerMP) event.getSource().getTrueSource();
//            String attackerName = attacker.getDisplayNameString();
//
//            Chat.SendMessage("ARROW", "green");
//
//            System.out.println("isProjectile BY PLAYER: " + gamePlayerName + " ATTACKER: " + attackerName);
//
//            // Damage dealt
//            float damage = event.getAmount();
//
//            // Get target info
//            String targetName = event.getEntity().getName();
//            float targetHealth = event.getEntityLiving().getHealth();
//
//            Chat.SendMessage("Shot: " + targetName + " | Damage: " + damage + " | HealthB4: " + targetHealth + " | HealthAFTR: " + (targetHealth - damage), "green");
//
//
//            if (gamePlayerName.contains(attackerName) || attackerName.contains(gamePlayerName)) {
//                // Damage dealt
////                float damage = event.getAmount();
////
////                // Get target info
////                String targetName = event.getEntity().getName();
////                float targetHealth = event.getEntityLiving().getHealth();
////
////                Chat.SendMessage("Shot: " + targetName + " | Damage: " + damage + " | HealthB4: " + targetHealth + " | HealthAFTR: " + (targetHealth - damage), "green");
//            }
//        }
//
//    }



//    @SubscribeEvent
//    public void regiterItems(ProjectileImpactEvent event) {
//        Chat.SendMessage("here", "green");
//        if (event.getRayTraceResult().typeOfHit == RayTraceResult.Type.BLOCK){
//            //Destroy block here
//        }
//    }




}
