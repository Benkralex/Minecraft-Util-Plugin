package benkralex.minecraftutilplugin.commands;

import dev.jorel.commandapi.CommandAPICommand;

public class Commands {
    public static void createCommand() {
        new CommandAPICommand("util")
            .withSubcommand(new CommandAPICommand("fly")
                    .executesPlayer(((player, commandArguments) -> {Fly.flycommand(player, commandArguments);}))
                    .withPermission("util.fly"))
                .register();
    }
}
