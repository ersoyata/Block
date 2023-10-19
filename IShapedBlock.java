import java.awt.*;

public class IShapedBlock extends Block {
    int[][] shape = {{2, 0}, {2, 0}, {2, 0}};
    Color color = Color.green;
    String number = "2";

    public IShapedBlock() {
        super.setShape(shape);
        super.setColor(color);
        super.setNumber(number);
    }
}
