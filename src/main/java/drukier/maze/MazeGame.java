package drukier.maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazeGame extends JFrame {

    Maze maze;
    MazePlayer player;
    MazeDraw mazeDraw;
    int mazeWidth = 20;
    int mazeHeight = 20;

    public MazeGame() {
        setTitle("Maze");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        setResizable(false);

        panel.setLayout(new BorderLayout());

        int margin = 10;
        panel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));

        maze = new Maze(mazeWidth, mazeHeight);
        player = new MazePlayer(0, 0, maze);
        mazeDraw = new MazeDraw(maze, player);
        panel.add(mazeDraw, BorderLayout.CENTER);

        addKeyListener(new MyKeyAdapter());

        setContentPane(panel);

    }

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {

            redrawPlayer(keyEvent.getKeyCode());
        }
    }

    private void redrawPlayer(int direction) {
        player = mazeDraw.getPlayer();

        switch (direction) {
            case KeyEvent.VK_UP:
                movePlayer(player, direction);
                break;
            case KeyEvent.VK_DOWN:
                movePlayer(player, direction);
                break;
            case KeyEvent.VK_RIGHT:
                movePlayer(player, direction);
                break;
            case KeyEvent.VK_LEFT:
                movePlayer(player, direction);
                break;
        }

    }

    private void movePlayer(MazePlayer myPlayer, int direction) {
        MazeCell first = maze.getMazeCell(0,0);
        MazeCell last = maze.getMazeCell(mazeWidth - 1, mazeHeight - 1);
        switch (direction) {
            case KeyEvent.VK_UP:
                if (!myPlayer.getPlayerLocation().isnWall()) {
                    player.setPlayerY(player.getPlayerY() - (int) mazeDraw.getLineHeight());
                    updatePlayerLocation(player.getPlayerLocation().getCellX(), (player.getPlayerLocation().getCellY() - 1));
                    mazeDraw.repaint();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!myPlayer.getPlayerLocation().issWall()) {
                    player.setPlayerY(player.getPlayerY() + (int) mazeDraw.getLineHeight());
                    updatePlayerLocation(player.getPlayerLocation().getCellX(), (player.getPlayerLocation().getCellY() + 1));
                    mazeDraw.repaint();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!myPlayer.getPlayerLocation().iseWall() && myPlayer.getPlayerLocation() != last) {
                    player.setPlayerX(player.getPlayerX() + (int) mazeDraw.getLineWidth());
                    updatePlayerLocation(player.getPlayerLocation().getCellX() + 1, (player.getPlayerLocation().getCellY()));
                    mazeDraw.repaint();
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!myPlayer.getPlayerLocation().iswWall() && myPlayer.getPlayerLocation() != first) {
                    player.setPlayerX(player.getPlayerX() - (int) mazeDraw.getLineWidth());
                    updatePlayerLocation(player.getPlayerLocation().getCellX() - 1, (player.getPlayerLocation().getCellY()));
                    mazeDraw.repaint();
                }
                break;
        }


    }

    private void updatePlayerLocation(int x, int y) {

        player.setPlayerLocation(maze.getMazeCell(x, y));
    }

    public static void main(String[] args) {

        new MazeGame().setVisible(true);
    }
}

