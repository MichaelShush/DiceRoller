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

    //plus/minus variables to add/remove a roll
    private final Rectangle remove100 = new Rectangle(75, 100, 20, 20);
    private final Rectangle add100 = new Rectangle(95, 100, 20, 20);
    private final Rectangle remove20 = new Rectangle(75, 145, 20, 20);
    private final Rectangle add20 = new Rectangle(95, 145, 20, 20);
    private final Rectangle remove12 = new Rectangle(75, 190, 20, 20);
    private final Rectangle add12 = new Rectangle(95, 190, 20, 20);
    private final Rectangle remove10 = new Rectangle(75, 235, 20, 20);
    private final Rectangle add10 = new Rectangle(95, 235, 20, 20);
    private final Rectangle remove8 = new Rectangle(75, 280, 20, 20);
    private final Rectangle add8 = new Rectangle(95, 280, 20, 20);
    private final Rectangle remove6 = new Rectangle(75, 325, 20, 20);
    private final Rectangle add6 = new Rectangle(95, 325, 20, 20);
    private final Rectangle remove4 = new Rectangle(75, 370, 20, 20);
    private final Rectangle add4 = new Rectangle(95, 370, 20, 20);
    private final Rectangle removeCoin = new Rectangle(75, 415, 20, 20);
    private final Rectangle addCoin = new Rectangle(95, 415, 20, 20);

    //"How many dice?" variables
    private int d100Amount;
    private int d20Amount;
    private int d12Amount;
    private int d10Amount;
    private int d8Amount;
    private int d6Amount;
    private int d4Amount;
    private int coinAmount;

    //roll and clear buttons
    private final Rectangle rollButton = new Rectangle (26, 450, 45, 20);
    private final Rectangle clearButton = new Rectangle (91, 450, 60, 20);

    //dice
    private final Roll d100 = new Roll(100);
    private final Roll d20 = new Roll(20);
    private final Roll d12 = new Roll(12);
    private final Roll d10 = new Roll(10);
    private final Roll d8 = new Roll(8);
    private final Roll d6 = new Roll(6);
    private final Roll d4 = new Roll(4);
    private final Roll coin = new Roll(2);
    private boolean rolled;
    private int orderY = 550;

    private void moveUp(){
        orderY += 20;
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

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // just do this
//        Roll.bugSpray();
        g.setColor(Color.BLUE);
        g.drawRect(25, 100, 45, 20);
        g.drawRect(25, 145, 45, 20);
        g.drawRect(25, 190, 45, 20);
        g.drawRect(25, 235, 45, 20);
        g.drawRect(25, 280, 45, 20);
        g.drawRect(25, 325, 45, 20);
        g.drawRect(25, 370, 45, 20);
        g.drawRect(25, 415, 45, 20);
        g.drawImage(dice, 300, (int) starY, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
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
        g.drawString("roll", 26, 465);
        g.drawString("clear", 91, 465);

        //plus/minus dice
        g.drawString("-", 75, 115);
        g.drawString("+", 105, 115);
        g.drawString("-", 75, 160);
        g.drawString("+", 105, 160);
        g.drawString("-", 75, 205);
        g.drawString("+", 105, 205);
        g.drawString("-", 75, 250);
        g.drawString("+", 105, 250);
        g.drawString("-", 75, 295);
        g.drawString("+", 105, 295);
        g.drawString("-", 75, 340);
        g.drawString("+", 105, 340);
        g.drawString("-", 75, 385);
        g.drawString("+", 105, 385);
        g.drawString("-", 75, 430);
        g.drawString("+", 105, 430);

        //print diceAmount
        g.drawString("" + d100Amount, 90, 115);
        g.drawString("" + d20Amount, 90, 160);
        g.drawString("" + d12Amount, 90, 205);
        g.drawString("" + d10Amount, 90, 250);
        g.drawString("" + d8Amount, 90, 295);
        g.drawString("" + d6Amount, 90, 340);
        g.drawString("" + d4Amount, 90, 385);
        g.drawString("" + coinAmount, 90, 430);

        //"roll" and "clear" rects
        g.drawRect(25, 450, 45, 20);
        g.drawRect(90, 450, 60, 20);

        //print the history
        g.drawString("History (last 10)", 610, 100);
        g.drawString("__________________", 600, 101);
        int c = 120;
        if(Roll.getHistory(0) != 0){
            g.drawString("1: " + Roll.getHistory(0), 600, c + 20);
        }
        if(Roll.getHistory(1) != 0){
            g.drawString("2: " + Roll.getHistory(1), 600, c + 40);
        }
        if(Roll.getHistory(2) != 0){
            g.drawString("3: " + Roll.getHistory(2), 600, c + 60);
        }
        if(!(Roll.getHistory(3) == 0)){
            g.drawString("4: " + Roll.getHistory(3), 600, c + 80);
        }
        if(!(Roll.getHistory(4) == 0)){
            g.drawString("5: " + Roll.getHistory(4), 600, c + 100);
        }
        if(!(Roll.getHistory(5) == 0)){
            g.drawString("6: " + Roll.getHistory(5), 600, c + 120);
        }
        if(!(Roll.getHistory(6) == 0)){
            g.drawString("7: " + Roll.getHistory(6), 600, c + 140);
        }
        if(!(Roll.getHistory(7) == 0)){
            g.drawString("8: " + Roll.getHistory(7), 600, c + 160);
        }
        if(!(Roll.getHistory(8) == 0)){
            g.drawString("9: " + Roll.getHistory(8), 600, c + 180);
        }
        if(!(Roll.getHistory(9) == 0)){
            g.drawString("10: " + Roll.getHistory(9), 600, c + 200);
        }


        //conditional
        if(rolled) {
            orderY = 550;
            g.drawString("# of dice rolled: " + Roll.getTotalDice() + "   Total: " + Roll.returnTotal(), 25, 500);
            g.drawString("Individual dice rolls", 25, 528);
            g.drawString("_____________________", 25, 529);
            if (d100Amount != 0) {
                g.drawString("D100 rolls: " + d100.getRollNums() + " | Dice total: " + d100.getDiceTotal(), 25, orderY);
                moveUp();
            }
            if (d20Amount != 0) {
                g.drawString("D20 rolls: " + d20.getRollNums() + " | Dice total: " + d20.getDiceTotal(), 25, orderY);
                moveUp();
            }
            if (d12Amount != 0) {
                g.drawString("D12 rolls: " + d12.getRollNums() + " | Dice total: " + d12.getDiceTotal(), 25, orderY);
                moveUp();
            }
            if (d10Amount != 0) {
                g.drawString("D10 rolls: " + d10.getRollNums() + " | Dice total: " + d10.getDiceTotal(), 25, orderY);
                moveUp();
            }
            if (d8Amount != 0) {
                g.drawString("D8 rolls: " + d8.getRollNums() + " | Dice total: " + d8.getDiceTotal(), 25, orderY);
                moveUp();
            }
            if (d6Amount != 0) {
                g.drawString("D6 rolls: " + d6.getRollNums() + " | Dice total: " + d6.getDiceTotal(), 25, orderY);
                moveUp();
            }
            if (d4Amount != 0) {
                g.drawString("D4 rolls: " + d4.getRollNums() + " | Dice total: " + d4.getDiceTotal(), 25, orderY);
                moveUp();
            }
            if (coinAmount != 0) {
                g.drawString("Coin flips: " + coin.getRollNums() + " | Coin total: " + coin.getDiceTotal(), 25, orderY);
            }

        }else{
            g.drawString("Go roll some dice!", 25, 528);
        }
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
            if(rollButton.contains(mouseClickLocation)) {
                d100.clearRollNums();
                d100.clearDiceTotal();
                d20.clearRollNums();
                d20.clearDiceTotal();
                d12.clearRollNums();
                d12.clearDiceTotal();
                d10.clearRollNums();
                d10.clearDiceTotal();
                d8.clearRollNums();
                d8.clearDiceTotal();
                d6.clearRollNums();
                d6.clearDiceTotal();
                d4.clearRollNums();
                d4.clearDiceTotal();
                coin.clearRollNums();
                coin.clearDiceTotal();
                Roll.clearTotal();
                rolled = true;
                d100.roll(d100Amount);
                d20.roll(d20Amount);
                d12.roll(d12Amount);
                d10.roll(d10Amount);
                d8.roll(d8Amount);
                d6.roll(d6Amount);
                d4.roll(d4Amount);
                coin.roll(coinAmount);
                Roll.addHistory();
            }else if(clearButton.contains(mouseClickLocation)){
                Roll.clearTotal();
                d100Amount = 0;
                d20Amount = 0;
                d12Amount = 0;
                d10Amount = 0;
                d8Amount = 0;
                d6Amount = 0;
                d4Amount = 0;
                coinAmount = 0;
                rolled = false;
                Roll.clearHistory();
            }else if(remove100.contains(mouseClickLocation)){
                rolled = false;
                if(d100Amount != 0){
                    d100Amount--;
                }
            }else if(add100.contains(mouseClickLocation)){
                rolled = false;
                if(d100Amount != 9){
                    d100Amount++;
                }
            }else if(remove20.contains(mouseClickLocation)){
                rolled = false;
                if(d20Amount != 0){
                    d20Amount--;
                }
            }else if(add20.contains(mouseClickLocation)){
                rolled = false;
                if(d20Amount != 9){
                    d20Amount++;
                }
            }else if(remove12.contains(mouseClickLocation)){
                rolled = false;
                if(d12Amount != 0){
                    d12Amount--;
                }
            }else if(add12.contains(mouseClickLocation)){
                rolled = false;
                if(d12Amount != 9){
                    d12Amount++;
                }
            }else if(remove10.contains(mouseClickLocation)){
                rolled = false;
                if(d10Amount != 0){
                    d10Amount--;
                }
            }else if(add10.contains(mouseClickLocation)){
                rolled = false;
                if(d10Amount != 9){
                    d10Amount++;
                }
            }else if(remove8.contains(mouseClickLocation)){
                rolled = false;
                if(d8Amount != 0){
                    d8Amount--;
                }
            }else if(add8.contains(mouseClickLocation)){
                rolled = false;
                if(d8Amount != 9){
                    d8Amount++;
                }
            }else if(remove6.contains(mouseClickLocation)){
                rolled = false;
                if(d6Amount != 0){
                    d6Amount--;
                }
            }else if(add6.contains(mouseClickLocation)){
                rolled = false;
                if(d6Amount != 9){
                    d6Amount++;
                }
            }else if(remove4.contains(mouseClickLocation)){
                rolled = false;
                if(d4Amount != 0){
                    d4Amount--;
                }
            }else if(add4.contains(mouseClickLocation)){
                rolled = false;
                if(d4Amount != 9){
                    d4Amount++;
                }
            }else if(removeCoin.contains(mouseClickLocation)){
                rolled = false;
                if(coinAmount != 0){
                    coinAmount--;
                }
            }else if(addCoin.contains(mouseClickLocation)){
                rolled = false;
                if(coinAmount != 9){
                    coinAmount++;
                }
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