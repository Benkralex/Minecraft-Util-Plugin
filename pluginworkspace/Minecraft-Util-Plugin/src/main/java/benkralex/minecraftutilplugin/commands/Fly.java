package benkralex.minecraftutilplugin.commands;

import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.entity.Player;

public class Fly {
    public static void flycommand(Player p, CommandArguments args) {
        p.setAllowFlight(!p.getAllowFlight());
    }
}
