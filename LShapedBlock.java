import java.awt.*;


public class LShapedBlock extends Block {
    int[][] lShape = {{1, 0}, {1, 0}, {1, 1}};
    Color color = Color.blue;
    String number = "6";
    
    public LShapedBlock() {
        super.setShape(lShape);
        super.setColor(color);
        super.setNumber(number);
    }

}