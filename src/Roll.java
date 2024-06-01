import java.util.ArrayList;
import java.util.Arrays;

public class Roll {
    private final int diceSides;
    private static int total;
    private static int totalDice = 0;
    private ArrayList<Integer> rollNums = new ArrayList<>();

    public Roll(int sides) {
        this.diceSides = sides;
    }

    public int roll(){
        int x = (int)(Math.random() * diceSides) + 1;
        total += x;
        totalDice++;
        return x;
    }

    //Rolls a certain amount of dice and saves each dice roll to the classes rollNums.
    public int roll(int amount){
        int t = 0;
        int x;
        for(int i = 0; i < amount; i++){
            x = roll();
            t += x;
            rollNums.add(x);
        }
        return t;
    }

    public int returnTotal(){
        int x = total;
        total = 0;
        totalDice = 0;
        rollNums.clear();
        return x;
    }

    public static void clearTotal(){
        total = 0;
//        totalDice = 0;
    }

    public int getTotalDice(){
        return totalDice;
    }
}
