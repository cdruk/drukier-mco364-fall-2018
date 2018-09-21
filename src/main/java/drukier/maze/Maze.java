package drukier.maze;

import java.util.*;

public class Maze {

    private int mazeHeight = 10;
    private int mazeWidth = 10;

    private Random random = new Random();

    private MazeCell start;
    private MazeCell current;
    private MazeCell next;

    private MazeCell[][] array = new MazeCell[mazeHeight][mazeWidth];

    int visitedCells = 0;
    int totalCells = mazeHeight * mazeWidth;

    public Maze(MazeCell[][] array) {
        this.array = array;
    }

    Maze maze = new Maze();
        maze.mazeGenerator();

    public MazeCell[][] mazeGenerator() {

        Stack<MazeCell> visit = new Stack<>();

        start = findStartCell();

        current = start;

        while (visitedCells < totalCells) {

            current.setVisited(true);
            visitedCells++;
            next = getNextCell(current);
            removeWalls(current, next);
            visit.push(current);
            visit.pop();
            next = current;


            if (visit.peek().isVisited()) {
                current = getNextCell(current);
            }
        }
        return array;

    }

    private MazeCell findStartCell() {

        int cellX = random.nextInt(mazeHeight - 1);
        int cellY = random.nextInt(mazeWidth - 1);

        start = getMazeCell(cellX, cellY);
        return start;

    }

    private MazeCell getMazeCell(int cellX, int cellY) {
        return array[cellX][cellY];
    }


    private MazeCell getNextCell(MazeCell cell) {

        ArrayList<MazeCell> neighbors = new ArrayList<>();

        MazeCell top = null;
        MazeCell bottom = null;
        MazeCell left = null;
        MazeCell right = null;


        if ((cell.getCellX() - 1) > 0 && (cell.getCellX() - 1) < mazeHeight) {
            top = getMazeCell(cell.getCellX() - 1, cell.getCellY());
        }

        if ((cell.getCellX() + 1) > 0 && (cell.getCellX() + 1) < mazeHeight) {
            bottom = getMazeCell(cell.getCellX() + 1, cell.getCellY());
        }

        if ((cell.getCellY() - 1) > 0 && (cell.getCellY() - 1) < mazeHeight) {
            left = getMazeCell(cell.getCellX(), cell.getCellY() - 1);
        }

        if ((cell.getCellX() + 1) > 0 && (cell.getCellX() + 1) < mazeHeight) {
            right = getMazeCell(cell.getCellX(), cell.getCellY() + 1);
        }

        if (top != null && !top.isVisited()){
            neighbors.add(top);
        }
        if (bottom != null && !bottom.isVisited()){
            neighbors.add(bottom);
        }
        if (left != null && !left.isVisited()){
            neighbors.add(left);
        }
        if (right != null && !right.isVisited()){
            neighbors.add(right);
        }

        // Chooses a neighbor to visit
        cell = chooseNext(neighbors);

        return cell;

    }

    private MazeCell chooseNext(ArrayList<MazeCell> neighbors) {
        Collections.shuffle(neighbors);
        return neighbors.get(0);

    }

    private void removeWalls(MazeCell current, MazeCell next) {


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
                MazeCell mazeDone = array[i][j];
                if (array.issWall()){
                    builder.append("_");
                }
                if (array.iseWall()){
                    builder.append("|");
                }
                builder.append("\n");
            }

            return builder.toString();
        }
    }
}



