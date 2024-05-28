import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GraphicsPanel extends JPanel {
    private BufferedImage dice;
    private double stringX;
    private double starY;
    private int x;
    private JButton rollButton;

    public GraphicsPanel() {
        stringX = 0;
        starY = 50;
        try {
            dice = ImageIO.read(new File("src/d20-icon.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        rollButton = new JButton("roll");
        Roll d100 = new Roll(100);
        Roll d20 = new Roll(20);
        Roll d12 = new Roll(12);
        Roll d10 = new Roll(10);
        Roll d8 = new Roll(8);
        Roll d6 = new Roll(6);
        Roll d4 = new Roll(4);
        Roll coin = new Roll(2);
        d6.roll(2);
        d4.roll(5);
        d100.roll(1);
        x = d20.returnTotal();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JButton){
            JButton button = (JButton) e.getSource();
            if(button == rollButton){

            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
//        Roll d100 = new Roll(100);
//        Roll d20 = new Roll(20);
//        Roll d12 = new Roll(12);
//        Roll d10 = new Roll(10);
//        Roll d8 = new Roll(8);
//        Roll d6 = new Roll(6);
//        Roll d4 = new Roll(4);
//        Roll coin = new Roll(2);
        super.paintComponent(g);  // just do this
        g.setColor(Color.BLUE);
        g.drawRect(25, 100, 45, 20);
        g.drawRect(25, 145, 45, 20);
        g.drawRect(25, 190, 45, 20);
        g.drawRect(25, 235, 45, 20);
        g.drawRect(25, 280, 45, 20);
        g.drawRect(25, 325, 45, 20);
        g.drawRect(25, 370, 45, 20);
        g.drawRect(25, 370, 45, 20);
        g.drawRect(25, 415, 45, 20);
        g.drawImage(dice, 200, (int) starY, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", Font.BOLD, 18));
        g.drawString("Welcome! Please pick your dice and the amount.", (int) stringX, 18);
        g.setFont(new Font("Courier New", Font.PLAIN, 18));
        g.drawString("D100", 26, 115);
        g.drawString("D20", 26, 160);
        g.drawString("D12", 26, 205);
        g.drawString("D10", 26, 250);
        g.drawString("D8", 26, 295);
        g.drawString("D6", 26, 340);
        g.drawString("D4", 26, 385);
        g.drawString("coin", 26, 430);
        g.drawString("Result: " + x, 100, 115);
        rollButton.setLocation(50, 450);
    }
}