package drukier.maze;

import javax.swing.*;
import java.awt.*;

class MazePlayer extends JComponent {

    private int playerX;
    private int playerY;

    private MazeCell playerLocation;

    MazePlayer(int x, int y, Maze maze) {
        playerX = x;
        playerY = y;

        playerLocation = maze.getMazeCell(playerX,playerY);
    }

    int getPlayerX() {
        return playerX;
    }

    void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    int getPlayerY() {
        return playerY;
    }

    void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    MazeCell getPlayerLocation() {
        return playerLocation;
    }

    void setPlayerLocation(MazeCell playerLocation) {
        this.playerLocation = playerLocation;
    }
}
