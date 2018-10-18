package drukier.maze;

import javax.swing.*;
import java.awt.*;

public class MazePlayer extends JComponent {

    private int playerX;
    private int playerY;

    private MazeCell playerLocation;

    public MazePlayer(int x, int y, Maze maze) {
        playerX = x;
        playerY = y;

        playerLocation = maze.getMazeCell(playerX,playerY);
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public MazeCell getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(MazeCell playerLocation) {
        this.playerLocation = playerLocation;
    }
}
