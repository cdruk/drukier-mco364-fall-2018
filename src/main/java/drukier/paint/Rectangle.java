package drukier.paint;

import java.awt.*;

public class Rectangle extends Shape {

    private int x;
    private int y;
    private int endX;
    private int endY;
    private int width;
    private int height;
    private int topLeftX;
    private int topLeftY;


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
        setWidth(Math.abs(endX - x));
        setTopLeftX();
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
        setHeight(Math.abs(endY - y));
        setTopLeftY();
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

    public void setTopLeftX() {
        if (x < endX || x == endX) {
            topLeftX = x;
        } else {
            topLeftX = endX;
            endX = x;
        }
    }

    public void setTopLeftY() {
        if (y < endY || y == endY) {
            topLeftY = y;
        } else {
            topLeftY = endY;
            endY = y;
        }
    }

    public int getTopLeftX() {
        return topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }
}
