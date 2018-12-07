package drukier.paint;

import java.awt.*;
import java.util.ArrayList;

public class Eraser extends Shape{
    private ArrayList<Dot> points;

    public Eraser() {
        setColor(Color.white);
    }

    public ArrayList<Dot> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Dot> points) {
        this.points = points;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 1; i < points.size(); i++) {
//            Graphics2D g2 = (Graphics2D) g;
//            g2.setStroke(new BasicStroke(5));
            g.drawLine(
                    points.get(i).getDotX(), points.get(i).getDotY(),
                    points.get(i - 1).getDotX(), points.get(i - 1).getDotY());
        }
    }
}
