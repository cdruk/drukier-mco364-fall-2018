package drukier.maze;

import java.util.*;

public class Maze {

    private int mazeHeight;
    private int mazeWidth;

    private Random random = new Random();

    private MazeCell start;
    private MazeCell current;
    private MazeCell next;

    private MazeCell[][] maze;

    //int visitedCells = 0;
    //int totalCells = mazeHeight * mazeWidth;

    private enum Direction{UP, DOWN, RIGHT, LEFT;}
    private Direction direction;

    public Maze(int mazeHeight, int mazeWidth) {

            this.mazeHeight = mazeHeight;
            this.mazeWidth = mazeWidth;
            maze = new MazeCell[mazeHeight][mazeWidth];
            for (int i = 0; i < mazeHeight; i++)
            {
                for (int j = 0; j < mazeWidth; j++)
                {
                    maze[i][j] = new MazeCell(i, j);
                }
            }
        }

        //must do it all
    public void mazeGenerator() {

        Stack<MazeCell> visit = new Stack<>();

        start = findStartCell();

        current = start;

        direction = getDirection();


            current.setVisited(true);
            getNextCell(current, direction);
            //make if else
            checkVisited(next);
            //next = getNextCell(current);
            removeWalls(current, next, direction);
            visit.push(current);
            visit.pop();
            next = current;


            if (visit.peek().isVisited()) {
                current = getNextCell(current);
            }
        maze.toString();
        }

    private MazeCell findStartCell() {

        int cellX = random.nextInt(mazeHeight - 1);
        int cellY = random.nextInt(mazeWidth - 1);

        start = getMazeCell(cellX, cellY);
        return start;

    }

    private MazeCell getMazeCell(int cellX, int cellY) {
        return maze[cellX][cellY];
    }

    private MazeCell getNextCell (MazeCell current, Direction direction) {
        MazeCell nextCell;
        switch (direction) {
            case UP:
                nextCell = getMazeCell((current.getCellX() - 1 ), current.getCellY());
                if (mazeContains(nextCell)){
                    return nextCell;
                }
                break;
            case DOWN:
                nextCell = getMazeCell((current.getCellX() + 1 ), current.getCellY());
                if (mazeContains(nextCell)){
                    return nextCell;
                }
                break;
            case RIGHT:
                nextCell = getMazeCell((current.getCellX() + 1 ), current.getCellY());
                if (mazeContains(nextCell)){
                    return nextCell;
                }
                break;
            case LEFT:
                nextCell = getMazeCell((current.getCellX() - 1 ), current.getCellY());
                if (mazeContains(nextCell)){
                    return nextCell;
                }
                break;
        }
        return null;
    }

    private boolean mazeContains(MazeCell nextCell){
        MazeCell cell = nextCell;
        for ( int i = 0; i < mazeHeight; ++i ) {
            for ( int j = 0; j < mazeWidth; ++j ) {
                if ( maze[i][j] == cell ) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVisited(MazeCell next) {
        return next.isVisited();
    }

    private void removeWalls(MazeCell current, MazeCell next, Direction direction) {
        switch (direction) {
            case UP:
                current.setnWall(false);
                next.setsWall(false);
                break;
            case DOWN:
                current.setsWall(false);
                next.setnWall(false);
                break;
            case RIGHT:
                current.seteWall(false);
                next.setwWall(false);
                break;
            case LEFT:
                current.setwWall(false);
                next.seteWall(false);
                break;
        }
    }

    public Direction getDirection(){
        return Direction.values()[random.nextInt(Direction.values().length)];
    }
    //pick cell
    //check visited
    //yes - pick neighbor and move
    //no - mark visited, pick neighbor, remove wall, move
    //cant move? check if all visited
    // yes - print
    //no - backtrack

    public String toString(){
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i<mazeHeight; i++){
            for (int j = 1; j<mazeWidth; j++){
                MazeCell formattedCell = maze[i][j];
                //TODO figure out nWall loop
                if (formattedCell.isnWall()){
                    builder.append("_");
                }
                if (formattedCell.iswWall()){
                    builder.append("|");
                }
                if (formattedCell.issWall()){
                    builder.append("_");
                }
                if (formattedCell.iseWall()){
                    builder.append("|");
                }
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}




