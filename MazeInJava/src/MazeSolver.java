import java.util.Stack;

public class MazeSolver {

    MazeSolver (Maze maze){

        //Point to current position of the maze
        int currentPosition = 0;

        //Keep track of maze squares visited
        Stack<Integer> prevMoves = new Stack<>();

        //Locate the starting position
        while (maze.maze.get(currentPosition).getMid() != ".S."){

            currentPosition++;

        }

        //Track starting position to prevent starting square from be changed
        int startingIndex = currentPosition;

        //Recalculate array position to 2D position to correct row
        int rowIndex = currentPosition / maze.columns;
        //Recalculate array position to 2D position to correct column
        int columnIndex = currentPosition - (rowIndex * maze.columns);

        //Display starting position and print maze before traversal starts
        sb.append("The starting index is " + rowIndex + "," + columnIndex + "\n\n" + maze.printMaze());

        //continue to run until the finish (Goal) position is reached
        while (maze.maze.get(currentPosition).getMid() != ".F.") {

                //Check if position below current position is open. Checking to ensure not out of range
            if (currentPosition + maze.columns < maze.maze.size() && (maze.maze.get(currentPosition + maze.columns).getMid() == "..." || maze.maze.get(currentPosition + maze.columns).getMid() == ".S." ||
                    maze.maze.get(currentPosition + maze.columns).getMid() == ".F.")) {

                //Check if position below is the finish (Goal)
                if (maze.maze.get(currentPosition + maze.columns).getMid() == ".F."){

                    //Display what direction was selected
                    sb.append("\nMoved right\n");
                    //Redraw current position to track the path while traversing
                    maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.PATH);
                    //push current position to the stack to allow backtracking
                    prevMoves.push(currentPosition);
                    //update current position to position below
                    currentPosition = currentPosition + maze.columns;
                    //Recalculate index for row (formatting)
                    rowIndex = currentPosition / maze.columns;
                    //Recalculate index for column (Formatting)
                    columnIndex = currentPosition - (rowIndex * maze.columns);
                    //Add new maze image.  Adding to stringbuilder to allow appending to file
                    sb.append(maze.printMaze());
                    //Maze solved text. Also shows the current index in 2D format
                    sb.append("Maze Solved! Finish index: " + rowIndex + "," + columnIndex + "\n\n");
                    //Add current stack in index format to allow printing current stack content
                    sb.append("\nCurrent stack contains: " + stackSB.toString() + "\n");
                    //Break the while loop, skipping the repetitive end of loop code at the bottom
                    return;

                }

                //Add direction moved to stringbuilder for clarity
                sb.append("\nMoved down\n");
                //set current maze square to type path for tracking traversal
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.PATH);
                //push current position to the stack for backtracking
                prevMoves.push(currentPosition);
                //append last push to stack in index format (converting single array to 2D array format)
                stackSB.append("(" + rowIndex + "," + columnIndex + "),");
                //update currentposition to position below
                currentPosition = currentPosition + maze.columns;
                //Recalc row. Repetitive comment. See above. Will stop commenting this line
                rowIndex = currentPosition / maze.columns;
                //Recalc column. Repetitive comment. See above.  Will stop commenting this line
                columnIndex = currentPosition - (rowIndex * maze.columns);
                //Reformat current position to show current position on next maze.print();
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.CURRENT);


                //Check if position to the right is open
            } else if (columnIndex != maze.columns - 1 && (maze.maze.get(currentPosition + 1).getMid() == "..." ||
                    maze.maze.get(currentPosition + 1).getMid() == ".F.")){

                //Check if maze square to the right is the finish (Goals)
                if (maze.maze.get(currentPosition + 1).getMid() == ".F."){

                    //Repetitive code. See above. Will stop commenting this line
                    sb.append("\nMoved right\n");
                    //Repetitive code. See above. Will stop commenting this line
                    maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.PATH);
                    //Repetitive code. See above. Will stop commenting this line
                    prevMoves.push(currentPosition);
                    //Update current position to maze square to the right
                    currentPosition = currentPosition + 1;
                    rowIndex = currentPosition / maze.columns;
                    columnIndex = currentPosition - (rowIndex * maze.columns);
                    sb.append(maze.printMaze());
                    sb.append("Maze Solved! Finish index: " + rowIndex + "," + columnIndex + "\n\n");
                    sb.append("\nCurrent stack contains: " + stackSB.toString() + "\n");
                    return;

                }

                sb.append("\nMoved right\n");
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.PATH);
                prevMoves.push(currentPosition);
                stackSB.append("(" + rowIndex + "," + columnIndex + "),");
                currentPosition = currentPosition + 1;
                rowIndex = currentPosition / maze.columns;
                columnIndex = currentPosition - (rowIndex * maze.columns);
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.CURRENT);


                //Check if position above current position is open
            } else if (currentPosition - maze.columns >= 0 && (maze.maze.get(currentPosition - maze.columns).getMid() == "..." ||
                    maze.maze.get(currentPosition - maze.columns).getMid() == ".F.")){

                if (maze.maze.get(currentPosition - maze.columns).getMid() == ".F."){

                    sb.append("\nMoved up\n");
                    maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.PATH);
                    prevMoves.push(currentPosition);
                    currentPosition = currentPosition - maze.columns;
                    rowIndex = currentPosition / maze.columns;
                    columnIndex = currentPosition - (rowIndex * maze.columns);
                    sb.append(maze.printMaze());
                    sb.append("Maze Solved! Finish index: " + rowIndex + "," + columnIndex + "\n\n");
                    sb.append("\nCurrent stack contains: " + stackSB.toString() + "\n");
                    return;

                }

                sb.append("\nMoved up\n");
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.PATH);
                prevMoves.push(currentPosition);
                stackSB.append("(" + rowIndex + "," + columnIndex + "),");
                currentPosition = currentPosition - maze.columns;
                rowIndex = currentPosition / maze.columns;
                columnIndex = currentPosition - (rowIndex * maze.columns);
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.CURRENT);


                //Check if position to the left of current is open
            } else if (columnIndex != 0 && (maze.maze.get(currentPosition - 1).getMid() == "..." ||
                    maze.maze.get(currentPosition - 1).getMid() == ".F.")){

                if (maze.maze.get(currentPosition - 1).getMid() == ".F."){

                    sb.append("\nMoved left\n");
                    maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.PATH);
                    prevMoves.push(currentPosition);
                    currentPosition = currentPosition - 1;
                    rowIndex = currentPosition / maze.columns;
                    columnIndex = currentPosition - (rowIndex * maze.columns);
                    sb.append(maze.printMaze());
                    sb.append("Maze Solved! Finish index: " + rowIndex + "," + columnIndex + "\n\n");
                    sb.append("\nCurrent stack contains: " + stackSB.toString() + "\n");
                    return;

                }

                sb.append("\nMoved left\n");
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.PATH);
                prevMoves.push(currentPosition);
                stackSB.append("(" + rowIndex + "," + columnIndex + "),");
                currentPosition = currentPosition - 1;
                rowIndex = currentPosition / maze.columns;
                columnIndex = currentPosition - (rowIndex * maze.columns);
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.CURRENT);


            } else {

                //Display indication that there are new good paths. Backtrack to previous maze square
                sb.append("\nNo Where to go! Heading back!\n");
                //Format maze square to show a backtracked move
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.BACKTRACK);
                //set current position to top of stack and remove top element
                currentPosition = prevMoves.pop();
                //Next 6 lines: Remove character to properly track stack contents (Converted from single array to 2D array format
                stackSB.deleteCharAt(stackSB.length() - 1);
                stackSB.deleteCharAt(stackSB.length() - 1);
                stackSB.deleteCharAt(stackSB.length() - 1);
                stackSB.deleteCharAt(stackSB.length() - 1);
                stackSB.deleteCharAt(stackSB.length() - 1);
                stackSB.deleteCharAt(stackSB.length() - 1);

                rowIndex = currentPosition / maze.columns;
                columnIndex = currentPosition - (rowIndex * maze.columns);
                maze.maze.get(currentPosition).setSquareType(MazeSquare.squareType.CURRENT);


            }

            //Ensure starting maze square is not redrawn if backtracked over
            maze.maze.get(startingIndex).setSquareType(MazeSquare.squareType.START);
            //add current maze state to allow printing at each step to track traversal
            sb.append(maze.printMaze());
            //display current position for each iteration
            sb.append("Current position: " + rowIndex + "," + columnIndex + "\n\n");
            //Display stack at each iteration
            sb.append("Current stack contains: " + stackSB.toString() + "\n\n");

        }

    }

    //maintanes formatting of maze and added info to append to output file
    StringBuilder sb = new StringBuilder();
    //Holds the current stack to display properly through each iteration
    StringBuilder stackSB = new StringBuilder();

}
