package net.sebvstian.language;

import net.sebvstian.language.model.Language;

import java.util.Properties;

/**
 * functionality written by sebvstian.
 * LanguageManager > written on 12.01.2024
 */
public class LanguageManager {

    private Language language;
    private final LanguageProcessor languageProcessor;

    /**
     * Creates a new LanguageManager instance.
     * @param languageProcessor the LanguageProcessor instance
     * @param language the Language instance
     */
    public LanguageManager(LanguageProcessor languageProcessor, Language language) {
        this.languageProcessor = languageProcessor;
        this.language = language;
    }

    /**
     * Creates a new LanguageManager instance.
     * @param languageProcessor the LanguageProcessor instance
     */
    public LanguageManager(LanguageProcessor languageProcessor) {
        this.languageProcessor = languageProcessor;

    }

    /**
     * Translates the given keyword into the corresponding value in the language properties.
     *
     * @param  keyword  the keyword to be translated
     * @return          the translated value of the keyword, or the keyword itself if no translation is found
     */
    public String translate(String keyword) {
        Properties properties = languageProcessor.getProperties(language);
        var key = properties.getProperty(keyword);
        if(key == null) {
            return keyword;
        }
        return key.replaceAll("\"", "");
    }

    /**
     * Translates a keyword using the language processor.
     *
     * @param  keyword    the keyword to be translated
     * @param  arguments  the arguments to be used in the translation
     * @return            the translated string
     */
    public String translate(String keyword, Object... arguments) {
        Properties properties = languageProcessor.getProperties(language);
        var key = properties.getProperty(keyword);
        if(key == null) {
            return keyword;
        }
        return String.format(key.replaceAll("\"", ""), arguments);
    }

    /**
     * Translates the given keyword into the specified language.
     *
     * @param  language  the language to translate into
     * @param  keyword   the keyword to be translated
     * @return           the translated keyword, or the original keyword if no translation is available
     */
    public String translate(Language language, String keyword) {
        Properties properties = languageProcessor.getProperties(language);
        var key = properties.getProperty(keyword);
        if(key == null) {
            return keyword;
        }
        return key.replaceAll("\"", "");
    }

    /**
     * Translates a keyword from a specified language into a string using the provided arguments.
     *
     * @param  language   the language to translate from
     * @param  keyword    the keyword to be translated
     * @param  arguments  the arguments to be used in the translation
     * @return            the translated string
     */
    public String translate(Language language, String keyword, Object... arguments) {
        Properties properties = languageProcessor.getProperties(language);
        var key = properties.getProperty(keyword);
        if(key == null) {
            return keyword;
        }
        return String.format(key.replaceAll("\"", ""), arguments);
    }
}
