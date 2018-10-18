package drukier.maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazeDraw extends JComponent {

    Maze myMaze;
    MazePlayer player;

    int width;
    int height;

    double lineWidth;
    double lineHeight;

    public MazeDraw(int mazeWidth,int mazeHeight) {
        myMaze = new Maze(mazeWidth, mazeHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {

        height = this.getHeight();
        width = this.getWidth();

        lineWidth = width / myMaze.getMazeWidth();
        lineHeight = height / myMaze.getMazeHeight();


        g.setColor(Color.black);

        paintMaze(g);
        player = new MazePlayer(myMaze.getStart().getCellX() + (int) lineWidth/2,
                myMaze.getStart().getCellY() + (int) lineHeight/2);
        player.paintPlayer(g);

    }

    private void paintMaze(Graphics g) {

        for (int x = 0; x < myMaze.getMazeWidth(); x++) {
            for (int y = 0; y < myMaze.getMazeHeight(); y++) {

                MazeCell current = myMaze.getMaze()[x][y];

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

}
