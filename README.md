# Language System

<ul>
A language system for your projects.<br>
Create .properties files with keys and values.<br>
Translate them easily w/ arguments like<br>
%s: String<br>
%d: Decimal (integer)<br>
%f: Floating-point<br>
%c: Character<br>
%b: Boolean<br>
</ul>

## Getting Started


1. **Create an Instance of the `LanguageProcessor`:**

    ```java
    LanguageProcessor languageProcessor = new LanguageProcessor();
    ```

   <p>Or use a custom path to your .properties files</p>

    ```java
   LanguageProcessor languageProcessor = new LanguageProcessor("src/main/resources/german.properties");
    ```
   
   <hr>

2. **Initialize Desired Languages:**

    ```java
    Language de_DE = new Language("Deutsch", "german.properties");
    Language en_US = new Language("English", "english.properties");

    languageProcessor.initialize(de_DE);
    languageProcessor.initialize(en_US);
    ```

<hr>

3. **Create a `LanguageManager` and Pass the `LanguageProcessor`:**

    ```java
    LanguageManager languageManager = new LanguageManager(languageProcessor);
    ```

<hr>

4. **Translate Messages using the `LanguageManager`:**

    ```java
    String greeting = languageManager.translate(de_DE, "test.plugin.hello");
    System.out.println(greeting);
    ```

   Include dynamic content in translations:

    ```java
    String infoDE = languageManager.translate(de_DE, "test.plugin.info", new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()));
    System.out.println(infoDE);

    String infoEN = languageManager.translate(en_US, "test.plugin.info", new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()));
    System.out.println(infoEN);
    ```

<hr>

5. **How the .properties file should look like**
   ```properties
   # german.properties
   test.plugin.hello="Hallo Welt!"
   test.plugin.info="Aktuelle Uhrzeit beträgt %s"
   ```

   ```properties
   # english.properties
   test.plugin.hello="Hello World!"
   test.plugin.info="The current time is %s"
   ```
