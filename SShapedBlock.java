import java.awt.*;


public class SShapedBlock extends Block {
    int[][] shape = {{0, 8}, {8, 8}, {8, 0}};
    Color color = Color.yellow;
    String number = "8";
    
    public SShapedBlock() {
        super(new int[][] {{0, 8}, {8, 8}, {8, 0}}, Color.yellow, "8");
    }

}