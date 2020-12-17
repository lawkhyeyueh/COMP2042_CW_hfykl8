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
-	**Rearranging Packages:** When the code was first downloaded, all the classes were located in the same directory so it was unorganized and made it hard to work with. The classes were then separated into different packages based on their categories which made it easier to work on and enhance maintainability. 


## 2. Features


## 3. Bug Fixes
- Before the score will not deduct when it is lower than 50. The original author added an if condition to prevent error. The bug has been fixed and the marks will be equal to 0 if the marks is lower than 50. 
-	The frog can jump into the platform even though the platform is occupied by another frog. The bug is fixed so that the frog is no longer allowed into the platform if it's occupied by another frog. 
- At first, background image was not shown in the game scene. After fixing it, the image is displayed:
- Frog is now not allowed to jump to outside of the scene after the fix whereas it was possible before.	


## 4. JUnit Test
- JUnit 4 has been added into the project and 6 tests have been performed to show my understanding on JUnit. 
- Junit tests were successful without any errors.


## 5. Version Control 
- GitHub is used as the remote repository for this project and has been used frequently for this project
- Dev branch was created at the start of the project and it is merged into the master branch after testing to assure it has no issue after the merging.
- Every commits have been given meaningful comments.


## 6. Program Improvements


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
