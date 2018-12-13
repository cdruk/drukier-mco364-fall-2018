package drukier.paint;

import java.io.Serializable;

public class Dot implements Serializable {
    private int dotX;
    private int dotY;

    Dot(int dotX, int dotY) {
        this.dotX = dotX;
        this.dotY = dotY;
    }

    int getDotX() {
        return dotX;
    }

    int getDotY() {
        return dotY;
    }
}
