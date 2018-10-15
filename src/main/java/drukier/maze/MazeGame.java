package drukier.maze;

import javax.swing.*;
import java.awt.*;

public class MazeGame extends JFrame {
    public MazeGame() {
        setTitle("Maze");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        int margin = 10;
        panel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));

        panel.add(new MazeDraw(), BorderLayout.CENTER);


        setContentPane(panel);

    }

    public static void main(String[] args) {
        new MazeGame().setVisible(true);
    }

}
