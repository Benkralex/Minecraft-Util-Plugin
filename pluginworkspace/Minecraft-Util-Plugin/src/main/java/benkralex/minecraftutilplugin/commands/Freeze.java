package benkralex.minecraftutilplugin.commands;

import benkralex.minecraftutilplugin.Minecraft_Util_Plugin;
import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Freeze {
    public static void freezecommand(Player p, CommandArguments args) {
        Player target = (Player) args.get("Player");
        PersistentDataContainer pdctarget = target.getPersistentDataContainer();
        if (!pdctarget.has(new NamespacedKey(Minecraft_Util_Plugin.plugin, "freezed"), PersistentDataType.BOOLEAN)) {
            pdctarget.set(new NamespacedKey(Minecraft_Util_Plugin.plugin, "freezed"), PersistentDataType.BOOLEAN, true);
            p.sendMessage(target.getDisplayName() + " wurde eingefroren");
            target.sendMessage("Du wurdest von " + p.getDisplayName() + " eingefroren");
        } else {
            pdctarget.set(new NamespacedKey(Minecraft_Util_Plugin.plugin, "freezed"), PersistentDataType.BOOLEAN, !pdctarget.get(new NamespacedKey(Minecraft_Util_Plugin.plugin, "freezed"), PersistentDataType.BOOLEAN));
            p.sendMessage(target.getDisplayName() + " wurde " + (pdctarget.get(new NamespacedKey(Minecraft_Util_Plugin.plugin, "freezed"), PersistentDataType.BOOLEAN)?"eingefroren":"aufgetaut"));

            target.sendMessage("Du wurdest von " + p.getDisplayName() +  (pdctarget.get(new NamespacedKey(Minecraft_Util_Plugin.plugin, "freezed"), PersistentDataType.BOOLEAN)?" eingefroren":" aufgetaut"));
        }
    }
}
