package net.sebvstian.language;

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
     *
     * @param langPath custom path where the lang files are located at.
     */
    public LanguageProcessor(String langPath) {
        this.langPath = (langPath.endsWith("/") ? langPath : langPath + "/");
    }


    /**
     * No path. Default = "src/main/resources/lang/langFileName.properties"
     */
    public LanguageProcessor() {}

    /**
     * Reads the file and stores the content in a cache.
     * To update message in real-time just call this function anytime.
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
     */
    public void initialize(Language language) {
        try {
            this.loadLanguage(language);
        } catch (IOException e) {
            logger.info("Error while trying to load language!");
        }
    }


    private void loadLanguage(Language language) throws IOException {
        FileInputStream fileInputStream = null;
        Properties properties = new Properties();

        try {
            fileInputStream = new FileInputStream(langPath + language.getFileName());
            properties.load(fileInputStream);
            languageMap.put(language, properties);
            logger.info("Language: " + language.getName() + " was loaded!");
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

    public Properties getProperties(Language language) {
        return languageMap.get(language);
    }


}
