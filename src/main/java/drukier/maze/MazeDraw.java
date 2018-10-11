package drukier.maze;

import javax.swing.*;
import java.awt.*;

public class MazeDraw extends JComponent {

    Maze myMaze;
    int height;
    int width;

    int lineHeight;
    int lineWidth;

    @Override
    protected void paintComponent(Graphics g) {

        myMaze = new Maze(10, 10);

            height = this.getHeight();
            width = this.getWidth();

            g.setColor(Color.black);

            paintMaze(g);

        }

        void paintMaze (Graphics g){
           g.drawLine(1, 2, 3, 4);

            }


        }
