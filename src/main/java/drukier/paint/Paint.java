package drukier.paint;

import drukier.paint.save.OpenEditableImage;
import drukier.paint.save.SaveEditableImage;
import drukier.paint.save.SaveImage;
import drukier.paint.tools.*;

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

    private Paint() {
        setTitle("Paint");
        setSize(canvasSize, canvasSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel toolbox = new JPanel();
        toolbox.setLayout(new GridLayout(3, 0));

        JButton pencil = new JButton("Pencil");
        pencil.addActionListener(e -> canvas.setTool(lineTool));

        JButton rectangle = new JButton("Rectangle");
        rectangle.addActionListener(e -> canvas.setTool(rectangleTool));


        JButton fillRectangle = new JButton("Filled Rectangle");
        fillRectangle.addActionListener(e -> canvas.setTool(fillRectangleTool));

        JButton eraser = new JButton("Eraser");
        eraser.addActionListener(e -> canvas.setTool(eraserTool));

        JButton undo = new JButton("Undo");
        undo.addActionListener(e -> canvas.Undo());

        JButton color = new JButton("Colors");
        color.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(
                    Paint.this,
                    "Choose Paint Color",
                    canvas.getCurrentColor());
            canvas.setCurrentColor(newColor);
        });

        JButton save = new JButton("Save as PNG");
        save.addActionListener(e -> saveAsPNG());


        JButton saveEditable = new JButton("Save as Paint File");
        saveEditable.addActionListener(e -> saveAsPaint());

        JButton openEditable = new JButton("Open Paint File");
        openEditable.addActionListener(e -> openAsPaint());

        toolbox.add(pencil);
        toolbox.add(rectangle);
        toolbox.add(fillRectangle);
        toolbox.add(color);

        toolbox.add(eraser);
        toolbox.add(undo);

        toolbox.add(save);
        toolbox.add(saveEditable);
        toolbox.add(openEditable);

        panel.add(canvas, BorderLayout.CENTER);
        panel.add(toolbox, BorderLayout.NORTH);

        setContentPane(panel);
    }

    private void saveAsPNG() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG Images", "png");
        chooser.setFileFilter(filter);
        int fileName = chooser.showSaveDialog(this);
        String file;
        if (fileName == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile().toString() + ".png";
            new SaveImage(canvasSize, canvas, file);
        }
    }

    private void saveAsPaint() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Paint File", "ser");
        chooser.setFileFilter(filter);
        int fileName = chooser.showSaveDialog(this);
        String file;
        if (fileName == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile().toString() + ".ser";
            new SaveEditableImage(canvas, file);
        }
    }

    private void openAsPaint() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Paint File", "ser");
        chooser.setFileFilter(filter);
        int fileName = chooser.showOpenDialog(this);
        String file;
        if (fileName == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile().toString();
            new OpenEditableImage(canvas, file);
        }
    }

    public static void main(String[] args) {
        new Paint().setVisible(true);
    }
}
