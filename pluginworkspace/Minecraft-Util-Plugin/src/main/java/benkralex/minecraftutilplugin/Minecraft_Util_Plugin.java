package benkralex.minecraftutilplugin;

import benkralex.minecraftutilplugin.api.UtilPlugin;
import benkralex.minecraftutilplugin.api.format.Format;
import benkralex.minecraftutilplugin.api.register.PluginRegister;
import benkralex.minecraftutilplugin.config.ConfigFormat;
import benkralex.minecraftutilplugin.config.ConfigUtils;
import benkralex.minecraftutilplugin.listeners.InventoryInteractListener;
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
        for (Plugin p:Bukkit.getPluginManager().getPlugins()) {
            if (p instanceof UtilPlugin) {
                UtilPlugin utilPlugin = (UtilPlugin)p;
                utilPlugin.register(register);
            }
        }
        Bukkit.getPluginManager().registerEvents(new InventoryInteractListener(), this);
        ConfigUtils.createConfig();
        ConfigFormat.createConfig(register);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void register(PluginRegister register) {
        register.registerFormat(CHAT_FORMAT, "%n: %m");
        register.registerFormat(MSG_FORMAT, "§f%from $9-> $f%to: §7%m");
    }
}
