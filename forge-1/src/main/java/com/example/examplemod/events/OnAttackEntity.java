package com.example.examplemod.events;

import com.example.examplemod.chat.Chat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;


public class OnAttackEntity {

    private static boolean enabled = true;

    // Change state <true/false>
    public static void ToggleEvent(boolean option) {
        enabled = option;
        Chat.SendMessage("Event: OnAttackEntity has been changed to: " + enabled, "red");
    }

    // Show if enabled/disabled in player chat
    public static void CheckState() {
        Chat.SendMessage("OnAttackEntity is set to: " + enabled, "red");
    }

    @SubscribeEvent
    public void onPickupItem(EntityItemPickupEvent event) {
        Chat.SendMessage("PICKUP EVENT", "red");
    }

    @SubscribeEvent
    public void onAttackEntityEvent(AttackEntityEvent event) throws IOException {
        if (!enabled) return;

        if (event.getTarget() == null || event.getEntityPlayer() == null) {
            return;
        }

        Chat.SendMessage("ATTACK EVENT", "red");

        EntityPlayer player = event.getEntityPlayer();
        Entity target = event.getTarget();
        int item = player.getHeldItemMainhand().getItemDamage();


        System.out.println("Player: " + player.getName() + " Target: " + target.getName() + " Item: " + item);

//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con= DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/scb_v2","root","");
////here sonoo is database name, root is username and password
//            Statement stmt=con.createStatement();
//            int rs = stmt.executeUpdate("UPDATE `records` SET `FullName` = 'test' WHERE `records`.`id` = 2;");
//            System.out.println(rs);
////            while(rs.next())
////                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//            con.close();
//        }catch(Exception e){ System.out.println(e);
//        }

        // Get JSON object

//        Path path = Paths.get("C:\\abcfolder\\attack.txt");
//
//        BufferedReader reader = Files.newBufferedReader(path);
//        String line = reader.readLine();
//        System.out.println(line);



//        System.out.println(obj);

//        try {
//            FileWriter myWriter = new FileWriter("C:\\abcfolder\\attack.txt", true);
//            myWriter.write(String.valueOf(obj));
////            myWriter.write("onAttackEntityEvent player: " + player.getName() + " Mob: " + target.getName());
//            myWriter.close();
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
    }
}
