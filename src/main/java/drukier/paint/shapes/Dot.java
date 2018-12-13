package drukier.paint.shapes;

import java.io.Serializable;

public class Dot implements Serializable {
    private int dotX;
    private int dotY;

    public Dot(int dotX, int dotY) {
        this.dotX = dotX;
        this.dotY = dotY;
    }

    public int getDotX() {
        return dotX;
    }

    public int getDotY() {
        return dotY;
    }
}
