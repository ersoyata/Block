import java.awt.*;
import java.util.*;
import javax.swing.*;



/**
 * Class of Table which the program creates a table,
 * creates blocks and makes them fall, adds blocks to
 * the table when they hit the bottom and eliminates rows.
 * @author Szymon Ptas <1934066>
 * @author Ersoy Ata Baki <1971131>
 */
public class Table extends JPanel {
    private final int gridRows = 14;
    private final int gridColumns = 8;
    private final int gridCellSize = 30;
    private Block block;
    private Color[][] background;
    private int[][] numbersToEliminate;
    private String[][] backgroundNumbers;
    private Random random = new Random();
    private int[] extraColumn;
    private Color[] extraColors;
    private int extraColumnCounter = 11;
    private boolean gameLost = false;
    private boolean gameWon = false;

    /**
        The constructor of the Table class.
    */     
    public Table() {
        this.setBounds(0, 0, 240, 480);
        background = new Color[gridRows][gridColumns];
        numbersToEliminate = new int[gridRows][gridColumns];
        backgroundNumbers = new String[gridRows][gridColumns];
        extraColors = new Color[12];
        extraColumn = new int[12];
    }

    /**
     * If the game is lost then returns a boolean value.
     * 
     * @return boolean value
     */
    public boolean getGameLost() {
        return gameLost;
    }

    /**
     * Checks if the block is at the bottom of the table, if yes, it
     * adds the block to the background, calls eliminateRow method and returns false 
     * if no, makes the block fall, calls repaints the table and returns true.
     * 
     * @return boolean value representing if the block was able to fall
     */
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

    /**
     * Checks if the the block hits the bottom of the table,
     * if yes it returns false. Creates a new array and assigns the 
     * shape of the block to the new array. Then checks the index below the block
     * to see if there is already a block there. If there is it returns false.
     * Otherwise returns true.
     * 
     * @return boolean value representing if the block hits the bottom of the table
     *      or if there is already a block below the falling block.
     */
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
                    if (yCol < 0) {
                        continue;
                    }
                    if (background[yCol][xRow] != null) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }

    /**
     * Checks if the block is at the left boundary of the table, if yes returns false.
     * Creates a new array and assigns the shape of the block to the new array. Then
     * check the left index of the block to see if there is already a block there.
     * If there is, returns false. Otherwise returns true.
     * 
     * @return boolean value representing if the block is at the left boundary of the table
     *      or if there is already a block at the left of the falling block.
     */
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
                    if (yCol < 0) {
                        break;
                    }
                    if (background[yCol][xRow] != null) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    
    /**
     * Checks if the block is at the right boundary of the table, if yes returns false.
     * Creates a new array and assigns the shape of the block to the new array. Then
     * check the right index of the block to see if there is already a block there.
     * If there is, returns false. Otherwise returns true.
     * 
     * @return boolean value representing if the block is at the rigth boundary of the table
     *      or if there is already a block at the right of the falling block.
     */
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
                    if (yCol < 0) {
                        break;
                    }
                    if (background[yCol][xRow] != null) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;   
    }

    /**
     * Checks if the block can move to left by checking if the left bound is hit.
     * If no the block is moved to left and repaint is called.
     */
    public void moveToLeft() {
        if (leftBoundHit()) {
            block.moveLeft();
            repaint();
        }
    }

    /**
     * Checks if the block can move to right by checking if the right bound is hit.
     * If no the block is moved to right and repaint is called.
     */
    public void moveToRight() {
        if (rightBoundHit()) {
            block.moveRight();
            repaint();
        }
    }
       
    /**
     * It checks all rows of the table using a for loop. For every loop the conditions are set 
     * to true. First it checks if there is a empty cell in a row, if yes the clear condition is
     * set to false. Then it checks if the sum of the row is below 30 which is a case to eliminate
     * rows. If yes then the sum condition is set to false. Then it checks if the clear and sum 
     * conditions are both still true. If yes the row is eliminated and the blocks above the 
     * eliminated row fall down and it is repainted.
     */
    private void eliminateRow() {

        boolean isCleared;
        boolean rightSum;

        for (int row = gridRows - 1; row >= 0; row--) {
            
            isCleared = true;
            rightSum = true;
            for (int col = 0; col < gridColumns; col++) {
                if (background[row][col] == null) {
                    isCleared = false;
                    break;
                }      
            }

            if (rowSum(row) < 30) {
                rightSum = false;
            }

            if (isCleared && rightSum) {
                for (int col = 0; col < gridColumns; col++) {
                    background[row][col] = null;
                    numbersToEliminate[row][col] = 0;
                    backgroundNumbers[row][col] = null;
                }
                rowsDown(row);
                row++;
                addToColumn();
                repaint();

            }
        
        }
    }

    /**
     * Sums the numbers in a row and returns the sum.
     * @param row integer parameter which represents the index of the row.
     * @return boolean value which returns the sum
     */
    private int rowSum(int row) {
        int sum = 0;
        for (int col = 0; col < gridColumns; col++) {
            sum += numbersToEliminate[row][col];
        }
        return sum;
    }

    /**
     * Makes the blocks fall down by one.
     * @param row integer parameter which represents the index of the row.
     */
    private void rowsDown(int row) {
        for (int r = row; r > 0; r--) {
            for (int col = 0; col < gridColumns; col++){
                background[r][col] = background[r - 1][col];
                numbersToEliminate[r][col] = numbersToEliminate[r - 1][col];
                backgroundNumbers[r][col] = backgroundNumbers[r - 1][col];
            }
        }
    }

    /**
     * Adds to the extra column whenever a row is eliminated.
     */
    private void addToColumn() {
        extraColumn[extraColumnCounter] = 1;
        extraColors[extraColumnCounter] = Color.green;
        extraColumnCounter--;
    }
    
    /**
     * Checks if the extra column if full. If yes the game is won.
     */
    public void endOfGame() {
        if (extraColumnCounter < 0) {
            gameWon = true;
        }
    }

    /**
     * Generates a random number between 0 and 6 and spawns a random block
     * using this random number.
     */
    public void spawnBlock() {
        int n = random.nextInt(0, 7);
        
        if (n == 0) {
            block = new SquareShapedBlock();
        } else if (n == 1) {
            block = new SShapedBlock();
        } else if (n == 2) {
            block = new LShapedBlock();
        } else if (n == 3) {
            block = new IShapedBlock();
        } else if (n == 4) {
            block = new WeirdShapedBlock();
        } else if (n == 5) {
            block = new TShapedBlock();
        } else {
            block = new JShapedBlock();
        }
    }

    /**
     * Gets the attributes of the block and assigns them into variables. Tries to add the block
     * to the background. If there is and ArrayIndexOutOfBoundsExcetion, it means that the game 
     * is lost and it is repainted. 
     */
    public void addBlockToTable() {
        int[][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();
        int xPos = block.getX();
        int yPos = block.getY();
        Color color = block.getColor();

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                try {
                    if (shape[r][c] >= 1) {
                        background[r + yPos][c + xPos] = color;
                        numbersToEliminate[r + yPos][c + xPos] = Integer.parseInt(
                            block.getNumber());
                        backgroundNumbers[r + yPos][c + xPos] = block.getNumber();
                    
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    gameLost = true;
                    repaint();
                }
            }
        }
    }

    /**
     * Draws the background, table, block and the extra coloumn. If the game is won,
     * it draws the game won message and if the game is lost it draws the game lost message.
     */    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);

        g.setColor(Color.black);
        g.drawRect(0, 0, 210, 360);
        for (int row = 0; row < gridRows; row++) {
            for (int col = 0; col < gridColumns; col++) {
                g.drawRect(col * gridCellSize, row * gridCellSize, gridCellSize, gridCellSize);
            }
        }

        drawBlock(g);
        drawColumn(g);
        
        if (gameLost) {
            gameLostMessage(g);
        }

        if (gameWon) {
            gameWonMessage(g);
        }

    }

    /**
     * It draws the block with its number initially.
     * @param g allows us to use javax.swing library.
     */
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
        
    /**
     * Draws the table with the background with the blocks on it and fills the
     * extra column whenever a row is eliminated.
     * @param g allows us to use javax.swing library
     */
    private void drawBackground(Graphics g) {
        for (int x = 0; x < gridRows; x++) { 
            for (int y = 0; y < gridColumns; y++) {
                Color color = background[x][y];
                if (color != null) {
                    g.setColor(color);
                    g.fillRect(y * gridCellSize, x * gridCellSize, gridCellSize, gridCellSize);
                }
            }
        }
        for (int x = 0; x < gridRows; x++) {
            for (int y = 0; y < gridColumns; y++) {
                String number = backgroundNumbers[x][y];
                if (number != null) {
                    g.setColor(Color.black);
                    g.setFont(new Font("Dialog", Font.PLAIN, 20));
                    g.drawString(number, y * gridCellSize + 10, x * gridCellSize + 20);
                }
            }
        }
        
        for (int row = 0; row < gridRows - 2; row++) {
            Color color = extraColors[row];
            if (color != null) {
                g.setColor(Color.green);
                g.fillRect(270, (row + 2) * gridCellSize, gridCellSize, gridCellSize);
                g.setColor(Color.black);
                g.drawRect(270, (row + 2) * gridCellSize, gridCellSize, gridCellSize);
            }
        }
        
    }
    
    /**
     * Draws the extra column.
     * @param g allows us to use javax.swing library
     */
    private void drawColumn(Graphics g) {
        for (int y = 60; y < 420; y += 30) {
            g.drawRect(270, y, gridCellSize, gridCellSize);
        }
    }

    /**
     * Draws the game lost message.
     * @param g allows us to use javax.swing library
     */
    private void gameLostMessage(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.PLAIN, 50));
        g.drawString("You Lost", 40, 200);
    }

    /**
     * Draws the game won message.
     * @param g allows us to use javax.swing library
     */
    private void gameWonMessage(Graphics g) {
        g.setColor(Color.green);
        g.setFont(new Font("Serif", Font.PLAIN, 50));
        g.drawString("You Won", 40, 200);
    }
}
