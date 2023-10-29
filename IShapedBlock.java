import java.awt.*;

/**
 * A type of block with a number and a unique colour used in our game.
 * @author Szymon Ptas <1934066>
 * @author Ersoy Ata Baki <1971131>
 */
public class IShapedBlock extends Block {
    int[][] shape = {{2, 0}, {2, 0}, {2, 0}};
    Color color = Color.green;
    String number = "2";
    
    /**
     * Constructor which uses super class counstructor (with super) 
     * to created unique shape of block.
     */
    public IShapedBlock() {
        super(new int[][] {{2}, {2}, {2}}, Color.green, "2");
    }
}
