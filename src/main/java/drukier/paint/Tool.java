package drukier.paint;

import java.awt.*;

interface Tool {

    void onPress(int x, int y, Color color);
    Shape getShape();
    void onDrag(int x, int y);
    void onRelease(int x, int y);

}
