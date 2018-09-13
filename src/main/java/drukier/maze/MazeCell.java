package drukier.maze;

public class MazeCell {

    private int cellY;
    private int cellX;

    private boolean visited = false;

    public MazeCell(int cellX, int cellY){
        this.cellY = cellX;
        this.cellX = cellY;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getCellY() {
        return cellY;
    }

    public void setCellY(int cellY) {
        this.cellY = cellY;
    }

    public int getCellX() {
        return cellX;
    }

    public void setCellX(int cellX) {
        this.cellX = cellX;
    }
}
