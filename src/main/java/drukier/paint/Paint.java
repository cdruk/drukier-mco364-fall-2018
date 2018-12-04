package drukier.paint;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;

public class Paint extends JFrame {


    private Tool lineTool = new LineTool();
    private Tool rectangleTool = new RectangleTool();
    private Tool fillRectangleTool = new FillRectangleTool();
    private Tool eraserTool = new EraserTool();
    private Canvas canvas = new Canvas(lineTool);

    public Paint() {
        setTitle("Paint");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel toolbox = new JPanel();
        toolbox.setLayout(new GridLayout(2,3));

        JButton pencil = new JButton("Pencil");
        pencil.addActionListener(e -> {
            canvas.setTool(lineTool);
        });

        JButton rectangle = new JButton("Rectangle");
        rectangle.addActionListener(e -> {
            canvas.setTool(rectangleTool);
        });

        JButton fillRectangle = new JButton("Filled Rectangle");
        fillRectangle.addActionListener(e -> {
            canvas.setTool(fillRectangleTool);
        });

        JButton eraser = new JButton("Eraser");
        eraser.addActionListener(e -> {
            canvas.setTool(eraserTool);
        });

        JButton undo = new JButton("Undo");
        undo.addActionListener(e -> {
            Undo();
        });

        JButton color = new JButton("Colors");
        color.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(
                    Paint.this,
                    "Choose Paint Color",
                    canvas.getCurrentColor());
            canvas.setCurrentColor(newColor);
        });

        toolbox.add(pencil);
        toolbox.add(rectangle);
        toolbox.add(fillRectangle);
        toolbox.add(eraser);
        toolbox.add(undo);
        toolbox.add(color);

        panel.add(canvas, BorderLayout.CENTER);
        panel.add(toolbox, BorderLayout.NORTH);

        setContentPane(panel);
    }

    private void Undo() {
        if (!canvas.getShapes().isEmpty()) {
            int undoShape = canvas.getShapes().size() - 1;
            canvas.getShapes().remove(undoShape);
            repaint();
        }
    }


    public static void main(String[] args) {
        new Paint().setVisible(true);
    }
}
