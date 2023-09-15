package benkralex.minecraftutilplugin.api;

import benkralex.minecraftutilplugin.api.register.PluginRegister;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class UtilPlugin extends JavaPlugin{
    public abstract void register(PluginRegister register);
}
