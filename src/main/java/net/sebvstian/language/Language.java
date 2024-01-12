package net.sebvstian.language;

/**
 * functionality written by sebvstian.
 * Language > written on 12.01.2024
 */
public class Language {

    /**
     * Example: "Deutsch"
     */
    private final String name;
    /**
     * Example: "de_DE.properties"
     */
    private final String fileName;

    public Language(final String name, final String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    public String getFileName() {
        return (fileName.endsWith(".properties") ? fileName : fileName + ".properties");
    }

    public String getName() {
        return name;
    }
}
