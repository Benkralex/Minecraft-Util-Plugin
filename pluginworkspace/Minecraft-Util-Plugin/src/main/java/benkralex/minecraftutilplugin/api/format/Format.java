package benkralex.minecraftutilplugin.api.format;

import java.util.Objects;

public class Format {
    String name;
    private Format(String name) {
        this.name = name;
    }

    public static Format getFormat(String name) {
        return new Format(name);
    }

    

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
