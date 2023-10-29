import java.awt.*;

/**
 * A type of block with a number and a unique colour used in our game.
 * @author Szymon Ptas <1934066>
 * @author Ersoy Ata Baki <1971131>
 */
public class LShapedBlock extends Block {
    int[][] shape = {{6, 0}, {6, 0}, {6, 6}};
    Color color = Color.blue;
    String number = "6";
    
    /**
     * Constructor which uses super class counstructor (with super) 
     * to created unique shape of block.
     */
    public LShapedBlock() {
        super(new int[][] {{6, 0}, {6, 0}, {6, 6}}, Color.blue, "6");

    }

}