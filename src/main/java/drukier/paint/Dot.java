package drukier.paint;

import java.awt.*;

public class Dot {
    private int dotX;
    private int dotY;
    private Color color;

    public Dot(int dotX, int dotY, Color color) {
        this.dotX = dotX;
        this.dotY = dotY;
        this.color = color;
    }

    public int getDotX() {
        return dotX;
    }

    public int getDotY() {
        return dotY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
