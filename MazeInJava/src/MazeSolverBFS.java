import java.util.LinkedList;
import java.util.Queue;

public class MazeSolverBFS {

    MazeSolverBFS (){

    }

    MazeSolverBFS (Maze maze) {

        Queue <Integer> mazeQueue = new LinkedList<Integer>();
        int currentPosition = 0;

        //Locate the starting position
        while (maze.maze.get(currentPosition).getMid() != ".S."){

            currentPosition++;

        }

        //Track starting position to prevent starting square from be changed
        int startingIndex = currentPosition;
        sb.append("current position is: " + currentPosition + " Maze Size: " + maze.maze.size() + "\n");
        System.out.println("current position is: " + currentPosition + " Maze Size: " + maze.maze.size());

        mazeQueue.add(startingIndex);

        currentPosition = mazeQueue.remove();

        //Recalculate array position to 2D position to correct row
        int rowIndex = currentPosition / maze.columns;
        //Recalculate array position to 2D position to correct column
        int columnIndex = currentPosition - (rowIndex * maze.columns);


        while (maze.maze.get(currentPosition).getMid() != ".F.") {

            if ((currentPosition + maze.columns < maze.maze.size()) && (maze.maze.get(currentPosition + maze.columns).getMid() == "..." || maze.maze.get(currentPosition + maze.columns).getMid() == ".S." ||
                    maze.maze.get(currentPosition + maze.columns).getMid() == ".F.") && maze.maze.get(currentPosition + maze.columns).seen != true){

                if (maze.maze.get(currentPosition + maze.columns).getMid() == ".F."){

                    currentPosition = currentPosition + maze.columns;
                    //Recalculate array position to 2D position to correct row
                    rowIndex = currentPosition / maze.columns;
                    //Recalculate array position to 2D position to correct column
                    columnIndex = currentPosition - (rowIndex * maze.columns);
                    sb.append("Maze completed! The goal index is " + rowIndex + "," + columnIndex + "\n");
                    System.out.println("Maze completed! The goal index is " + rowIndex + "," + columnIndex);
                    return;

                }

                mazeQueue.add(currentPosition + maze.columns);
                sb.append("Index: " + (currentPosition + maze.columns) + " added to queue\n");
                System.out.println("Index: " + (currentPosition + maze.columns) + " added to queue");
                maze.maze.get(currentPosition + maze.columns).seen = true;
                maze.maze.get(currentPosition + maze.columns).setSquareType(MazeSquare.squareType.PATH);

            }

            if (columnIndex != maze.columns - 1 && (maze.maze.get(currentPosition + 1).getMid() == "..." ||
                    maze.maze.get(currentPosition + 1).getMid() == ".F.") && maze.maze.get(currentPosition + 1).seen != true){

                if (maze.maze.get(currentPosition + 1).getMid() == ".F."){

                    currentPosition = currentPosition + 1;
                    //Recalculate array position to 2D position to correct row
                    rowIndex = currentPosition / maze.columns;
                    //Recalculate array position to 2D position to correct column
                    columnIndex = currentPosition - (rowIndex * maze.columns);
                    sb.append("Maze completed! The goal index is " + rowIndex + "," + columnIndex + "\n");
                    System.out.println("Maze completed! The goal index is " + rowIndex + "," + columnIndex);
                    return;

                }

                mazeQueue.add(currentPosition + 1);
                sb.append("Index: " + (currentPosition + 1) + " added to queue\n");
                System.out.println("Index: " + (currentPosition + 1) + " added to queue");
                maze.maze.get(currentPosition + 1).seen = true;
                maze.maze.get(currentPosition + 1).setSquareType(MazeSquare.squareType.PATH);

            }

            if (currentPosition - maze.columns >= 0 && (maze.maze.get(currentPosition - maze.columns).getMid() == "..." ||
                    maze.maze.get(currentPosition - maze.columns).getMid() == ".F.") && maze.maze.get(currentPosition - maze.columns).seen != true){

                if (maze.maze.get(currentPosition - maze.columns).getMid() == ".F."){

                    currentPosition = currentPosition - maze.columns;
                    //Recalculate array position to 2D position to correct row
                    rowIndex = currentPosition / maze.columns;
                    //Recalculate array position to 2D position to correct column
                    columnIndex = currentPosition - (rowIndex * maze.columns);
                    sb.append("Maze completed! The goal index is " + rowIndex + "," + columnIndex + "\n");
                    System.out.println("Maze completed! The goal index is " + rowIndex + "," + columnIndex);
                    return;

                }

                mazeQueue.add(currentPosition - maze.columns);
                sb.append("Index: " + (currentPosition - maze.columns) + " added to queue\n");
                System.out.println("Index: " + (currentPosition - maze.columns) + " added to queue");
                maze.maze.get(currentPosition - maze.columns).seen = true;
                maze.maze.get(currentPosition - maze.columns).setSquareType(MazeSquare.squareType.PATH);

            }

            if (columnIndex != 0 && (maze.maze.get(currentPosition - 1).getMid() == "..." ||
                    maze.maze.get(currentPosition - 1).getMid() == ".F.") && maze.maze.get(currentPosition - 1).seen != true){

                if (maze.maze.get(currentPosition - 1).getMid() == ".F."){

                    currentPosition = currentPosition = 1;
                    //Recalculate array position to 2D position to correct row
                    rowIndex = currentPosition / maze.columns;
                    //Recalculate array position to 2D position to correct column
                    columnIndex = currentPosition - (rowIndex * maze.columns);
                    sb.append("Maze completed! The goal index is " + rowIndex + "," + columnIndex + "\n");
                    System.out.println("Maze completed! The goal index is " + rowIndex + "," + columnIndex);
                    return;

                }

                mazeQueue.add(currentPosition - 1);
                sb.append("Index: " + (currentPosition - 1) + " added to queue\n");
                System.out.println("Index: " + (currentPosition - 1) + " added to queue");
                maze.maze.get(currentPosition - 1).seen = true;
                maze.maze.get(currentPosition - 1).setSquareType(MazeSquare.squareType.PATH);

            }

            currentPosition = mazeQueue.remove();
            sb.append("Current position is: " + currentPosition + "\n");
            System.out.println("Current Position is: " + currentPosition);
            //Recalculate array position to 2D position to correct row
            rowIndex = currentPosition / maze.columns;
            //Recalculate array position to 2D position to correct column
            columnIndex = currentPosition - (rowIndex * maze.columns);

            sb.append("Maze Queue contains: " + mazeQueue + "\n");
            System.out.println(mazeQueue);

            sb.append(maze.printMaze() + "\n\n");
            System.out.println(maze.printMaze());

        }

    }

    StringBuilder sb = new StringBuilder();

}
