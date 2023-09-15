package benkralex.minecraftutilplugin.config;

import benkralex.minecraftutilplugin.Minecraft_Util_Plugin;
import benkralex.minecraftutilplugin.api.format.Format;
import benkralex.minecraftutilplugin.api.register.PluginRegister;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Map;

public class ConfigFormat {

    public static FileConfiguration configFormat = YamlConfiguration.loadConfiguration(new File(Minecraft_Util_Plugin.mainFolder, ""));
    public static void createConfig(PluginRegister register) {
        configFormat.options().copyDefaults(true);
        /*configFormat.addDefault("format.chat", "%n: %m");
        configFormat.addDefault("format.msg", "%n: %m");*/
        for (Map.Entry<Format, String> entry:register.getRegisteredFormats()) {
            configFormat.addDefault("format." + entry.getKey().getName(), entry.getValue());
        }
    }

    public static String getFormat(Format format) {
        return configFormat.getString("format." + format.getName());
    }

    /*
    public static FileConfiguration configFormat = YamlConfiguration.loadConfiguration(new File(Minecraft_Util_Plugin.mainFolder, ""));
    public static void createConfig(PluginRegister register) {
        configFormat.options().copyDefaults(true);
        configFormat.addDefault("format.chat", "%n: %m");
        configFormat.addDefault("format.msg", "Von %from -> %to: %m");
    }

    public static String getChatFormat() {
        return configFormat.getString("format.chat");
    }

    public static String getMSGFormat() {
        return configFormat.getString("format.msg");
    }
     */
}
