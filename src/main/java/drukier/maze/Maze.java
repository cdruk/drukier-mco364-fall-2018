package drukier.maze;

import java.util.*;

public class Maze {

    private int mazeWidth;
    private int mazeHeight;

    private Random random = new Random();

    private MazeCell start;
    private MazeCell current;
    private MazeCell next;

    private MazeCell[][] maze;

    int visitedCells = 0;
    int totalCells;

    private enum Direction {UP, DOWN, RIGHT, LEFT;}

    private Direction direction;

    public Maze(int mazeWidth, int mazeHeight) {

        this.mazeWidth = mazeWidth;
        this.mazeHeight = mazeHeight;
        totalCells = mazeWidth * mazeHeight;
        maze = new MazeCell[mazeWidth][mazeHeight];
        for (int i = 0; i < mazeWidth; i++) {
            for (int j = 0; j < mazeHeight; j++) {
                maze[i][j] = new MazeCell(i, j);
            }
        }

        mazeGenerator();
        System.out.println(toString());
    }

    //must do it all
    public void mazeGenerator() {

        Stack<MazeCell> visit = new Stack<>();

        start = findStartCell();

        current = start;

        while (visitedCells < totalCells) {
            current.setVisited(true);
            if (nextCell(current)) {
                visit.push(current);
                visitedCells++;
                current = current.getNext();
            } else {
                current = visit.pop();
            }
        }
    }

    private MazeCell findStartCell() {

        int cellY = random.nextInt(mazeWidth - 1);
        int cellX = random.nextInt(mazeHeight - 1);

        start = getMazeCell(cellY, cellX);
        return start;

    }

    private MazeCell getMazeCell(int cellY, int cellX) {
        return maze[cellY][cellX];
    }

    private boolean nextCell(MazeCell current) {

        MazeCell nextCell = null;
        int nextY = current.getCellY();
        int nextX = current.getCellX();
        boolean success = false;
        direction = getDirection();
        int doneDirection = 0;

        while (nextCell == null && doneDirection < 4) {

            switch (direction) {
                case UP:
                    nextX--;
                    doneDirection++;
                    break;
                case DOWN:
                    nextX++;
                    doneDirection++;
                    break;
                case RIGHT:
                    nextY++;
                    doneDirection++;
                    break;
                case LEFT:
                    nextY--;
                    doneDirection++;
                    break;
            }

            if (mazeContains(nextY, nextX)) {
                if (!(getMazeCell(nextY, nextX).isVisited())) {
                    nextCell = getMazeCell(nextY, nextX);
                    current.setNext(nextCell);
                    success = true;
                    removeWalls(current, nextCell, direction);
                    direction = nextDirection();
                }
            }

            //reset current and get next direction
            else {
                nextY = current.getCellY();
                nextX = current.getCellX();
                direction = nextDirection();
            }
        }
        return success;
    }

    private boolean mazeContains(int x, int y) {
        boolean valid = false;
        if ((x < mazeWidth) && (y < mazeHeight)) {
            if ((x >= 0) && (y >= 0)) {
                valid = true;
            }
        }
        return valid;
    }

        private void removeWalls (MazeCell current, MazeCell next, Direction direction){
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

        private Direction getDirection () {

            return Direction.values()[random.nextInt(Direction.values().length)];
        }

        public Direction nextDirection () {
            return direction.values()[(direction.ordinal() + 1) % direction.values().length];
        }

        public String toString () {
            StringBuilder builder = new StringBuilder();

            for (int i = 1; i < mazeWidth; i++) {
                //print nWall
                for (int j = 1; j < mazeHeight; j++) {
                    MazeCell current = maze[i][j];
                    if (current.iswWall()) {
                        builder.append("|");
                    }
                    if (current.issWall()) {
                        builder.append("_");
                    }
                    if (current.iseWall()) {
                        builder.append("|");
                    }
                    builder.append("\n");
                }
            }
            return builder.toString();
        }
    }





