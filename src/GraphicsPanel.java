import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel {
    private BufferedImage dice;
    private double stringX;
    private double starY;

    public GraphicsPanel() {
        stringX = 50;
        starY = 50;
        try {
            dice = ImageIO.read(new File("src/d20-icon.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Roll d100 = new Roll(100);
        Roll d20 = new Roll(20);
        Roll d12 = new Roll(12);
        Roll d10 = new Roll(10);
        Roll d8 = new Roll(8);
        Roll d6 = new Roll(6);
        Roll d4 = new Roll(4);
        Roll coin = new Roll(2);
        super.paintComponent(g);  // just do this
        g.setColor(Color.BLUE);
        g.drawRect(50, 100, 45, 20);
        g.drawRect(50, 145, 45, 20);
        g.drawRect(50, 190, 45, 20);
        g.drawRect(50, 235, 45, 20);
        g.drawRect(50, 280, 45, 20);
        g.drawRect(50, 325, 45, 20);
        g.drawRect(50, 370, 45, 20);
        g.drawRect(50, 370, 45, 20);
        g.drawRect(50, 415, 45, 20);
        g.drawImage(dice, 200, (int) starY, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", Font.BOLD, 18));
        g.drawString("Welcome! Please pick your dice and the amount.", (int) stringX, 18);
        g.setFont(new Font("Courier New", Font.PLAIN, 18));
        g.drawString("D100", 51, 115);
        g.drawString("D20", 51, 160);
        g.drawString("D12", 51, 205);
        g.drawString("D10", 51, 250);
        g.drawString("D8", 51, 295);
        g.drawString("D6", 51, 340);
        g.drawString("D4", 51, 385);
        g.drawString("coin", 51, 430);
        g.drawString("Result: " + d20.roll(1), 100, 115);
    }
}