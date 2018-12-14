package drukier.paint.tools;

import drukier.paint.shapes.Dot;
import drukier.paint.shapes.Eraser;
import java.awt.*;
import java.util.ArrayList;

public class EraserTool implements Tool {

    private Eraser eraser;

    public EraserTool() {

    }

    @Override
    public Eraser getShape() {
        return eraser;
    }

    @Override
    public void onPress(int x, int y, Color color) {
        eraser = new Eraser();
        ArrayList<Dot> points = new ArrayList<>();
        eraser.setPoints(points);
    }

    @Override
    public void onDrag(int x, int y) {
        ArrayList<Dot> points = eraser.getPoints();
        points.add(new Dot(x, y));
    }

    @Override
    public void onRelease(int x, int y) {

    }
}
