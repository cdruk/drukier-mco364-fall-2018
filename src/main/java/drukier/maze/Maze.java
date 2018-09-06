package drukier.maze;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Maze {

    private int mazeHeight = 10;
    private int mazeWidth = 10;

    MazeCell start;


    MazeCell[][] array;

    int visitedCells = 0;
    int totalCells = getMazeHeight() * getMazeWidth();


//    public Maze(int length, int width) {
//        mazeHeight = length;
//        mazeWidth = width;
//
//        maze = new MazeCell[mazeHeight][mazeWidth];
//
//    }

    public int getMazeHeight() {
        return mazeHeight;
    }

    public void setMazeHeight(int mazeHeight) {
        this.mazeHeight = mazeHeight;
    }

    public int getMazeWidth() {
        return mazeWidth;
    }

    public void setMazeWidth(int mazeWidth) {
        this.mazeWidth = mazeWidth;
    }

    public MazeCell getStart() {
        return start;
    }

    public void setStart(MazeCell start) {
        this.start = start;
    }

    public static void main(String[] args) {

        Maze maze = new Maze();
        maze.mazeGenerator();
    }

    public MazeCell[][] mazeGenerator() {

        Stack<MazeCell> visit = new Stack<MazeCell>();

        start = findStartCell();

        MazeCell current = start;

        while (visitedCells < totalCells) {

            //get neighbors
            current = getNextCell(current);

            // Chooses a neighbor to visit
            // current = chooseNext();

            if (!current.isVisited()) {
                visit.push(current);
                visitedCells++;
                current.setVisited(true);
                getNextCell(current);
            }

            if (current.isVisited()) {
                getNextCell(current);
            }

        }
        return array;

    }

    private MazeCell findStartCell() {
        Random currentX = new Random();
        Random currentY = new Random();

        int cellX = currentX.nextInt(mazeHeight - 1);
        int cellY = currentY.nextInt(mazeWidth - 1);

        start = new MazeCell(cellX, cellY);
        return start;

    }


    private MazeCell getNextCell(MazeCell cell) {

        ArrayList<MazeCell> neighbors = null;

        MazeCell top = null;
        MazeCell bottom = null;
        MazeCell left = null;
        MazeCell right = null;


        if ((cell.getCellX() - 1) > 0 && (cell.getCellX() - 1) < mazeHeight) {
            top = new MazeCell(cell.getCellX() - 1, cell.getCellY());
        }

        if ((cell.getCellX() + 1) > 0 && (cell.getCellX() + 1) < mazeHeight) {
            bottom = new MazeCell(cell.getCellX() + 1, cell.getCellY());
        }

        if ((cell.getCellY() - 1) > 0 && (cell.getCellY() - 1) < mazeHeight) {
            left = new MazeCell(cell.getCellX(), cell.getCellY() - 1);
        }

        if ((cell.getCellX() + 1) > 0 && (cell.getCellX() + 1) < mazeHeight) {
            right = new MazeCell(cell.getCellX(), cell.getCellY() + 1);
        }

        neighbors.add(top);
        neighbors.add(bottom);
        neighbors.add(left);
        neighbors.add(right);

        // Chooses a neighbor to visit
        cell = chooseNext(neighbors);

        return cell;

    }

    private MazeCell chooseNext(ArrayList<MazeCell> neighbors) {
        Collections.shuffle(neighbors);
        return neighbors.get(0);

    }
    //pick cell
    //check visited
    //yes - pick neighbor and move
    //no - mark visited, pick neighbor, remove wall, move
    //cant move? check if all visited
    // yes - print
    //no - backtrack

//        Randomly select a node (or cell) N.
//                Push the node N onto a queue Q.
//                Mark the cell N as visited.
//                Randomly select an adjacent cell A of node N that has not been visited. If all the neighbors of N have been visited:
//        Continue to pop items off the queue Q until a node is encountered with at least one non-visited neighbor - assign this node to N and go to step 4.
//        If no nodes exist: stop.
//                Break the wall between N and A.
//        Assign the value A to N.
//        Go to step 2.


}


