
<h2>Getting Started to use Language by sebvstian</h2>

<p>First implement the latest version to your project. <br> Maven, Gradle or just the jar from the releases.</p>
<hr>
First You'll need the LanguageProcessor that reads the files.<br>

Create an instance of the processor:<br>
The default path where your files should be when using no path parameter is - "src/main/resources/lang/"

   ````java
   LanguageProcessor languageProcessor=new LanguageProcessor();
   ````


Or use a custom path where u want your files to be:<br>

   ````java
   LanguageProcessor languageProcessor=new LanguageProcessor("src/main/resources/languages/");
   ````

<hr>

<h3>Initialize your languages:</h3>
<p>The first argument is the name, that is just for working. <br> The second argument is the file-name! That is very important.</p>

````java
Language de_DE = new Language("German", "german.properties");
Language en_US = new Language("English", "english.properties");
````
<p>So the following path would be "src/main/resources/lang/german.properties"</p>

<p>The next step is to let the processor know what languages he needs to process.</p>

````java
languageProcessor.initialize(de_DE);
languageProcessor.initialize(en_US);
````
<hr>

<h3>Now the languages are fully stored / cached.</h3>


<p>Create an instance of the manager:</p>

````java
LanguageManager languageManager = new LanguageManager(languageProcessor);
````
This way you need to use languageManager#translate(Language, String)<br>
Because the language is not defined in the instance and would be null!<br>
But you can also define the language directly at the instance using:

````java
LanguageManager languageManager = new LanguageManager(languageProcessor, de_DE);
````
This way you can easily use languageManager#translate(String)

You can also add another parameter for the arguments. If you are going to use variables in the properties file.<br>
````properties
test.plugin.info="Look at this cool Animal! -> %s" 
````
Thats the same syntax as when using String#format
````java
languageManager.translate("test.plugin.info", "Cow");
````
Or if you didnt define the language at the instance:<br>
You can define it directly when using languageManager#translate as the first parameter
````java
languageManager.translate(de_DE, "test.plugin.info", "Cow");
````

<hr>

<h4>If you want to update the language files in "real-time" just use the processor to initialize the language again!</h4>

<hr>

<h3>Thats how the properties files should look like</h3>
<p>You can define everything by yourself, the keys and the values!</p>

````properties
# english.properties
test.plugin.hello="Hello World!"
test.plugin.info="Look at this cool Animal! -> %s"
````
<a href="https://docs.oracle.com/cd/E23095_01/Platform.93/ATGProgGuide/html/s0204propertiesfileformat01.html">Click here to view the oracle docs for Properties File Format</a>

<h3>Rights & Info</h3>
<p>
Feel free to use this for any project u want!<br>
I assume no liability for projects that violate anything and use my library!<br>
Credits are welcome but not a must ;-)
</p>



   
