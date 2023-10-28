import java.awt.Graphics;

public class GameThread extends Thread {

    private Table table;
    Graphics g;

    public GameThread(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (!table.getGameLost()) {
            table.spawnBlock();
            while(table.fallingBlock()) {
                try {
                
                    Thread.sleep(100);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            //table.addBlockToTable();
            table.endOfGame();
        }
    }

}
