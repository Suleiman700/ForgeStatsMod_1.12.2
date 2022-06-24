package com.example.examplemod.Outliner;

import com.example.examplemod.chat.Chat;

public class Controller_Outliner {

    public static boolean GlobalOutliner_Enabled = false;

    public static void toggleState() {
        if (GlobalOutliner_Enabled) {
            GlobalOutliner_Enabled = false;
        } else {
            GlobalOutliner_Enabled = true;
        }

        Items_Outliner.setState(GlobalOutliner_Enabled);
        Players_Outliner.setState(GlobalOutliner_Enabled);
        Arrows_Outliner.setState(GlobalOutliner_Enabled);
        Blocks_Outliner.setState(GlobalOutliner_Enabled);
    }

    public static void UpdateOutliner() {
        Items_Outliner.setState(GlobalOutliner_Enabled);
        Players_Outliner.setState(GlobalOutliner_Enabled);
        Arrows_Outliner.setState(GlobalOutliner_Enabled);
        Blocks_Outliner.setState(GlobalOutliner_Enabled);
    }
}
