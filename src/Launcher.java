import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        JFrame f = new JFrame("OWEN PLC emulation window");
        f.setMinimumSize(new Dimension(800, 600));
        f.setLocationRelativeTo(null);
        f.add(createMainPanel());
        f.pack();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static JPanel createMainPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel text = new JLabel("Please select the use mode.");
        text.setFont(new Font(Font.MONOSPACED, Font.BOLD, 28));
        text.setForeground(new Color(0, 0, 0));
        panel.add(text, new GridBagConstraints(
                0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        JButton user = new JButton("START");
        user.setVerticalTextPosition(SwingConstants.BOTTOM);
        user.setHorizontalTextPosition(SwingConstants.CENTER);
        user.setIcon(new ImageIcon("start.png"));
        JButton engineer = new JButton("CONFIG MODE");
        engineer.setVerticalTextPosition(SwingConstants.BOTTOM);
        engineer.setHorizontalTextPosition(SwingConstants.CENTER);
        engineer.setIcon(new ImageIcon("settings.png"));
        panel.add(user, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(engineer, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        return panel;
    }
}
