package benkralex.minecraftutilplugin.api.register;

import benkralex.minecraftutilplugin.api.format.Format;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PluginRegister {
    Map<Format, String> registeredFormats = new HashMap<>();
    public void registerFormat(Format format, String defaultFormat) {
        registeredFormats.put(format, defaultFormat);
    }
    
    public Set<Map.Entry<Format, String>> getRegisteredFormats() {
        return registeredFormats.entrySet();
    }
}
