package benkralex.minecraftutilplugin.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.PlayerArgument;

public class Commands {
    public static void createCommand() {
        new CommandAPICommand("util")
            .withSubcommand(new CommandAPICommand("fly")
                    .executesPlayer(((player, commandArguments) -> {Fly.flycommand(player, commandArguments);}))
                    .withPermission("util.fly"))
            .withSubcommand(new CommandAPICommand("freeze")
                    .executesPlayer(((player, commandArguments) -> {Freeze.freezecommand(player, commandArguments);}))
                    .withArguments(new PlayerArgument("Player")))
                .register();
    }
}
