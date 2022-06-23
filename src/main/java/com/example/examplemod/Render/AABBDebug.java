package com.example.examplemod.Render;

import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AABBDebug {
    @SubscribeEvent
    public void render(RenderLivingEvent.Pre event) {
        float health = event.getEntity().getHealth();
        String name = event.getEntity().getDisplayName().getFormattedText();
        //System.out.println(name + ", " + health);
        event.getEntity().setCustomNameTag("" + health + "§c❤");
        event.getEntity().setAlwaysRenderNameTag(true);
        return;
    }

}
