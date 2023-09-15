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
    }

    public static boolean getFormatChat() {
        if (configUtils.get("format.chat") == null) {
            return true;
        }
        return configUtils.getBoolean("format.chat");
    }

    public static boolean getFormatMSG() {
        if (configUtils.get("format.msg") == null) {
            return true;
        }
        return configUtils.getBoolean("format.msg");
    }
}
