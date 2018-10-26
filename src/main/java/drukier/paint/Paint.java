package drukier.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Paint extends JFrame {

    private int canvasHeight = 550;
    private int canvasWidth = 550;

    private Canvas canvas = new Canvas(canvasHeight, canvasWidth);

    public Paint() {
        setTitle("Paint");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(canvas);

        canvas.addMouseMotionListener(pencilDrag);

        setContentPane(panel);
    }

    MouseMotionListener pencilDrag = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {
            canvas.setLoc(e.getX(), e.getY());
            repaint();

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    };

    public static void main(String [] args){
        new Paint().setVisible(true);
    }
}
