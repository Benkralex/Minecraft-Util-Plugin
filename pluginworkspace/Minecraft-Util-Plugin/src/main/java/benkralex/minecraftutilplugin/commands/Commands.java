package benkralex.minecraftutilplugin.commands;

import dev.jorel.commandapi.CommandAPICommand;

public class Commands {
    public static void createCommand() {
        new CommandAPICommand("util").register();
    }
}
