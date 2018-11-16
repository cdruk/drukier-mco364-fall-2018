package drukier.paint;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;

public class Paint extends JFrame {

    private Canvas canvas = new Canvas();


    public Paint() {
        setTitle("Paint");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel toolbox = new JPanel();
        toolbox.setLayout(new GridLayout());

        JButton pencil = new JButton("Pencil");
        pencil.addActionListener(e ->{canvas.setTool(new LineTool());});

        JButton rectangle = new JButton("Rectangle");
        rectangle.addActionListener(e ->{canvas.setTool(new RectangleTool());});

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
        toolbox.add(color);

        panel.add(canvas, BorderLayout.CENTER);
        panel.add(toolbox, BorderLayout.NORTH);

        setContentPane(panel);
    }


    public static void main(String[] args) {
        new Paint().setVisible(true);
    }
}
