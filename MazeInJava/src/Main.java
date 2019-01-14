import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main (String[] args) throws IOException {

        int rows;
        int columns;

        File inputFile = new File ("C:\\Users\\Finst\\IdeaProjects\\MazeInJava\\src\\MazeInput");
        Scanner scan = new Scanner (inputFile);

        rows = scan.nextInt();
        columns = scan.nextInt();

        System.out.println("We made it this far");

        Maze myMaze = new Maze(rows, columns);
        System.out.println(rows + " " + columns);

        int indexToChange = (scan.nextInt() * columns) + scan.nextInt();

        myMaze.maze.get(indexToChange).setSquareType(MazeSquare.squareType.START);

        indexToChange = (scan.nextInt() * columns) + scan.nextInt();
        myMaze.maze.get(indexToChange).setSquareType(MazeSquare.squareType.FINISH);

        int count = 3;

        while (scan.hasNextInt()){

            /*for (int i = 0; i < 2; i++){

                count++;
                indexToChange = (scan.nextInt() - 1) + (columns - 1) * scan.nextInt();
                myMaze.maze.get(indexToChange).setSquareType(MazeSquare.squareType.WALL);
                System.out.println("We made it this far" + count);

            }*/

            int x = scan.nextInt() * columns;
            int y = scan.nextInt();
            indexToChange = x + y;
            myMaze.maze.get(indexToChange).setSquareType(MazeSquare.squareType.WALL);

        }

/*
        myMaze.maze.get(0).setSquareType(MazeSquare.squareType.START);
        myMaze.maze.get(3).setSquareType(MazeSquare.squareType.WALL);
        myMaze.maze.get(8).setSquareType(MazeSquare.squareType.WALL);
        myMaze.maze.get(13).setSquareType(MazeSquare.squareType.WALL);
        myMaze.maze.get(18).setSquareType(MazeSquare.squareType.WALL);
        myMaze.maze.get(23).setSquareType(MazeSquare.squareType.WALL);
        myMaze.maze.get(24).setSquareType(MazeSquare.squareType.FINISH);
*/
        // if index from file is (3, 8) first num (row) * (columns in maze), + second num (column) = intended index for maze list.
        // Example: Num of columns in maze is 10, num rows is 10:
        // index from file is (3, 8). 3 * 10 = 30. 30 + 8 = 38.  The 28th element in maze is printed at index 3, 8.

        myMaze.printMaze();

        BufferedWriter output = null;

        try {

            File file = new File("MazeOutput");
            output = new BufferedWriter(new FileWriter(file));
            output.write(myMaze.printMaze());

        } catch (IOException e){

            e.printStackTrace();

        } finally {

            if (output != null){

                output.close();

            }

        }
        //System.out.println(myMaze.maze.get(0).squareArray[0]);

    }

}
