/*

Created by Christopher Finster on 27DEC2018.

*/

import java.util.ArrayList;


public class Maze {

    Maze(){

    }

    Maze(int rows, int columns){

        this.rows = rows;
        this.columns = columns;
        generateMaze(rows, columns);

    }

    int rows;
    int columns;
    ArrayList<MazeSquare> maze = new ArrayList<MazeSquare>();


    public void generateMaze(int rows, int columns){

        for(int row = 0; row < rows; row++){

            for(int column = 0; column < columns; column++){

                MazeSquare newMazeSquare = new MazeSquare(MazeSquare.squareType.OPEN);
                maze.add(newMazeSquare);

            }

        }

    }

    public String printMaze(){

        //int rows = myMaze.rows;
        //int columns = myMaze.columns;
        int columnTemp = 0;
        int size = maze.size();

        StringBuilder mazeSB = new StringBuilder();

        for (int i = 0; i < rows; i++){

            for (int j = 0; j < 3; j ++){

                for (int column = columnTemp; column < (columns + columnTemp); column++){

                    mazeSB.append(maze.get(column).squareArray[j]);

                }

                mazeSB.append("\n");

            }

            if(columnTemp + columns < maze.size()){

                columnTemp = columnTemp + columns;

            }


        }


        System.out.print(mazeSB.toString());

        return mazeSB.toString();
    }

}
