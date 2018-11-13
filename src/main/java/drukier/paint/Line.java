package drukier.paint;

import java.awt.*;
import java.util.ArrayList;

public class Line extends Shape{
    private ArrayList<Dot> points;

    public Line(Color color) {
        setColor(color);
    }


    public ArrayList<Dot> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Dot> points) {
        this.points = points;
    }
}
