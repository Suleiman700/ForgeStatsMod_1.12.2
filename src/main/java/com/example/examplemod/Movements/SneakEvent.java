package com.example.examplemod.Movements;

import com.example.examplemod.db.Database;

public class SneakEvent {
    public static int count = 0;
    private static boolean isSneaking = false;
    private static boolean enableCheck = true;
    private static boolean storeInDB = true; // Store count in DB
    private static boolean storeLiveState = false; // Store live state in DB

    public static void storeSneaking(boolean sneakState) {
        if (enableCheck) {
            // If holding shift & not sneaked
            if (sneakState && !isSneaking) {
                isSneaking = true;
                count++;
            }
            else if (!sneakState) {
                isSneaking = false;
            }

            // Store stats
            if (storeInDB) {
                Database.UpdateSneak(count);
            }

            // Save sneak live state
            if (storeLiveState) {
                Database.SaveSneakLiveState(sneakState);
            }
        }
    }

    // Reset sneaking counter
    public static void resetCount() {
        count = 0;
    }


}
