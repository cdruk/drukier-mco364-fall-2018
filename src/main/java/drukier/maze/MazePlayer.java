package drukier.maze;

import javax.swing.*;
import java.awt.*;

public class MazePlayer extends JComponent {

    int playerX;
    int playerY;

    public MazePlayer(int x, int y) {
        playerX = x;
        playerY = y;

    }

    protected void paintPlayer(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(playerX, playerY, 10,10);
    }
}
