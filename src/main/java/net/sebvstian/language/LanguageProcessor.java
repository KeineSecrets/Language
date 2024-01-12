package net.sebvstian.language;

import net.sebvstian.language.internal.Internal;
import net.sebvstian.language.model.Language;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * functionality written by sebvstian.
 * LanguageProcessor > written on 12.01.2024
 */
public class LanguageProcessor {

    private final Logger logger = Logger.getLogger("LangProcessor");
    private final Map<Language, Properties> languageMap = new HashMap<>();
    private String langPath = "src/main/resources/lang/";


    /**
     * Creates a new LanguageProcessor instance with a custom path.
     * @param langPath custom path where the lang files are located at.
     */
    public LanguageProcessor(String langPath) {
        this.langPath = (langPath.endsWith("/") ? langPath : langPath + "/");
    }


    /**
     * Creates a new LanguageProcessor instance with the default path.
     * The default path is {@link LanguageProcessor#langPath}
     */
    public LanguageProcessor() {}

    /**
     * Reads the file and stores the content in a cache.
     * To update message in real-time just call this function anytime.
     *
     * @param languages the languages to be loaded
     */
    public void initialize(Language... languages) {
        for (Language language : languages) {
            try {
                this.loadLanguage(language);
            } catch (IOException e) {
                logger.info("Error while trying to load language!");
            }
        }
    }

    /**
     * Reads the file and stores the content in a cache.
     * To update message in real-time just call this function anytime.
     *
     * @param language the language to be loaded
     */
    public void initialize(Language language) {
        try {
            this.loadLanguage(language);
        } catch (IOException e) {
            logger.info("Error while trying to load language!");
        }
    }

    /**
     * Loads a language into the system. This method is marked as {@link Internal}
     * and can be removed in the future without notice. Please use {@link #initialize(Language)} or {@link #initialize(Language...)} to initialize the language(s).
     *
     * @param language  the language to be loaded
     * @throws IOException  if there is an error reading the language file
     */
    @Internal
    private void loadLanguage(Language language) throws IOException {
        FileInputStream fileInputStream = null;
        Properties properties = new Properties();

        try {
            fileInputStream = new FileInputStream(langPath + language.fileName());
            properties.load(fileInputStream);
            languageMap.put(language, properties);
            logger.info("Language: " + language.name() + " was loaded!");
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * Retrieves the properties associated with a given language.
     *
     * @param  language  the language for which properties are retrieved
     * @return           the properties associated with the given language
     */
    public Properties getProperties(Language language) {
        return languageMap.get(language);
    }


}
