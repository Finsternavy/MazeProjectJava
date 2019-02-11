import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main (String[] args) throws IOException {

        //hold the value of rows to be passed to mazeGenerator
        int rows;
        //hold the value of columns to be passed to mazeGenerator
        int columns;

        //Associate read in file to inputFile
        File inputFile = new File ("C:\\Users\\Finst\\IdeaProjects\\MazeInJava\\src\\MazeInput");
        //Read in the contents of inputFile to be passed during maze generation and replace maze squares with appropriate types
        Scanner scan = new Scanner (inputFile);

        //Assigns rows to the first integer read in from inputFile
        rows = scan.nextInt();
        //Assigns columns to the second integer read in from inputFile
        columns = scan.nextInt();

        //Create maze object, passing in values assigned to rows and columns from inputFile
        Maze myMaze = new Maze(rows, columns);

        //Reads in the next 2 integers and formats from single array to 2D array
        int start = (scan.nextInt() * columns) + scan.nextInt();

        //Replace start index read in from input file with maze square type "START": See MazeSquare.java
        myMaze.maze.get(start).setSquareType(MazeSquare.squareType.START);

        //Reads in the next 2 integers and formats to 2D array.
        int finish = (scan.nextInt() * columns) + scan.nextInt();

        //Replace start index read in from input file with maze square type "FINISH": See MazeSquare.java
        myMaze.maze.get(finish).setSquareType(MazeSquare.squareType.FINISH);

        //Place holder for index to be changed to type "WALL" as the rest of inputFile is read in
        int indexToChange;

        //Reads in integers until no integers are found and end of document is reached
        while (scan.hasNextInt()){

            //Reads in next integer and reformats to proper row index based on starting column size
            int x = scan.nextInt() * columns;
            //Reads in next integer and reformats to proper column index
            int y = scan.nextInt();

            //Reformats 2D index to single index array format
            indexToChange = x + y;
            //Replace mazeSquare with type "WALL" for each index read in
            myMaze.maze.get(indexToChange).setSquareType(MazeSquare.squareType.WALL);

        }

        // if index from file is (3, 8) first num (row) * (columns in maze), + second num (column) = intended index for maze list.
        // Example: Num of columns in maze is 10, num rows is 10:
        // index from file is (3, 8). 3 * 10 = 30. 30 + 8 = 38.  The 38th element in maze is printed at index 3, 8.

        //Creates MazeSolver object, passing in the maze to be solved.
      //  MazeSolver solveMaze = new MazeSolver(myMaze);
       // MazeSolverQueue solveMazeQueue = new MazeSolverQueue(myMaze);
       // MazeSolverHeap solveMazeHeap = new MazeSolverHeap(myMaze);
        MazeSolverDFS solveMazeDFS = new MazeSolverDFS(myMaze);

        //System.out.println(myMaze.maze.get(10).index + "\n"  + myMaze.maze.get(10).nextRight + "\n" + myMaze.maze.get(10).nextBelow + "\n" + myMaze.maze.get(10).nextAbove + "\n" + myMaze.maze.get(10).nextLeft);

        //Create empty BufferWriter for outputting maze to text file.
        BufferedWriter output = null;

      /*  try {

            //Associate file object to new text document that will containg the program output.
            File file = new File("MazeOutput");
            //Connects bufferedwriter to new FileWriter passing in the file to be written to.
            output = new BufferedWriter(new FileWriter(file));
            //Pass in stringbuilder from MazeSolver to allow proper formatting when iterating through each step
            output.write(solveMaze.sb.toString());


        } catch (IOException e){

            e.printStackTrace();

        } finally {

            if (output != null){

                output.close();

            }

        } */

        /*try {

            //Associate file object to new text document that will containg the program output.
            File file = new File("MazeQueueOutput");
            //Connects bufferedwriter to new FileWriter passing in the file to be written to.
            output = new BufferedWriter(new FileWriter(file));
            //Pass in stringbuilder from MazeSolver to allow proper formatting when iterating through each step
            output.write(solveMazeQueue.sb.toString());


        } catch (IOException e){

            e.printStackTrace();

        } finally {

            if (output != null){

                output.close();

            }

        } */

        /*try {

            //Associate file object to new text document that will containg the program output.
            File file = new File("MazeHeapOutput");
            //Connects bufferedwriter to new FileWriter passing in the file to be written to.
            output = new BufferedWriter(new FileWriter(file));
            //Pass in stringbuilder from MazeSolver to allow proper formatting when iterating through each step
            output.write(solveMazeHeap.sb.toString());


        } catch (IOException e){

            e.printStackTrace();

        } finally {

            if (output != null){

                output.close();

            }

        }*/

        try {

            //Associate file object to new text document that will containg the program output.
            File file = new File("MazeDFSOutput");
            //Connects bufferedwriter to new FileWriter passing in the file to be written to.
            output = new BufferedWriter(new FileWriter(file));
            //Pass in stringbuilder from MazeSolver to allow proper formatting when iterating through each step
            output.write(solveMazeDFS.sb.toString());


        } catch (IOException e){

            e.printStackTrace();

        } finally {

            if (output != null){

                output.close();

            }

        }


    }

}
