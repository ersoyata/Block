import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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
        frame.setSize(330, 480);
        frame.add(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        keyBindings();

    }

    public void run() {
        buildGame();
        thread.start();
    }
    
    private void keyBindings() {

        InputMap iMap;
        ActionMap aMap;

        iMap = frame.getRootPane().getInputMap();
        aMap = frame.getRootPane().getActionMap();

        iMap.put(KeyStroke.getKeyStroke("LEFT"), "left");
        iMap.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        iMap.put(KeyStroke.getKeyStroke("UP"), "up");

        aMap.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.moveToRight();
            }
        });

        aMap.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.moveToLeft();
            }
        });

    }

    public static void main(String[] args) {
        new Game().run();
    }
}
