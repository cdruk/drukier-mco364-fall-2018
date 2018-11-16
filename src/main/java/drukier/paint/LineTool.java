package drukier.paint;

import java.awt.*;
import java.util.ArrayList;

public class LineTool implements Tool {

    private Line line;
    //private ArrayList<Dot> points = new ArrayList<>();

    public LineTool() {

    }

    @Override
    public Line getShape() {
        return line;
    }

    @Override
    public void onPress(int x, int y, Color color) {
        line = new Line(color);
        ArrayList<Dot> points = new ArrayList<>();
        line.setPoints(points);
    }

    @Override
    public void onDrag(int x, int y) {
        ArrayList<Dot> points = line.getPoints();
        points.add(new Dot(x, y));
    }

    @Override
    public void onRelease(int x, int y) {

    }
}
