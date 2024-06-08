import javax.swing.*;

public class MainFrame implements Runnable {
    private GraphicsPanel panel;

    public MainFrame() {
        JFrame frame = new JFrame("Dice Roller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocation(300, 50);

        // create and add panel
        panel = new GraphicsPanel();
        frame.add(panel);

        // display the frame
        frame.setVisible(true);

        // start thread, required for animation
        Thread thread = new Thread(this);
        thread.start();
    }

    // Runnable interface method
    public void run() {
        while (true) {
            panel.repaint();  // we don't ever call paintComponent directly
        }
    }
}