package drukier.paint;

import java.awt.*;

public class Rectangle extends Shape{

    private int x;
    private int y;
    private int endX;
    private int endY;
    private int width;
    private int height;


    public Rectangle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        setColor(color);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
        setWidth(endX - x);
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
        setHeight(endY - y);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
