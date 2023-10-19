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
            //table.drawBlock();
            
            try {
                table.fallingBlock();

                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}
