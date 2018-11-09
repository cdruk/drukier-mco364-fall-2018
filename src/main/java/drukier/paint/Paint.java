package drukier.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paint extends JFrame {

    private Canvas canvas = new Canvas();


    public Paint() {
        setTitle("Paint");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton button = new JButton("Colors");
        button.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(
                    Paint.this,
                    "Choose Background Color",
                    canvas.getCurrentColor());
            canvas.setCurrentColor(newColor);
        });

        panel.add(canvas, BorderLayout.CENTER);
        panel.add(button, BorderLayout.NORTH);

        setContentPane(panel);
    }


    public static void main(String[] args) {
        new Paint().setVisible(true);
    }
}
