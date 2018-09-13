package drukier.maze;

public class MazeCell {

    private int cellX;
    private int cellY;

    private boolean visited = false;

    private boolean nWall = true;
    private boolean sWall = true;
    private boolean eWall = true;
    private boolean wWall = true;

    public MazeCell(int cellX, int cellY){
        this.cellX = cellX;
        this.cellY = cellY;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }
}
