# Language System

A simple language system for your projects.
## Getting Started

### Prerequisites

- Made with JDK 21 so i prefer that


## Usage

1. **Create an Instance of the `LanguageProcessor`:**

    ```java
    LanguageProcessor languageProcessor = new LanguageProcessor();
    ```

2. **Initialize Desired Languages:**

    ```java
    Language DE = new Language("Deutsch", "german.properties");
    Language EN = new Language("English", "english.properties");

    languageProcessor.initialize(DE);
    languageProcessor.initialize(EN);
    ```

3. **Create a `LanguageManager` and Pass the `LanguageProcessor`:**

    ```java
    LanguageManager languageManager = new LanguageManager(languageProcessor);
    ```

4. **Translate Messages using the `LanguageManager`:**

    ```java
    String greeting = languageManager.translate(DE, "test.plugin.hello");
    System.out.println(greeting);
    ```

   Include dynamic content in translations:

    ```java
    String infoDE = languageManager.translate(DE, "test.plugin.info", new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()));
    System.out.println(infoDE);

    String infoEN = languageManager.translate(EN, "test.plugin.info", new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()));
    System.out.println(infoEN);
    ```
