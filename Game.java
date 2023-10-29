import java.awt.event.*;
import javax.swing.*;

/**
 * Game is a class where the main frame is created with all of the features 
 * from Table class as well as it starts a thread in GameThread class.
 * Also, keybindings which allow the user to move blocks are created.
 * 
 * @author Szymon Ptas <1934066>
 * @author Ersoy Ata Baki <1971131>
 */

public class Game {
    
    private JFrame frame;

    private Table table = new Table();
    private GameThread thread = new GameThread(table);

    /**
     * buildGame is a method which creates the main frame of the game
     * and adds table in which the game is played.
     */
    public void buildGame() {
        frame = new JFrame("Math tetris");
        frame.setSize(330, 480);
        frame.add(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        keyBindings();

    }

    /**
     * run method builds the game and starts a thread.
     */
    public void run() {
        buildGame();
        thread.start();
    }
    
    /**
     * keyBindings give a possibility of moving blocks to the user.
     * The method is created with AbstractAction class.
     */
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