import java.awt.*;

/**
 * A type of block with a number and a unique colour used in our game.
 * @author Szymon Ptas <1934066>
 * @author Ersoy Ata Baki <1971131>
 */
public class SquareShapedBlock extends Block {
    int[][] squareShape = {{0, 0}, {4, 4}, {4, 4}};
    Color color = Color.red;
    String number = "4";
    
    /**
     * Constructor which uses super class counstructor (with super) 
     * to created unique shape of block.
     */
    public SquareShapedBlock() {
        super(new int[][] {{4, 4}, {4, 4}}, Color.red, "4");
    }

}