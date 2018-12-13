package drukier.paint;

import java.awt.*;

public class RectangleTool implements Tool {

    private Rectangle rectangle;

    RectangleTool() {
    }

    @Override
    public Rectangle getShape() {
        return rectangle;
    }

    @Override
    public void onPress(int x, int y, Color color) {
        rectangle = new Rectangle(x, y, color);
    }

    @Override
    public void onDrag(int x, int y) {
        rectangle.setEndX(x);
        rectangle.setEndY(y);
    }

    @Override
    public void onRelease(int x, int y) {
        rectangle.setEndX(x);
        rectangle.setEndY(y);
    }
}
