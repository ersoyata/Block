import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Table extends JPanel {
    private final int gridRows = 12;
    private final int gridColumns = 8;
    private final int gridCellSize = 30;
    private Block block;
    private Color[][] background;
    private int[][] numbersToEliminate;
    private String[][] backgroundNumbers;
    private Random random = new Random();
    private int[] extraColumn = new int[12];
    private int extraColoumnCounter = 0;
     
    public Table() {
        this.setBounds(0, 0, 240, 420);
        background = new Color[gridRows][gridColumns];
        
        // numbersToEliminate = new int[gridRows + 6][gridColumns + 6];
        // backgroundNumbers = new String[gridRows + 6][gridColumns + 6];
    }

    public boolean fallingBlock() {
        if (!bottomHit()) {
            addBlockToTable();
            eliminateRow();
            return false;
        }
        block.fall();
        repaint();
        return true;   
    }

    public boolean bottomHit() {
        if (block.getY() + block.getHeight() == gridRows) {
            return false;
        }
        int[][] shape = block.getShape();


        for (int col = 0; col < block.getWidth(); col++) {
            for (int row = block.getHeight() - 1; row >= 0; row--) {
                if (shape[row][col] >= 1) {
                    int xRow = block.getX() + col;
                    int yCol = block.getY() + row + 1;
                    if (background[yCol][xRow] != null) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }

    private boolean leftBoundHit() {
        if (block.getX() == 0) {
            return false;
        }

        int[][] shape = block.getShape();
        for (int row = 0; row < block.getHeight(); row++) {
            for (int col = 0; col < block.getWidth(); col++) {
                if (shape[row][col] >= 1) {
                    int xRow = col + block.getX() - 1;
                    int yCol = row + block.getY();
                    if (yCol < 0) break;
                    if (background[yCol][xRow] != null) {
                        return false;
                    }
                    break;
                } 
            }
        }
        return true;
    }

    public boolean rightBoundHit() {
        if (block.getX() + block.getWidth() == gridColumns) {
            return false;
        }

        int[][] shape = block.getShape();
        for (int row = 0; row < block.getHeight(); row++) {
            for (int col = block.getWidth() - 1; col >= 0; col--) {
                if (shape[row][col] >= 1) {
                    int xRow = col + block.getX() + 1;
                    int yCol = row + block.getY();
                    if (yCol < 0) break;
                    if (background[yCol][xRow] != null) {
                        return false;
                    }
                    break;
                }
            }
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
       

    private void eliminateRow() {

        boolean isCleared;

        for (int row = gridRows - 1; row >= 0; row--) {
            
            isCleared = true;
            for (int col = 0; col < gridColumns; col++) {
                if (background[row][col] == null) {
                    isCleared = false;
                    break;
                }
                
            }
            if (isCleared) {
                for (int col = 0; col < gridColumns; col++) {
                    background[row][col] = null;
                    // numbersToEliminate[row][col] = 0;
                }
                rowsDown(row);
                repaint();
                row++;
                // extraColumn[extraColoumnCounter] = 1;
                // g.fillRect(420, 180 + extraColoumnCounter * gridCellSize, gridCellSize, gridCellSize);
                // extraColoumnCounter++;

            }
        
        }
    }

    private int rowSum(int row) {
        int sum = 0;
        for (int col = 0; col < gridColumns; col++) {
            sum += numbersToEliminate[row][col];
        }
        return sum;
    }

    private void rowsDown(int row) {
        for (int r = row; r > 0; r--) {
            for (int col = 0; col < gridColumns; col++){
                background[r][col] = background[r - 1][col];
                // numbersToEliminate[row][col] = numbersToEliminate[row][col];
            }
        }
    }

    public void spawnBlock() {
        // int n = random.nextInt(0, 5);
        
        // if (n == 0) {
        //     block = new SquareShapedBlock();
        // } else if (n == 1) {
        //     block = new SShapedBlock();
        // } else if (n == 2) {
        //     block = new LShapedBlock();
        // } else if (n == 3) {
        //     block = new IShapedBlock();
        // } else {
        //     block = new WeirdShapedBlock();
        // }
        block = new SquareShapedBlock();
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
                    // numbersToEliminate[r + yPos - 6][c + xPos - 6] = Integer.parseInt(block.getNumber());
                    // backgroundNumbers[r + yPos - 6][c + xPos - 6] = block.getNumber();
                    
                }
            }
        }
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        g.setColor(Color.black);
        g.drawRect(0,0, 210, 360);

                for (int row = 0; row < gridRows; row++) {
            for (int col = 0; col < gridColumns; col++) {
                g.drawRect(col * gridCellSize, row * gridCellSize, gridCellSize, gridCellSize);
            }
        }
        drawBlock(g);

    }


    private void drawGameArea(Graphics g) {
        //g.setColor(Color.gray);
        // g.fillRect(180, 180, 210, 360);
        g.setColor(Color.black);
        for (int x = 0; x < gridRows; x++) {
            for (int y = 0; y < gridColumns; y++) {
                g.drawRect(y* gridCellSize, x* gridCellSize, gridCellSize, gridCellSize);
            }
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
        
    private void drawBackground(Graphics g) {
        // g.setColor(Color.gray);
        // g.fillRect(180, 180, 210, 360);
        // g.setColor(Color.black);
        for (int x = 0; x < gridRows; x++) { 
           for (int y = 0; y < gridColumns; y++) {
                Color color = background[x][y];
                
                if (color != null) {
                    g.setColor(color);
                    g.fillRect(y * gridCellSize, x * gridCellSize, gridCellSize, gridCellSize);
                    // g.setColor(Color.black);
                    // g.setFont(new Font("Dialog", Font.PLAIN, 20));
                    // g.drawString(block.getNumber(), (block.getX() + y) * gridCellSize, (block.getY() + x) * gridCellSize);
                }
                // g.setColor(Color.black);
                // g.setFont(new Font("Dialog", Font.PLAIN, 20));
                // g.drawString(block.getNumber(), (block.getX() + y) * gridCellSize, (block.getY() + x) * gridCellSize);
            }
        }
    }
    

    private void drawColumn(Graphics g) {
        for (int y = 180; y < 520; y += 30) {
            g.drawRect(420, y, gridCellSize, gridCellSize);
        }
    }


}
