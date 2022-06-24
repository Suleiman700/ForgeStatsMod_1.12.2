package com.example.examplemod.Players;

import com.example.examplemod.Sound.Sound;
import com.example.examplemod.chat.Chat;
import com.example.examplemod.events.OnAttackEntity;
import ibxm.Player;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerProjectileDamage {

    public static boolean Enabled = false;

//    public static void LivingHurtEvent(EntityLivingBase entity, DamageSource source, float amount) {
//        Chat.SendMessage("Took Hurt", "red");
//    }

//    @SubscribeEvent
//    public void onEvent(LivingEvent.LivingJumpEvent event) {
//        if (event.getEntity() instanceof EntityPlayer) {
//            Database.UpdateJump(Jumps);
//            Jumps++;
//        }
//    }

    public static void toggleState() {
        if (Enabled) {
            Enabled = false;
        } else {
            Enabled = true;
        }
    }

    public static boolean getState() {
        return Enabled;
    }

    @SubscribeEvent
    public void ProjectileImpactEvent(ProjectileImpactEvent event) {
        if (!Enabled) return ;

        String damageSrc = event.getEntity().getName(); // Arrow
        Object damageSrc_Amount = event.getRayTraceResult().toString(); // All info
        Entity target = event.getRayTraceResult().entityHit; // Target info

        // Return if target is null (shooting at blocks are anything other than players and mobs)
        if (target == null) return;

        // If target is player
        if (target instanceof EntityPlayer) {
            Chat.SendMessage(String.valueOf(target), "green");

            String targetName = target.getName();

//            float targetHealth = PlayersHealth.getHealth(targetName);
            float targetHealth = ((EntityPlayer) target).getHealth();
            Chat.SendMessage("Shooting: " + target.getName() + " | Health: " + targetHealth, "red");

//            boolean SpeakHealthNumber = OnAttackEntity.getSpeakHealthNumberState();
//            if (SpeakHealthNumber) {
//                int targetHealth_Integer = Math.round(targetHealth);
//                Sound.PlayerPlayerHealthSound(targetHealth_Integer);
//            }
        }


    }
}
