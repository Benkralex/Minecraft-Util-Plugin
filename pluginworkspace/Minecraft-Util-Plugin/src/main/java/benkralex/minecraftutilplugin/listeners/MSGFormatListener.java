package benkralex.minecraftutilplugin.listeners;

import benkralex.minecraftutilplugin.Minecraft_Util_Plugin;
import benkralex.minecraftutilplugin.config.ConfigFormat;
import benkralex.minecraftutilplugin.config.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class MSGFormatListener implements Listener {
    @EventHandler
    public void onMSGMessage(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().startsWith("msg")||event.getMessage().startsWith("w")||event.getMessage().startsWith("whisper")) {
            if (ConfigUtils.getFormatMSG()) {
                String msgformat = ConfigFormat.getFormat(Minecraft_Util_Plugin.MSG_FORMAT);

                String[] command = event.getMessage().split(" ");
                if(command.length < 3) return;

                Player msgtoplayer = Bukkit.getPlayer(command[1]);
                if(msgtoplayer == null) return;

                String commandmessage="";
                for (int i=2; i<command.length;i++){
                    commandmessage= commandmessage+command[i];
                }
                String message = msgformat.replace("%from", event.getPlayer().getDisplayName()).replace("%m", commandmessage).replace("%to", msgtoplayer.getDisplayName());
                msgtoplayer.sendMessage(ChatColor.translateAlternateColorCodes('§', message));
                event.setCancelled(true);
            }
        }
    }
}
