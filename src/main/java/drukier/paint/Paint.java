package drukier.paint;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class Paint extends JFrame {

    private Tool lineTool = new LineTool();
    private Tool rectangleTool = new RectangleTool();
    private Tool fillRectangleTool = new FillRectangleTool();
    private Tool eraserTool = new EraserTool();

    private int canvasSize = 600;
    private Canvas canvas = new Canvas(lineTool);
    private SaveImage saveImg;

    public Paint() {
        setTitle("Paint");
        setSize(canvasSize, canvasSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel toolbox = new JPanel();
        toolbox.setLayout(new GridLayout(2, 3));

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
            canvas.Undo();
        });

        JButton color = new JButton("Colors");
        color.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(
                    Paint.this,
                    "Choose Paint Color",
                    canvas.getCurrentColor());
            canvas.setCurrentColor(newColor);
        });

        JButton save = new JButton("Save as PNG");
        save.addActionListener(e -> {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "PNG Images", "png");
            chooser.setFileFilter(filter);
            int fileName = chooser.showSaveDialog(this);
            String file = "";
            if (fileName == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile().toString() + ".png";
            }
            saveImg = new SaveImage(canvasSize, canvas, file);
        });

        toolbox.add(pencil);
        toolbox.add(rectangle);
        toolbox.add(fillRectangle);
        toolbox.add(eraser);
        toolbox.add(undo);
        toolbox.add(color);
        toolbox.add(save);

        panel.add(canvas, BorderLayout.CENTER);
        panel.add(toolbox, BorderLayout.NORTH);

        setContentPane(panel);
    }

    public static void main(String[] args) {
        new Paint().setVisible(true);
    }
}
