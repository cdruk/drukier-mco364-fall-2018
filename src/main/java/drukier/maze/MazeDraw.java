package drukier.maze;

import javax.swing.*;
import java.awt.*;

public class MazeDraw extends JComponent {

    Maze maze;
    MazePlayer player;

    int width;
    int height;

    double lineWidth;
    double lineHeight;

    public MazeDraw(Maze maze, MazePlayer player) {
        this.maze = maze;
        this.player = player;
    }

    public MazePlayer getPlayer() {
        return player;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public double getLineHeight() {
        return lineHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {

        height = this.getHeight() - 10;
        width = this.getWidth() - 10;

        lineWidth = width / maze.getMazeWidth();
        lineHeight = height / maze.getMazeHeight();


        g.setColor(Color.black);

        paintMaze(g);
        paintPlayer(g);

    }

    private void paintMaze(Graphics g) {

        for (int x = 0; x < maze.getMazeWidth(); x++) {
            for (int y = 0; y < maze.getMazeHeight(); y++) {

                MazeCell current = maze.getMaze()[x][y];

                double drawX = x * lineWidth;
                double drawY = y * lineHeight;

                if (current.isnWall()) {
                    g.drawLine((int) drawX, (int) drawY, (int) (drawX + lineWidth), (int) drawY);
                }
                if (current.iswWall()) {
                    g.drawLine((int) drawX, (int) drawY, (int) drawX, (int) (drawY + lineHeight));
                }
                if (current.issWall()) {
                    g.drawLine((int) drawX, (int) (drawY + lineHeight), (int) (drawX + lineWidth), (int) (drawY + lineHeight));
                }
                if (current.iseWall()) {
                    g.drawLine((int) (drawX + lineWidth), (int) drawY, (int) (drawX + lineWidth), (int) (drawY + lineHeight));
                }


            }
        }


    }

    protected void paintPlayer(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval((player.getPlayerX() + (int) lineWidth/2), (player.getPlayerY()+ (int) lineHeight/2), 10,10);
    }

}
