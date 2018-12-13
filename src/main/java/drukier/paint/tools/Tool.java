package drukier.paint.tools;

import drukier.paint.shapes.Shape;

import java.awt.*;

public interface Tool {

    Shape getShape();
    void onPress(int x, int y, Color color);
    void onDrag(int x, int y);
    void onRelease(int x, int y);

}
