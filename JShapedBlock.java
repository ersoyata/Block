import java.awt.*;

/**
 * A type of block with a number and a unique colour used in our game.
 * @author Szymon Ptas <1934066>
 * @author Ersoy Ata Baki <1971131>
 */
public class JShapedBlock extends Block {
    int[][] shape = {{0, 6}, {0, 6}, {6, 6}};
    Color color = Color.magenta;
    String number = "6";
    
    /**
     * Constructor which uses super class counstructor (with super) 
     * to created unique shape of block.
     */
    public JShapedBlock() {
        super(new int[][] {{0, 6}, {0, 6}, {6, 6}}, Color.magenta, "6");
    }

}