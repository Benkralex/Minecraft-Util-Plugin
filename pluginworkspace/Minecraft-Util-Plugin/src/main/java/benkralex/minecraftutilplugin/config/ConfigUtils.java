package benkralex.minecraftutilplugin.config;

import benkralex.minecraftutilplugin.Minecraft_Util_Plugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigUtils {
    public static FileConfiguration configUtils = YamlConfiguration.loadConfiguration(new File(Minecraft_Util_Plugin.mainFolder, ""));

    public static void createConfig() {
        configUtils.options().copyDefaults(true);
        configUtils.addDefault("format.chat", true);
        configUtils.addDefault("format.msg", true);
        configUtils.addDefault("invopen.workbench", true);
        configUtils.addDefault("invopen.enderchest", true);
        configUtils.addDefault("invopen.shulkerbox", true);
    }

    public static boolean getFormatChat() {
        if (configUtils.get("format.chat") == null) {
            return false;
        }
        return configUtils.getBoolean("format.chat");
    }

    public static boolean getFormatMSG() {
        if (configUtils.get("format.msg") == null) {
            return false;
        }
        return configUtils.getBoolean("format.msg");
    }
    public static boolean getInvopenWorkbench() {
        if (configUtils.get("invopen.workbench") == null) {
            return false;
        }
        return configUtils.getBoolean("invopen.workbench");
    }
    public static boolean getInvopenEnderchest() {
        if (configUtils.get("invopen.enderchest") == null) {
            return false;
        }
        return configUtils.getBoolean("invopen.enderchest");
    }
    public static boolean getInvopenShulkerbox() {
        if (configUtils.get("invopen.shulkerbox") == null) {
            return false;
        }
        return configUtils.getBoolean("invopen.shulkerbox");
    }
}

