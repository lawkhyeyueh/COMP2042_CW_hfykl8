# Frogger (Software Maintenance)
- Frogger is a game remake based on the 1981 arcade game by the same name and it is coded with Java
- This coursework is done by Law Khye Yueh, Student ID 20129374. 
- The Frogger project is properly maintained and divided into a few parts.


### Table Of Contents:
1. Basic Code Maintainability 
2. Features
3. Bug Fixes
4. JUnit Test
5. Version Control
6. Program Improvements
7. IDE and JAVA Versions
8. Build Status
9. Credits
10. License
11. User Guide Game Launch


## 1. Basic Code Maintainability 
-	**Refactoring:** The original code was not encapsulated meaning it has violated object-oriented key principles whch is why all the code has been encapsulated. Encapsulation is done by adding private visibility to every variable so that it is only accessible between the class. 
-	**Javadocs:** Javadoc is needed to make the code easier to understand for any developers who view this code base. Javadoc is generated and comments are added to every methods in every classes.
-	**MVC Pattern:** MVC is created by spliting main classes into three parts: Model, View and Controller. Benefits are ease of modification and low coupling. 
-	**Rearranging Packages:** When the code was first downloaded, all the classes were located in the same directory so it was unorganized and made it hard to work with. The classes were then separated into different packages based on their categories which made it easier to work on.


## 7. IDE and JAVA Versions
[Eclipse IDE 2020-09](https://www.eclipse.org/downloads/)
<br />
[Java(TM) SE Runtime Environment (build 14.0.2)](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)


## 8. Build Status 
Ant build file is added and built successfully.


## 9. Credits
This game is improved and extended from https://github.com/hirish99/Frogger-Arcade-Game


## 10. License 
This game is copyright FREE.


## 11. User Guide Game Launch
**YOU MUST HAVE DOWNLOADED ECLIPSE IDE AND JAVAFX TO YOUR DESKTOP BEFORE FOLLOWING THESE INSTRUCTIONS!**
1. Download the whole ZIP file from GitHub onto your desktop. 
2. Save your ZIP file into a new folder and right-click select Extract Here.
3. Import the project into Eclipse IDE. 
4. Select TryFrog1 file folder then click Finish.
5. Click the Run drop down menu and click Run Configurations. 
6. Put in --module-path "C:\Users\lawkh\Downloads\javafx-sdk-11.0.2\lib" --add-modules=ALL-MODULE-PATH in VM arguments. 
7. Game is good to go.
