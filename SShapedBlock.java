import java.awt.*;


public class SShapedBlock extends Block {
    int[][] sShape = {{0, 8}, {8, 8}, {8, 0}};
    Color color = Color.yellow;
    String number = "8";
    
    public SShapedBlock() {
        super.setShape(sShape);
        super.setColor(color);
        super.setNumber(number);
    }

}