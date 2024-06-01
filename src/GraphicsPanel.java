import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel implements MouseListener {
    private BufferedImage dice;
    private final double stringX;
    private final double starY;

    //single roll variables
    public int roll100;
    public int roll20;
    public int roll12;
    public int roll10;
    public int roll8;
    public int roll6;
    public int roll4;
    public int coinFlip;

    //roll button
    private final Rectangle r = new Rectangle (50, 450, 45, 20);

    //dice
    private final Roll d100 = new Roll(100);
    private final Roll d20 = new Roll(20);
    private final Roll d12 = new Roll(12);
    private final Roll d10 = new Roll(10);
    private final Roll d8 = new Roll(8);
    private final Roll d6 = new Roll(6);
    private final Roll d4 = new Roll(4);
    private final Roll coin = new Roll(2);

    //rectangles
    private final Rectangle rect100 = new Rectangle (25, 100, 45, 20);
    private final Rectangle rect20 = new Rectangle (25, 145, 45, 20);
    private final Rectangle rect12 = new Rectangle (25, 190, 45, 20);
    private final Rectangle rect10 = new Rectangle (25, 235, 45, 20);
    private final Rectangle rect8 = new Rectangle (25, 280, 45, 20);
    private final Rectangle rect6 = new Rectangle (25, 325, 45, 20);
    private final Rectangle rect4 = new Rectangle (25, 370, 45, 20);
    private final Rectangle coinRect = new Rectangle (25, 415, 45, 20);

    //button pressed?
    public boolean d100Pressed;
    public boolean d20Pressed;
    public boolean d12Pressed;
    public boolean d10Pressed;
    public boolean d8Pressed;
    public boolean d6Pressed;
    public boolean d4Pressed;
    public boolean coinPressed;

    //only one button is on the rest are false(off)
    public void oneOn(int trueNum){
        d100Pressed = false;
        d20Pressed = false;
        d12Pressed = false;
        d10Pressed = false;
        d8Pressed = false;
        d6Pressed = false;
        d4Pressed = false;
        coinPressed = false;
        if(trueNum == 100){
            d100Pressed = true;
        }else if(trueNum == 20){
            d20Pressed = true;
        }else if(trueNum == 12){
            d12Pressed = true;
        }else if(trueNum == 10){
            d10Pressed = true;
        }else if(trueNum == 8){
            d8Pressed = true;
        }else if(trueNum == 6){
            d6Pressed = true;
        }else if(trueNum == 4){
            d4Pressed = true;
        }else if(trueNum == 2){
            coinPressed = true;
        }
    }


    public GraphicsPanel() {
        addMouseListener(this);
        stringX = 0;
        starY = 50;
        try {
            dice = ImageIO.read(new File("src/d20-icon.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        JFrame f = new JFrame();
        f.addMouseListener(this);

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // just do this
        g.setColor(Color.BLUE);
        g.drawRect(25, 100, 45, 20);
        g.drawRect(25, 145, 45, 20);
        g.drawRect(25, 190, 45, 20);
        g.drawRect(25, 235, 45, 20);
        g.drawRect(25, 280, 45, 20);
        g.drawRect(25, 325, 45, 20);
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
        g.drawString("Result: " + d100.returnTotal(), 100, 115);
        g.drawRect(50, 450, 45, 20);
        if(d100Pressed){
            g.drawString("" + roll100, 70, 115);
            Roll.clearTotal();
        }else if(d20Pressed){
            g.drawString("" + roll20, 70, 160);
            Roll.clearTotal();
        }else if(d12Pressed){
            g.drawString("" + roll12, 70, 205);
            Roll.clearTotal();
        }else if(d10Pressed){
            g.drawString("" + roll10, 70, 250);
            Roll.clearTotal();
        }else if(d8Pressed){
            g.drawString("" + roll8, 70, 295);
            Roll.clearTotal();
        }else if(d6Pressed){
            g.drawString("" + roll6, 70, 340);
            Roll.clearTotal();
        }else if(d4Pressed){
            g.drawString("" + roll4, 70, 385);
            Roll.clearTotal();
        }else if(coinPressed){
            g.drawString("" + coinFlip, 70, 430);
            Roll.clearTotal();
        }
        g.drawString("" + d100.getTotalDice(), 70, 450);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            Point mouseClickLocation = e.getPoint();
            if(r.contains(mouseClickLocation)){
                roll100 = d100.roll();
            }else if(rect100.contains(mouseClickLocation)){
                roll100 = d100.roll();
                oneOn(100);
            }else if(rect20.contains(mouseClickLocation)){
                roll20 = d20.roll();
                oneOn(20);
            }else if(rect12.contains(mouseClickLocation)){
                roll12 = d12.roll();
                oneOn(12);
            }else if(rect10.contains(mouseClickLocation)){
                roll10 = d10.roll();
                oneOn(10);
            }else if(rect8.contains(mouseClickLocation)){
                roll8 = d8.roll();
                oneOn(8);
            }else if(rect6.contains(mouseClickLocation)){
                roll6 = d6.roll();
                oneOn(6);
            }else if(rect4.contains(mouseClickLocation)){
                roll4 = d4.roll();
                oneOn(4);
            }else if(coinRect.contains(mouseClickLocation)){
                coinFlip = coin.roll();
                oneOn(2);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}