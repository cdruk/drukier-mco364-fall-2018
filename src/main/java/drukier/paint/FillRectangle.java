package drukier.paint;

import java.awt.*;

public class FillRectangle extends Shape{

    private int x;
    private int y;
    private int endX;
    private int endY;

    FillRectangle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        setColor(color);
    }

    void setEndX(int endX) {
        this.endX = endX;
    }

    void setEndY(int endY) {
        this.endY = endY;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(Math.min(x, endX), Math.min(y, endY),
                Math.abs(endX - x), Math.abs(endY - y));
    }
}
