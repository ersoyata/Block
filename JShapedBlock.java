import java.awt.*;


public class JShapedBlock extends Block {
    int[][] shape = {{0, 6}, {0, 6}, {6, 6}};
    Color color = Color.magenta;
    String number = "6";
    
    public JShapedBlock() {
        super(new int[][] {{0, 6}, {0, 6}, {6, 6}}, Color.magenta, "6");
        super.setShape(this.shape);
        super.setColor(this.color);
        super.setNumber(this.number);
    }

}