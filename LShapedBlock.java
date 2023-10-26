import java.awt.*;


public class LShapedBlock extends Block {
    int[][] shape = {{6, 0}, {6, 0}, {6, 6}};
    Color color = Color.blue;
    String number = "6";
    
    public LShapedBlock() {
        super(new int[][] {{6, 0}, {6, 0}, {6, 6}}, Color.blue, "6");
        super.setShape(this.shape);
        super.setColor(this.color);
        super.setNumber(this.number);
    }

}