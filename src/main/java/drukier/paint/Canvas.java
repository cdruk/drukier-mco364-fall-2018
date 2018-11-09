package drukier.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Canvas extends JComponent
        implements MouseListener, MouseMotionListener {


    private ArrayList<ArrayList<Dot>> lines = new ArrayList<>();

    private ArrayList<Dot> points;

    private Color currentColor = Color.black;

    public Canvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        paintDot(g);

    }

    private void paintDot(Graphics g) {

//        g.setColor(Color.BLACK);
        for (ArrayList<Dot> points : lines) {
            for (int i = 1; i < points.size(); i++) {
                Color currentColor = points.get(i).getColor();
               g.setColor(currentColor);
                g.drawLine(
                        points.get(i).getDotX(), points.get(i).getDotY(),
                        points.get(i - 1).getDotX(), points.get(i - 1).getDotY());
            }
        }
    }


    public void setLines(ArrayList<ArrayList<Dot>> lines) {
        this.lines = lines;
    }

    public ArrayList<Dot> getLines() {
        return points;
    }

    public ArrayList<Dot> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Dot> points) {
        this.points = points;
    }


    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        lines.add(new ArrayList<>());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!lines.isEmpty()) {
            lines.get(lines.size()-1)
                    .add(new Dot(e.getX(), e.getY(), currentColor));
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}