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

        panel.add(new MazeDraw(), BorderLayout.CENTER);


        setContentPane(panel);

    }

    public static void main(String[] args) {
        new MazeGame().setVisible(true);
    }

}
