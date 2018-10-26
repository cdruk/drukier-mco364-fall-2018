package drukier.paint;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JComponent {

    private int height;
    private int width;

    private int dotX;
    private int dotY;

    public Canvas(int height, int width) {
        this.height = height;
        this.width = width;

    }

    public void setLoc(int dotX, int dotY) {
        this.dotX = dotX;
        this.dotY = dotY;
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, width, height);

        paintDot(g);

    }

    private void paintDot(Graphics g){

        g.setColor(Color.BLACK);
        g.fillRect(dotX, dotY,1,1);

    }

}
