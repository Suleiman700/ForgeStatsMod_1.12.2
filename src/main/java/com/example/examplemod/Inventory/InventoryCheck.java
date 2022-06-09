package com.example.examplemod.Inventory;

import com.example.examplemod.Items.*;
import net.minecraft.entity.player.EntityPlayer;

public class InventoryCheck {

    private int tickCounter = 0;

    public static int DiamondStorage = 0;
    public static int GoldStorage = 0;
    public static int IronStorage = 0;
    public static int DirtStorage = 0;
    public static int TerracottaStorage = 0;

    private static void resetStorage() {
        DiamondStorage = 0;
        GoldStorage = 0;
        IronStorage = 0;
        DirtStorage = 0;
        TerracottaStorage = 0;
    }

    public static void checkInventory(EntityPlayer player) {
        resetStorage();

        for (int i = 0; i < 27; i++) {
            String ItemName = player.inventory.getStackInSlot(i).getDisplayName(); // Like: Iron Ingot
            String ItemName2 = player.inventory.getStackInSlot(i).getUnlocalizedName(); // Like: item.ingotIron
            int ItemCount = player.inventory.getStackInSlot(i).getCount();
            
            if (ItemName.contains("Diamond")) {
                DiamondStorage += ItemCount;
            }
            else if (ItemName.contains("Gold")) {
                GoldStorage += ItemCount;
            }
            else if (ItemName.contains("Iron")) {
                IronStorage += ItemCount;
            }
            else if (ItemName.contains("Dirt")) {
                DirtStorage += ItemCount;
            }
            else if (ItemName.contains("Terracotta")) {
                TerracottaStorage += ItemCount;
            }
        }

        Diamond.setDiamond(DiamondStorage);
        Diamond.checkQty();

        Gold.set(GoldStorage);
        Gold.checkQty();

        Iron.setIron(IronStorage);
        Iron.checkQty();

        Dirt.setDirt(DirtStorage);
        Dirt.checkQty();

        Terracotta.set(TerracottaStorage);
        Terracotta.checkQty();
    }

//    @SubscribeEvent
//    public void playerTick(TickEvent.PlayerTickEvent event) {
//
//        if (tickCounter % 350 == 0 && tickCounter < 1201) {
//            EntityPlayer player = event.player;
//
//            resetStorage();
//
//            for (int i = 0; i < 27; i++) {
//                String ItemName = player.inventory.getStackInSlot(i).getDisplayName();
//                int ItemCount = player.inventory.getStackInSlot(i).getCount();
//
//                System.out.println(ItemName);
//
//                if (ItemName.equals("Diamond")) {
//                    DiamondStorage += ItemCount;
//                }
//                else if (ItemName.equals("Gold Ingot")) {
//                    GoldStorage += ItemCount;
//                }
//                else if (ItemName.equals("Iron Ingot")) {
//                    IronStorage += ItemCount;
//                }
//                else if (ItemName.equals("Dirt")) {
//                    DirtStorage += ItemCount;
//                }
//                else if (ItemName.equals("Terracotta")) {
//                    TerracottaStorage += ItemCount;
//                }
//            }
//
//            Diamond.setDiamond(DiamondStorage);
//            Diamond.checkQty();
//
//            Gold.set(GoldStorage);
//            Gold.checkQty();
//
//            Iron.setIron(IronStorage);
//            Iron.checkQty();
//
//            Dirt.setDirt(DirtStorage);
//            Dirt.checkQty();
//
//            Terracotta.set(TerracottaStorage);
//            Terracotta.checkQty();
//
//        } else if (tickCounter > 1200) tickCounter = 0;
//        tickCounter++;
//
//    }
}