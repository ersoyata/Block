import java.awt.*;
import javax.swing.*;
/**
 * no.
 */

public class Game {
    
    JFrame frame;
    JPanel panel;
    private Table table = new Table();
    private GameThread thread = new GameThread(table);



    void buildGame() {
        frame = new JFrame("Math tetris"); // h.mohayeji.nasrabadi@tue.nl
        frame.setSize(600, 600);
        frame.add(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void run() {
        buildGame();
        //table.spawnBlock();
        thread.start();
    }

    public static void main(String[] args) {
        new Game().run();
    }
}
