import java.awt.*;
import java.security.PublicKey;

import javax.swing.*;

public class Block {
    private int[][] shape;
    private Color color;
    private String number;
    int x, y;


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