package drukier.paint;

import java.awt.*;

public class FillRectangleTool implements Tool {

    private FillRectangle fillRectangle;

    public FillRectangleTool() {
    }

    @Override
    public Shape getShape() {
        return fillRectangle;
    }

    @Override
    public void onPress(int x, int y, Color color) {
        fillRectangle = new FillRectangle(x, y, color);
    }

    @Override
    public void onDrag(int x, int y) {
        fillRectangle.setEndX(x);
        fillRectangle.setEndY(y);
    }

    @Override
    public void onRelease(int x, int y) {
        fillRectangle.setEndX(x);
        fillRectangle.setEndY(y);
    }
}
