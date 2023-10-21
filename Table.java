import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Table extends JPanel {
    private final int gridRows = 12;
    private final int gridColumns = 7;
    private final int gridCellSize = 30;
    private Block block = new LShapedBlock();
    private Color[][] background;
    private Random random = new Random();
    int n = random.nextInt(0, 5);
    

    public boolean fallingBlock() {
        if (!bottomHit()) {
            block.fall();
            repaint();
            //addBlockToTable();

            return true;
        }
        addBlockToTable();
        return false;

        // if (!bottomHit()) {
        //     add
        //     return false;
        // }
        // block.fall();
        // repaint();
        // return true;
        
    }

    public void drawBlock(Graphics g) {
        for (int row = 0; row < block.getHeight(); row++) {
            for (int column = 0; column < block.getWidth(); column++) {
                if (block.getShape()[row][column] >= 1) {
                    int x = (block.getX() + column) * gridCellSize;
                    int y = (block.getY() + row) * gridCellSize;
                    g.setColor(block.getColor());
                    g.fillRect(x, y, 30, 30);
                    g.setColor(Color.black);
                    g.drawRect(x, y, 30, 30);
                    g.setFont(new Font("Dialog", Font.PLAIN, 20));
                    g.drawString(block.getNumber(), x + 10, y + 20);
                }
            }
        }
    }

    public Table() {
        this.setBounds(180, 180, 210, 360);
        background = new Color[360][210];
        background[0][0] = Color.green;
        //this.setBackground(Color.gray);

        //gridCellSize = this.getBounds().width / gridColumns;
        //gridRows = this.getBounds().height / gridCellSize;
    }


    public boolean bottomHit() {
        if (block.hitBottom() == gridRows) {
            return true;
        }
        //addBlockToTable();
        return false;
    }

    private boolean leftBoundHit() {
        if (block.leftBound() == 6) {
            return false;
        }
        return true;
    }

    private boolean rightBoundHit() {
        if (block.rightBound() == gridColumns + 6) {
            return false;
        }
        return true;
        
    }

    public void moveToLeft() {
        if (!leftBoundHit()) {
        } else {
            block.moveLeft();
            repaint();
        }
    }

    public void moveToRight() {
        if (!rightBoundHit()) {
        } else {
            block.moveRight();
            repaint();
        }
    }

    private void drawColumn(Graphics g) {
        for (int y = 180; y < 520; y += 30) {
            g.drawRect(420, y, gridCellSize, gridCellSize);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGameArea(g);
        drawBackground(g);
        drawColumn(g);
        drawBlock(g);

        //  g.setColor(Color.gray);
        //  g.fillRect(180, 180, 210, 360);
        //  g.setColor(Color.black);
        //  for (int x = 6; x <= gridRows + 5; x++) {
        //     for (int y = 6; y <= gridColumns + 5; y++) {
        //          g.drawRect(y * gridCellSize, x * gridCellSize, gridCellSize, gridCellSize);
        //      }
        // }

        //drawBackground(g);
        
    }

    private void drawBackground(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(180, 180, 210, 360);
        g.setColor(Color.black);
        for (int x = 6; x <= gridRows + 5; x++) { 
           for (int y = 6; y <= gridColumns + 5; y++) {
                Color color = background[x][y];

                if (color == Color.gray) { 
                    g.drawRect(y * gridCellSize, x * gridCellSize, gridCellSize, gridCellSize);
            
                } else {
                    //addBlockToTable();
                    g.setColor(color);
                    g.drawRect(y * gridCellSize, x * gridCellSize, gridCellSize, gridCellSize);
                }
            }
        }
    }

    

    public void addBlockToTable() {
        int[][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();
        int xPos = block.getX();
        int yPos = block.getY();
        Color color = block.getColor();

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (shape[r][c] >= 1) {
                    background[r + yPos][c + xPos] = color;
                }
            }
        }
    }

    public void spawnBlock() {
        if (n == 0) {
            block = new SquareShapedBlock();
        } else if (n == 1) {
            block = new SShapedBlock();
        } else if (n == 2) {
            block = new LShapedBlock();
        } else if (n == 3) {
            block = new IShapedBlock();
        } else {
            block = new WeirdShapedBlock();
        }
    }

    private void drawGameArea(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(180, 180, 210, 360);
        g.setColor(Color.black);
        for (int x = 6; x <= gridRows + 5; x++) {
            for (int y = 6; y <= gridColumns + 5; y++) {
                g.drawRect(y * gridCellSize, x * gridCellSize, gridCellSize, gridCellSize);
            }
        }
    }
}
