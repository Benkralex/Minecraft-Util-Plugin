package benkralex.minecraftutilplugin;

import benkralex.minecraftutilplugin.api.UtilPlugin;
import benkralex.minecraftutilplugin.api.format.Format;
import benkralex.minecraftutilplugin.api.register.PluginRegister;
import benkralex.minecraftutilplugin.commands.Commands;
import benkralex.minecraftutilplugin.config.ConfigFormat;
import benkralex.minecraftutilplugin.config.ConfigUtils;
import benkralex.minecraftutilplugin.listeners.ChatFormatListener;
import benkralex.minecraftutilplugin.listeners.InventoryInteractListener;
import benkralex.minecraftutilplugin.listeners.MoveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;

public final class Minecraft_Util_Plugin extends UtilPlugin {
    public static final Format CHAT_FORMAT = Format.getFormat("chat");
    public static final Format MSG_FORMAT = Format.getFormat("msg");

    public static File mainFolder;
    public static Minecraft_Util_Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        mainFolder = this.getDataFolder();
        PluginRegister register = new PluginRegister();
        for (Plugin plugin:Bukkit.getPluginManager().getPlugins()) {
            if (plugin instanceof UtilPlugin) {
                UtilPlugin utilPlugin = (UtilPlugin) plugin;
                utilPlugin.register(register);
            }
        }
        Bukkit.getPluginManager().registerEvents(new InventoryInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new MoveListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatFormatListener(), this);
        ConfigUtils.createConfig();
        ConfigFormat.createConfig(register);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void onLoad() {
        Commands.createCommand();
    }

    @Override
    public void register(PluginRegister register) {
        register.registerFormat(CHAT_FORMAT, "%n: %m");
        register.registerFormat(MSG_FORMAT, "§f%from $9-> $f%to: §7%m");
    }
}
