import java.awt.*;

public class WeirdShapedBlock extends Block{
    int[][] shape = {{8, 0}, {8, 8}, {8, 0}};
    Color color = Color.pink;
    String number = "8";
    
    public WeirdShapedBlock() {
        super.setShape(shape);
        super.setColor(color);
        super.setNumber(number);
    }
}
