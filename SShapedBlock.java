import java.awt.*;

/**
 * A type of block with a number and a unique colour used in our game.
 * @author Szymon Ptas <1934066>
 * @author Ersoy Ata Baki <1971131>
 */
public class SShapedBlock extends Block {
    int[][] shape = {{0, 8}, {8, 8}, {8, 0}};
    Color color = Color.yellow;
    String number = "8";
    
    /**
     * Constructor which uses super class counstructor (with super) 
     * to created unique shape of block.
     */
    public SShapedBlock() {
        super(new int[][] {{0, 8}, {8, 8}, {8, 0}}, Color.yellow, "8");
    }

}