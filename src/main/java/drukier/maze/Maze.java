package drukier.maze;

import java.util.*;

public class Maze {

    private int mazeHeight = 10;
    private int mazeWidth = 10;

    private Random random = new Random();

    private MazeCell start;

    private MazeCell[][] array = new MazeCell[mazeHeight][mazeWidth];

    int visitedCells = 0;
    int totalCells = mazeHeight * mazeWidth;

    public static void main(String[] args) {

        Maze maze = new Maze();
        maze.mazeGenerator();
    }

    public MazeCell[][] mazeGenerator() {

        Stack<MazeCell> visit = new Stack<>();

        //Randomly select a cell "start".
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

        int cellX = random.nextInt(mazeHeight - 1);
        int cellY = random.nextInt(mazeWidth - 1);

        start = getMazeCell(cellX, cellY);
        return start;

    }

    private MazeCell getMazeCell(int cellX, int cellY) {
        return array[cellX][cellY];
    }


    private MazeCell getNextCell(MazeCell cell) {

        ArrayList<MazeCell> neighbors = null;

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

        if (!top.isVisited()){
            neighbors.add(top);
        }
        if (!bottom.isVisited()){
            neighbors.add(bottom);
        }
        if (!left.isVisited()){
            neighbors.add(left);
        }
        if (!right.isVisited()){
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


//      1 Randomly select a node (or cell) N.
//      2 Push the node N onto a queue Q.
//      3 Mark the cell N as visited.
//      4 Randomly select an adjacent cell A of node N that has not been visited.
//        If all the neighbors of N have been visited:
//            a)  Continue to pop items off the queue Q until a node is encountered with at least
//                one non-visited neighbor - assign this node to N and go to step 4.
//            b)  If no nodes exist: stop.
//      5 Break the wall between N and A.
//      6 Assign the value A to N.
//      7 Go to step 2.

    //pick cell
    //check visited
    //yes - pick neighbor and move
    //no - mark visited, pick neighbor, remove wall, move
    //cant move? check if all visited
    // yes - print
    //no - backtrack
}


