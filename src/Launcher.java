import com.plcdev.ui.StartWorkFrame;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StartWorkFrame frame = new StartWorkFrame();
            }
        });
    }
}