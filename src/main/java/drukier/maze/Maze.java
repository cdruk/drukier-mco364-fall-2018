package drukier.maze;

import java.util.*;

public class Maze {

    private int mazeWidth;
    private int mazeHeight;

    private Random random = new Random();

    private MazeCell current;

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
        //initialize by filling down and then across instead of across then down like usual
        for (int y = 0; y < mazeWidth; y++) {
            for (int x = 0; x < mazeHeight; x++) {
                maze[x][y] = new MazeCell(x, y);
            }
        }

        mazeGenerator();
        print();
    }

    //must do it all
    public void mazeGenerator() {

        Stack<MazeCell> visit = new Stack<>();

        current = getMazeCell(0,0);

        while (visitedCells < totalCells ) {
            if (nextCell(current)) {
                visit.push(current);
                current = current.getNext();
            } else {
                if (!visit.isEmpty()) {
                    current = visit.pop();
                }
                else{
                    System.out.println("visitedCells = " + visitedCells);
                }
            }
        }
    }

    //if I want to start randomly
    private MazeCell findStartCell() {
        MazeCell start;

        int cellX = random.nextInt(mazeWidth - 1);
        int cellY = random.nextInt(mazeHeight - 1);

        start = getMazeCell(cellX, cellY);
        return start;

    }

    private MazeCell getMazeCell(int cellX, int cellY) {
        return maze[cellX][cellY];
    }

    private boolean nextCell(MazeCell current) {

        MazeCell nextCell = null;
        int nextX = current.getCellX();
        int nextY = current.getCellY();
        boolean success = false;
        direction = getDirection();
        int doneDirection = 0;

        while (nextCell == null && doneDirection < 4) {

            switch (direction) {
                case UP:
                    nextY--;
                    doneDirection++;
                    break;
                case DOWN:
                    nextY++;
                    doneDirection++;
                    break;
                case RIGHT:
                    nextX++;
                    doneDirection++;
                    break;
                case LEFT:
                    nextX--;
                    doneDirection++;
                    break;
            }

            if ((mazeContains(nextX, nextY)) && (!(getMazeCell(nextX, nextY).isVisited()))) {

                    nextCell = getMazeCell(nextX, nextY);
                    current.setNext(nextCell);
                    removeWalls(current, nextCell, direction);
                    success = true;
                }
                //reset current and get next direction
                else {
                    nextX = current.getCellX();
                    nextY = current.getCellY();
                    direction = nextDirection();
                }



        }
        if (!current.isVisited()) {
            visitedCells++;
            current.setVisited(true);
        }
        return success;
    }

    private boolean mazeContains(int x, int y) {
        boolean valid = false;
        //TODO switch?
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

        public void print () {
            for (int x = 0; x < mazeWidth; x++) {
                System.out.print(" _");
            }

                for (int x = 0; x < mazeWidth; x++) {
                    System.out.print("\n");
                    for (int y = 0; y < mazeHeight; y++) {
                        MazeCell current = maze[y][x];
                        StringBuilder builder = new StringBuilder();
                        if (current.iswWall()) {
                            builder.append("|");
                        }
                        if (!current.iswWall()) {
                            builder.append(" ");
                        }

                        if (current.issWall()) {
                            builder.append("_");
                        }
                        if (!current.issWall()) {
                            builder.append(" ");
                        }

                        System.out.print(builder);
                    }
                    System.out.print("|");
                }
        }
    }





