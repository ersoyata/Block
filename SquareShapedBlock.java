import java.awt.*;


public class SquareShapedBlock extends Block {
    int[][] squareShape = {{0, 0}, {4, 4}, {4, 4}};
    Color color = Color.red;
    String number = "4";
    
    public SquareShapedBlock() {
        super.setShape(squareShape);
        super.setColor(color);
        super.setNumber(number);
    }

}