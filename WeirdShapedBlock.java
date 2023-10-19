import java.awt.*;

public class WeirdShapedBlock extends Block{
    int[][] shape = {{6, 0}, {6, 6}, {6, 0}};
    Color color = Color.pink;
    String number = "6";
    
    public WeirdShapedBlock() {
        super.setShape(shape);
        super.setColor(color);
        super.setNumber(number);
    }
}
