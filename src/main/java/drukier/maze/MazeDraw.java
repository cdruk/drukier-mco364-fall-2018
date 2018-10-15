package drukier.maze;

import javax.swing.*;
import java.awt.*;

public class MazeDraw extends JComponent {

    Maze myMaze;
    int width;
    int height;

    int lineWidth;
    int lineHeight;

    @Override
    protected void paintComponent(Graphics g) {

        myMaze = new Maze(10, 10);

        height = this.getHeight();
        width = this.getWidth();

        lineWidth = width/myMaze.getMazeWidth();
        lineHeight = height/myMaze.getMazeHeight();


        g.setColor(Color.black);

        paintMaze(g);

    }

    void paintMaze(Graphics g) {

        for (int x = 0; x < myMaze.getMazeWidth(); x++) {
            for (int y = 0; y < myMaze.getMazeHeight(); y++) {

                MazeCell current = myMaze.getMaze()[x][y];

                int drawX = x * lineWidth;
                int drawY = y * lineHeight;

                if(current.isnWall()){
                    g.drawLine(drawX, drawY, drawX + lineWidth, drawY);
                }
                if(current.iswWall()) {
                    g.drawLine(drawX, drawY, drawX, drawY +lineHeight);
                }
                if(current.issWall()) {
                    g.drawLine(drawX, drawY + lineHeight, drawX + lineWidth, drawY + lineHeight);
                }
                if(current.iseWall()) {
                    g.drawLine(drawX + lineWidth, drawY, drawX + lineWidth, drawY + lineHeight);
                }


            }
        }


    }
}
