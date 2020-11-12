@echo off

rem   Compile the application code [*not* the test code].
rem   In this example, any third-party library JARs are located in 'lib' and added to the classpath [-classpath option].
rem   Remove this -classpath "lib\*" if you're not using any.
javac -d classes -classpath "lib\*" src\com\analyzer\client\*.java src\com\analyzer\helper\*.java src\com\analyzer\io\*.java src\com\analyzer\model\*.java src\com\analyzer\sniffer\*.java


rem   Build the application JAR.
rem   This example adds the directory tree of .class files starting at 'classes'.
jar --create --file linkedin-analyzer.jar -C classes .


rem   Create the Javadoc.
rem   The '-package' flag will include non-public classes and all class members except for private ones.
rem   Again, any third-party library JARs are located in 'lib' and added to the classpath.
rem   And again, remove this -classpath "lib\*" if you're not using any.

rem   Running this only makes sense if you've taken the time to write API comments in your code.
rem   API (javadoc) comments are important when the "product" is a library for other developers to use.
rem   It's not as important when the "product" is a finished application, like with your project.
rem   Just leave this commented out if not using.

rem   javadoc -d doc --source-path src -classpath "lib\*" -package -windowtitle Hangman com.games.hangman.client com.games.hangman.controller com.games.hangman.core