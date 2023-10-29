import java.awt.*;

public class TShapedBlock extends Block{
    int[][] shape = {{0, 8}, {8, 8}, {0, 8}};
    Color color = Color.orange;
    String number = "8";
    
    public TShapedBlock() {
        super(new int[][] {{0, 8}, {8, 8}, {0, 8}}, Color.orange, "8");
    }
}