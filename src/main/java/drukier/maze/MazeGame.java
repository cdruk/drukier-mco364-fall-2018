package drukier.maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazeGame extends JFrame {

    public MazeGame() {
        setTitle("Maze");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        int margin = 10;
        panel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));

        panel.add(new MazeDraw(20,20), BorderLayout.CENTER);

        addKeyListener(new MyKeyAdapter());

        setContentPane(panel);

    }

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {

            if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {

            } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {

            } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {

            }

        }
    }

    public static void main(String[] args) {

            new MazeGame().setVisible(true);
    }
}

