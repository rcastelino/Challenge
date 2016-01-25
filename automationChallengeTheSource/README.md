=======================================
Project - automationChallengeTheSource
=======================================

[] To Get this project running on an OSX machine, install the following:
- java jdk
- maven
- IntelliJ IDE (community edition)
- FireFox browser

[] After installation:
- launch IntelliJ IDE
- select 'File -> Open'
- select the 'pom.xml' file of this project.'

[] To execute the test:
-> From IntelliJ IDE
    - from 'Project' panel, expand the 'tests' package
    - right click on the junit test class Eg. 'Web_xxx_xxx', and select 'Run'

-> From maven command
    - Launch Terminal
    - cd to the project folder
    - execute the test command as --> mvn test -Dtest='Web_xxx_xxx'
