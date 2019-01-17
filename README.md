# MazeProjectJava

This program creates a maze from an input file.  The input file contains information needed to specify the number of rows and columns the maze will have, the starting point, the finish or goal point, and where the maze walls will be. 

The maze is generated as an array list of maze square objects.  Each maze square is displayed as a three by three, two dimensional array of characters, simplified into an array of three string objects, each having three characters. An open maze square is made up of '.' characters, wall maze squares of 'X' characters, the start square of '.' characters with the exception of the middle character being 'S', and the final or goal maze square the same as the start with 'F' at in the center. 

The maze is initially constructed with all indexes as open maze square objects. The input file contains indexes in two dimensional array format. As the values are read in, the two dimensional format is recalculated to its array list equivalent. The maze square object at that index is replaced with either the start, finish, or wall type square object. The maze is completed after traversing to the end of the input file.

After the maze is generated it is passed as a parameter of the MazeSolver class constructor. MazeSolver class will find the start maze square objects and set its index as the starting point.  From the starting point the program will attempt to solve the maze by checking the surrounding indexes in the order of down, right, up, left. The current position in the maze will be displayed by changing the maze square type to the current position maze square object.  Current position is displayed as "O" characters. Each maze square visited is also changed to a path type maze object displayed as " " for each character. If the program has to backtrack, the maze square objects that are backtracked are changed to backtrack type maze objects displayed as "B" character. 

At each step the program checks to see if the neighboring object is open, then if the maze object is the finish or goal maze square object. If it is open the current position is changed to that open objects position. If that object is the finish or goal, the program ends, displaying the path from start to finish.

## Getting Started

The following two sections will assist you in downloading and running this program. 

### Prerequisites

In order to run this program you will need the Java Development Kit (JDK) and an integrated development environment (IDE). The following programs were used in the development of this program:

* [Oracle JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [IntelliJ](https://www.jetbrains.com/idea/)

You can also use one of the following IDE's:
* [Eclipse](https://www.eclipse.org/ide/)
* [NetBeans](https://netbeans.org/)

### Installing

Will update this section later

## Authors

* **Christopher Finster** - [Finsternavy](https://github.com/Finsternavy)
