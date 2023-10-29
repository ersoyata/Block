/**
 * Class of GameThread which is used to move our blocks in our game.
 * @author Szymon Ptas <1934066>
 * @authore Ersoy Ata Baki <1971131>
 */
public class GameThread extends Thread {

    private Table table;

    /**
     * Constructor of the class which creates our table object.
     * @param table object Table class
     */
    public GameThread(Table table) {
        this.table = table;
    }

    /**
     * While the game is not lost, a block is spawned. 
     * While the block is able to fall, the program waits for some time 
     * which enables the block to fall. If the block is not able to fall,
     * endOfGame method is called to check if the game has ended.
     */
    @Override
    public void run() {
        while (!table.getGameLost()) {
            table.spawnBlock();
            while (table.fallingBlock()) {
                try {
                    Thread.sleep(250);
                } catch (Exception e) {
                    continue;
                }
            }
            table.endOfGame();
        }
    }

}
