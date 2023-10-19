import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Table extends JPanel {
    private final int gridRows = 12;
    private final int gridColumns = 7;
    private final int gridCellSize = 30;
    private Block block;
    private Random random = new Random();
    int n = random.nextInt(0, 5);
    
    public void generateBlock() {
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


    public void fallingBlock() {
        if (!bottomHit()) {
            block.fall();
            repaint();
        }
        
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
        //this.setBackground(Color.gray);

        //gridCellSize = this.getBounds().width / gridColumns;
        //gridRows = this.getBounds().height / gridCellSize;
    }


    public boolean bottomHit() {
        if (block.hitBottom() == gridRows) {
            return true;
        }
        return false;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.gray);
        g.fillRect(180, 180, 210, 360);
        g.setColor(Color.black);
        for (int x = 6; x <= gridRows + 5; x++) {
            for (int y = 6; y <= gridColumns + 5; y++) {
                g.drawRect(y * gridCellSize, x * gridCellSize, gridCellSize, gridCellSize);
            }
        }
        drawBlock(g);
    }

    public void spawnBlock() {
        
    }
}
