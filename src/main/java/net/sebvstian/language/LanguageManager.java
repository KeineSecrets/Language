package net.sebvstian.language;

import java.util.Properties;

/**
 * functionality written by sebvstian.
 * LanguageManager > written on 12.01.2024
 */
public class LanguageManager {

    private Language language;
    private final LanguageProcessor languageProcessor;

    public LanguageManager(LanguageProcessor languageProcessor, Language language) {
        this.languageProcessor = languageProcessor;
        this.language = language;
    }

    public LanguageManager(LanguageProcessor languageProcessor) {
        this.languageProcessor = languageProcessor;

    }

    public String translate(String keyword) {
        Properties properties = languageProcessor.getProperties(language);
        var key = properties.getProperty(keyword);
        if(key == null) {
            return keyword;
        }
        return key.replaceAll("\"", "");
    }

    public String translate(String keyword, Object... arguments) {
        Properties properties = languageProcessor.getProperties(language);
        var key = properties.getProperty(keyword);
        if(key == null) {
            return keyword;
        }
        return String.format(key.replaceAll("\"", ""), arguments);
    }

    public String translate(Language language, String keyword) {
        Properties properties = languageProcessor.getProperties(language);
        var key = properties.getProperty(keyword);
        if(key == null) {
            return keyword;
        }
        return key.replaceAll("\"", "");
    }

    public String translate(Language language, String keyword, Object... arguments) {
        Properties properties = languageProcessor.getProperties(language);
        var key = properties.getProperty(keyword);
        if(key == null) {
            return keyword;
        }
        return String.format(key.replaceAll("\"", ""), arguments);
    }
}
