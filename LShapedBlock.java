import java.awt.*;


public class LShapedBlock extends Block {
    int[][] lShape = {{6, 0}, {6, 0}, {6, 6}};
    Color color = Color.blue;
    String number = "6";
    
    public LShapedBlock() {
        super.setShape(lShape);
        super.setColor(color);
        super.setNumber(number);
    }

}