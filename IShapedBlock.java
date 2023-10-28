import java.awt.*;

public class IShapedBlock extends Block {
    int[][] shape = {{2, 0}, {2, 0}, {2, 0}};
    Color color = Color.green;
    String number = "2";

    public IShapedBlock() {
        // this.shape = shape;
        // this.color = color;
        // this.number = number;
        //super(new int[][] {{2, 0}, {2, 0}, {2, 0}}, Color.green, "2");
        super(new int[][] {{2} , {2}, {2}}, Color.green, "2");
    //     super.setShape(this.shape);
    //     super.setColor(this.color);
    //     super.setNumber(this.number);
    }
}
