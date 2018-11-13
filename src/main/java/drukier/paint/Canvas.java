package drukier.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Canvas extends JComponent
        implements MouseListener, MouseMotionListener {

    private ArrayList<Shape> shapes = new ArrayList<>();

    private int currentShape = -1;

    private PaintTool tool = PaintTool.Pencil;

    private Color currentColor = Color.black;

    public Canvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        paintShapes(g);

    }

    private void paintShapes(Graphics g) {

        if (!shapes.isEmpty()) {
            for (Shape shape : shapes) {
                g.setColor(shape.getColor());
                switch (shape.getTool()) {
                    case Pencil:
                        ArrayList<Dot> points = ((Line) shape).getPoints();
                        for (int i = 1; i < points.size(); i++) {
                            g.drawLine(
                                    points.get(i).getDotX(), points.get(i).getDotY(),
                                    points.get(i - 1).getDotX(), points.get(i - 1).getDotY());
                        }
                        break;
                    case Rectangle:
                        Rectangle rectangle = ((Rectangle) shape);
                        g.drawRect(rectangle.getX(), rectangle.getY(),
                                rectangle.getWidth(), rectangle.getHeight());
                        break;
                }
            }
        }


    }

    public void setTool(PaintTool tool) {
        this.tool = tool;
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

        if (tool == PaintTool.Pencil) {
            Line line = new Line(currentColor);
            line.setTool(PaintTool.Pencil);
            ArrayList<Dot> points = new ArrayList<>();
            line.setPoints(points);
            shapes.add(line);
            currentShape++;
        }

        if (tool == PaintTool.Rectangle) {
            Rectangle rect = new Rectangle(e.getX(), e.getY(), currentColor);
            rect.setTool(PaintTool.Rectangle);
            shapes.add(rect);
            currentShape++;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (tool == PaintTool.Rectangle) {
            ((Rectangle) shapes.get(currentShape)).setEndX(e.getX());
            ((Rectangle) shapes.get(currentShape)).setEndY(e.getY());
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!shapes.isEmpty()) {
            if (tool == PaintTool.Pencil) {
                ArrayList<Dot> points = ((Line) shapes.get(currentShape)).getPoints();
                points.add(new Dot(e.getX(), e.getY()));
                repaint();
            }

            if (tool == PaintTool.Rectangle) {
                ((Rectangle) shapes.get(currentShape)).setEndX(e.getX());
                ((Rectangle) shapes.get(currentShape)).setEndY(e.getY());
                repaint();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}