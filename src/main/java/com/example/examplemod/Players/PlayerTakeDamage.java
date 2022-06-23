package com.example.examplemod.Players;

import com.example.examplemod.chat.Chat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerTakeDamage {

//    public static void LivingHurtEvent(EntityLivingBase entity, DamageSource source, float amount) {
//        Chat.SendMessage("Took Hurt", "red");
//    }


    // Not triggering !!!
    @SubscribeEvent
    public static void LivingHurtEvent(LivingHurtEvent event) {
        System.out.println("here =========");
        EntityLivingBase entity = event.getEntityLiving();
        Chat.SendMessage(entity.getName(), "green");
//        if(entity.isRiding() && entity.getRidingEntity() instanceof EntityLivingBase) entity = (EntityLivingBase) entity.getRidingEntity();
//        if((entity instanceof EntityZombieHorse || entity instanceof EntitySkeletonHorse)
//                && event.getSource() == DamageSource.FALL
//                && ((AbstractHorse) entity).isTame()) {
//            event.setCanceled(true);
//        }
    }

}
