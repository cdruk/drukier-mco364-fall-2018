package drukier.maze;

public class MazeCell {

    private int cellY;
    private int cellX;

    private boolean visited = false;

    private boolean nWall = true;
    private boolean sWall = true;
    private boolean eWall = true;
    private boolean wWall = true;

    private MazeCell next;

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

    public MazeCell(int cellY, int cellX){
        this.cellY = cellY;
        this.cellX = cellX;
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

    public int getCellX() {
        return cellX;
    }

    public MazeCell getNext() {
        return next;
    }

    public void setNext(MazeCell next) {
        this.next = next;
    }
}
