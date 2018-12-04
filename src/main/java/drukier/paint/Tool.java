package drukier.paint;

import java.awt.*;

interface Tool {

    Shape getShape();
    void onPress(int x, int y, Color color);
    void onDrag(int x, int y);
    void onRelease(int x, int y);

}
