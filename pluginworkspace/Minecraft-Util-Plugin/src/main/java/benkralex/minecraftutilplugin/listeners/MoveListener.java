package benkralex.minecraftutilplugin.listeners;

import benkralex.minecraftutilplugin.Minecraft_Util_Plugin;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.persistence.PersistentDataType;

public class MoveListener implements Listener {
    public static void onMove(PlayerMoveEvent e) {
        if (e.getPlayer().getPersistentDataContainer().getOrDefault(new NamespacedKey(Minecraft_Util_Plugin.plugin, "freezed"), PersistentDataType.BOOLEAN, false)) {
            e.setCancelled(true);
        }
    }
}
