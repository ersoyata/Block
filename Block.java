import java.awt.*;

/**
 * Block is a class with basic operations on every spawned block.
 * It includes especially all getters and setters methods and the class is later 
 * inheritated by specific blocks.
 * 
 * @author Szymon Ptas <1934066>
 * @author Ersoy Ata Baki <1971131>
 */

public class Block {
    private int[][] shape;
    private Color color;
    private String number;
    private int x;
    private int y;

    /**
     * Block is a constructor which takes 3 parameters used to create specific blocks.
     * @param shape is two dimensional array which stores the cells that a block is
     *      currenty occuping.
     * @param color is type Color which stores specific color for every block.
     * @param number is integer which stores a number of every block and puts it in the game area.
     */
    public Block(int[][] shape, Color color, String number) {
        this.shape = shape;
        this.color = color;
        this.number = number;
        y = -getHeight();
        x = 3;
    } 

    public int[][] getShape() {
        return shape;
    }
    
    public Color getColor() {
        return color;
    }

    public int getHeight() {
        return shape.length;
    }

    public int getWidth() {
        return shape[0].length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void fall() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void setShape(int[][] newShape) {
        this.shape = newShape;
    }
    
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public String getNumber() {
        return number;
    }
    
    public void setNumber(String newNumber) {
        this.number = newNumber;
    }

    public int hitBottom() {
        return getY() + getHeight();
    }

    public int leftBound() {
        return x;
    }

    public int rightBound() {
        return x + getWidth();
    }
}