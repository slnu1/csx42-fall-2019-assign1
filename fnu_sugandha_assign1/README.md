# CSX42: Assignment 1
## Name: Fnu Sugandha

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile coursesRegistration/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile coursesRegistration/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0="student_coursePrefs.txt" -Darg1="courseInfo.txt" -Darg2="registration_results.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:


Justification for choice of data structures:
Data structure used is ArrayList. Simple array based data structure is used considering the complexity level of problem.ArrayList are re-sizable array and we dont know the number
of students or courses before hand so its better to use dynamic arrays.It also has multiple methods to modify stored objects.

input file location:

fnu_sugandha_assign1\coursesRegistration

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 09.19.2019


