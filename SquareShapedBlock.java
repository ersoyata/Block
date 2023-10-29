import java.awt.*;


public class SquareShapedBlock extends Block {
    int[][] squareShape = {{0, 0}, {4, 4}, {4, 4}};
    Color color = Color.red;
    String number = "4";
    
    public SquareShapedBlock() {
        super(new int[][] {{4, 4}, {4, 4}}, Color.red, "4");
    }

}