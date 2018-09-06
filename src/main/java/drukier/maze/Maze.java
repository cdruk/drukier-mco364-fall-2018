package drukier.maze;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Maze {

    private int mazeHeight;
    private int mazeWidth;

    MazeCell current;
    ArrayList<MazeCell> neighbors;

    MazeCell[][] maze;

    int visitedCells = 0;
    int totalCells = getMazeHeight() * getMazeWidth();


    public Maze(int length, int width) {
        mazeHeight = length;
        mazeWidth = width;

        maze = new MazeCell[mazeHeight][mazeWidth];

    }

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

    public MazeCell getCurrent() {
        return current;
    }

    public void setCurrent(MazeCell current) {
        this.current = current;
    }

    public ArrayList<MazeCell> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<MazeCell> neighbors) {
        this.neighbors = neighbors;
    }


    public  static void main(String [] args) {

    }
    public MazeCell [][] mazeGenerator(MazeCell [][] maze) {
        Stack<MazeCell> visit = new Stack<MazeCell>();

        while (visitedCells < totalCells) {

            current = findCurrentCell();

            makeMaze(current);


            return maze;
        }
    }
    private MazeCell findCurrentCell(){
        Random currentX = new Random();
        Random currentY = new Random();

        int cellX = currentX.nextInt(mazeHeight - 1);
        int cellY = currentY.nextInt(mazeWidth - 1);

        current = new MazeCell(cellX, cellY);
        return current;

    }

    private boolean makeMaze(MazeCell current) {
            this.current = current;

            //get neighbors
            neighbors = findNeighborCells();

            // Chooses a neighbor to visit
            current = chooseNext();

            if (!current.isVisited()) {
                visitedCells++;
                current.setVisited(true);

            }

            if (visitedCells == totalCells) {
                //print maze
            }
        }

        private ArrayList <MazeCell> findNeighborCells(){

            MazeCell top = null;
            MazeCell bottom = null;
            MazeCell left = null;
            MazeCell right = null;


            if ((current.getCellX() - 1) > 0 ++ < mazeHeight) {
                top = new MazeCell(current.getCellX() - 1, current.getCellY());
            }

            if ((current.getCellX() + 1) > 0 ++ < mazeHeight){
                bottom = new MazeCell(current.getCellX() + 1, current.getCellY());
            }

            if ((current.getCellY() - 1) > 0 ++ < mazeHeight) {
                left = new MazeCell(current.getCellX(), current.getCellY() - 1);
            }

            if ((current.getCellX() + 1) > 0 ++ < mazeHeight){
                right = new MazeCell(current.getCellX(), current.getCellY() + 1);
            }

            neighbors.add(top);
            neighbors.add(bottom);
            neighbors.add(left);
            neighbors.add(right);

            return neighbors;

        }

        private MazeCell chooseNext() {
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
    }


}
