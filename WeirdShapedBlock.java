import java.awt.*;

public class WeirdShapedBlock extends Block{
    int[][] shape = {{8, 0}, {8, 8}, {8, 0}};
    Color color = Color.pink;
    String number = "8";
    
    public WeirdShapedBlock() {
        super(new int[][] {{8, 0}, {8, 8}, {8, 0}}, Color.pink, "8");
        // super.setShape(this.shape);
        // super.setColor(this.color);
        // super.setNumber(this.number);
    }
}
