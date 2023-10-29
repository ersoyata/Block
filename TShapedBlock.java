import java.awt.*;

/**
 * A type of block with a number and a unique colour used in our game.
 * @author Szymon Ptas <1934066>
 * @author Ersoy Ata Baki <1971131>
 */
public class TShapedBlock extends Block {
    int[][] shape = {{0, 8}, {8, 8}, {0, 8}};
    Color color = Color.orange;
    String number = "8";
    
    /**
     * Constructor which uses super class counstructor (with super) 
     * to created unique shape of block.
     */
    public TShapedBlock() {
        super(new int[][] {{0, 8}, {8, 8}, {0, 8}}, Color.orange, "8");
    }
}