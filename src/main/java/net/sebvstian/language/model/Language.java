package net.sebvstian.language.model;

/**
 * functionality written by sebvstian.
 * Language > written on 12.01.2024
 */
public record Language(String name, String fileName) {

    /**
     * Returns the file name with a ".properties" extension if it doesn't already have one.
     *
     * @return the modified file name with a ".properties" extension
     */
    @Override
    public String fileName() {
        return (fileName.endsWith(".properties") ? fileName : fileName + ".properties");
    }
}
