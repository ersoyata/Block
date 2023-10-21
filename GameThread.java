import java.awt.Graphics;

public class GameThread extends Thread {

    private Table table;
    Graphics g;

    public GameThread(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            table.spawnBlock();
            while(table.fallingBlock()) {
                try {
                
                    Thread.sleep(300);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            //table.addBlockToTable();
        }
    }

}
