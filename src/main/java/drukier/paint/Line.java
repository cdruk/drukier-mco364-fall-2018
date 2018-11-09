package drukier.paint;

import java.awt.*;
import java.util.ArrayList;

public class Line extends Shape{
    private ArrayList<Dot> points;

    @Override
    public void setColor(Color color) {
        setColor(color);
    }

    public ArrayList<Dot> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Dot> points) {
        this.points = points;
    }
}
