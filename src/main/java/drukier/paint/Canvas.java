package drukier.paint;

import drukier.paint.shapes.Shape;
import drukier.paint.tools.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Canvas extends JComponent
        implements MouseListener, MouseMotionListener {

    private ArrayList<Shape> shapes = new ArrayList<>();
    private Tool tool;
    private Color currentColor = Color.black;

    public Canvas(Tool tool) {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setTool(tool);
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        BufferedImage image =
                new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics imageGraphics = image.createGraphics();

        drawCanvas(image, imageGraphics);

        paintShapes(image, imageGraphics);

    }

    private void drawCanvas(BufferedImage image, Graphics imageGraphics) {
        imageGraphics.setColor(Color.WHITE);
        imageGraphics.fillRect(0, 0, getWidth(), getHeight());
    }

    private void paintShapes(BufferedImage image, Graphics imageGraphics) {
        for (Shape shape : shapes) {
            shape.paint(image, imageGraphics);
        }
    }

    void setTool(Tool tool) {
        this.tool = tool;
    }

    Color getCurrentColor() {
        return currentColor;
    }

    void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    void Undo() {
        if (!shapes.isEmpty()) {
            int undoShape = shapes.size() - 1;
            shapes.remove(undoShape);
            repaint();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        tool.onPress(e.getX(), e.getY(), currentColor);
        shapes.add(tool.getShape());

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        tool.onRelease(e.getX(), e.getY());
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        tool.onDrag(e.getX(), e.getY());
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}