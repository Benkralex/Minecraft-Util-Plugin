package benkralex.minecraftutilplugin.listeners;

import benkralex.minecraftutilplugin.Minecraft_Util_Plugin;
import benkralex.minecraftutilplugin.config.ConfigFormat;
import benkralex.minecraftutilplugin.config.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatListener implements Listener {
    @EventHandler
    public void onChatMessage(AsyncPlayerChatEvent event) {
        if (ConfigUtils.getFormatChat()) {
            event.setCancelled(true);
            String chatformat = ConfigFormat.getFormat(Minecraft_Util_Plugin.CHAT_FORMAT);
            String message = chatformat.replace("%n", event.getPlayer().getDisplayName()).replace("%m", event.getMessage());
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('§', message));
        }
    }
}
