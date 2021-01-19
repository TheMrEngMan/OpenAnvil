package com.MrEngMan.OpenAnvil.util;

import com.MrEngMan.OpenAnvil.OpenAnvil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Utils {

    // Translate '&' as formatting codes
    public static String SendChatMessage(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    // Print debug messages only if enabled
    public static void debugPrint(String msg) {
        if(OpenAnvil.getPlugin().isDebugEnabled()) {
            Bukkit.getLogger().info("[OpenAnvil] " + msg);
        }
    }

}

