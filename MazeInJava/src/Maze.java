/*

Created by Christopher Finster on 27DEC2018.

*/

import java.util.ArrayList;


public class Maze {

    Maze(){

    }

    //Constructor taking in data to generate maze of the intended size
    Maze(int rows, int columns){

        //Next 3 lines: Self-explanatory
        this.rows = rows;
        this.columns = columns;
        this.size = rows * columns;
        //Calls the function generateMaze to construct maze instantiating each mazeSquare object as open
        generateMaze(rows, columns);

    }

    int rows;
    int columns;
    int size;

    //Create arrayList to hold each mazeSquare object
    ArrayList<MazeSquare> maze = new ArrayList<MazeSquare>();

    public void generateMaze(int rows, int columns){

        int mazeSquareCount = 0;
        int size = rows * columns;

        //Iterate through the maze creating OPEN maze squares at each index (Default). Could also be done in single for loop but helps me maintain consistent thought process
        for(int row = 0; row < rows; row++){

            for(int column = 0; column < columns; column++){

                //Create OPEN type mazeSquare object
                MazeSquare newMazeSquare = new MazeSquare(MazeSquare.squareType.OPEN);

                newMazeSquare.index = mazeSquareCount;


                if(mazeSquareCount - columns >= 0)
                    newMazeSquare.nextAbove = mazeSquareCount - columns;

                if(mazeSquareCount + columns < size)
                    newMazeSquare.nextBelow = mazeSquareCount + columns;

                if(mazeSquareCount + 1 < size && mazeSquareCount % (columns - 1) != 0 || mazeSquareCount == 0)
                    newMazeSquare.nextRight = mazeSquareCount + 1;

                if(mazeSquareCount - 1 >= 0 && mazeSquareCount % columns != 0)
                    newMazeSquare.nextLeft = mazeSquareCount - 1;

                //Place new object in maze ArrayList
                maze.add(newMazeSquare);

                mazeSquareCount++;

            }

        }

    }


    public String printMaze(){

        int columnTemp = 0;
        int size = maze.size();

        //Used to maintain formatting
        StringBuilder mazeSB = new StringBuilder();

        //Iterate through rows
        for (int i = 0; i < rows; i++){

            //Iterate through top, mid, bot of mazeSquare to maintain formatting
            for (int j = 0; j < 3; j ++){

                //Used for formatting the arraylist to look like a 2D array
                for (int column = columnTemp; column < (columns + columnTemp); column++){

                    mazeSB.append(maze.get(column).squareArray[j]);

                }

                //Break each lines depending on column size
                mazeSB.append("\n");

            }

            //Maintain formatting
            if(columnTemp + columns < maze.size()){

                columnTemp = columnTemp + columns;

            }


        }

        //Print current maze in its current state formatted
        System.out.print(mazeSB.toString());

        return mazeSB.toString();
    }

}
