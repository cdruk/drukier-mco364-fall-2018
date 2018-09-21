package drukier.maze;

public class MazeCell {

    private int cellX;
    private int cellY;

    private boolean visited = false;

    private boolean nWall = true;
    private boolean sWall = true;

    public boolean isnWall() {
        return nWall;
    }

    public void setnWall(boolean nWall) {
        this.nWall = nWall;
    }

    public boolean issWall() {
        return sWall;
    }

    public void setsWall(boolean sWall) {
        this.sWall = sWall;
    }

    public boolean iseWall() {
        return eWall;
    }

    public void seteWall(boolean eWall) {
        this.eWall = eWall;
    }

    public boolean iswWall() {
        return wWall;
    }

    public void setwWall(boolean wWall) {
        this.wWall = wWall;
    }

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
