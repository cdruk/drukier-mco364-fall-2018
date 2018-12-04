package drukier.paint;

import java.awt.*;

public class FillRectangle extends Shape{

    private int x;
    private int y;
    private int endX;
    private int endY;
    private int width;
    private int height;
    private int topLeftX;
    private int topLeftY;

    public FillRectangle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        setColor(color);
    }

    public void setEndX(int endX) {
        this.endX = endX;
        setWidth(Math.abs(endX - x));
        setTopLeftX();
    }

    public void setEndY(int endY) {
        this.endY = endY;
        setHeight(Math.abs(endY - y));
        setTopLeftY();
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private void setTopLeftX() {
        if (x < endX || x == endX) {
            topLeftX = x;
        } else {
            topLeftX = endX;
            endX = x;
        }
    }

    private void setTopLeftY() {
        if (y < endY || y == endY) {
            topLeftY = y;
        } else {
            topLeftY = endY;
            endY = y;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(topLeftX, topLeftY,
                width, height);
    }
}
