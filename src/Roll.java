import java.util.ArrayList;

public class Roll {
    private int diceSides;
    private int diceNum;
    private int total;
    private static int totalDice = 0;
    private static int allTotal = 0;

    public Roll(int sides) {
        this.diceSides = sides;
        diceNum = 0;

    }

    private int roll(){
        int x = (int)(Math.random() * diceSides) + 1;
        total += x;
        totalDice++;
        return x;
    }

    public int roll(int amount){
        int t = 0;
        for(int i = 0; i < amount; i++){
            t += roll();
        }
        return t;
    }
//ok so what you want to do is to add something to roll all dice and also a total for each individual iteration of the Roll class.
    public int returnTotal(){
        int x = total;
        total = 0;
        totalDice = 0;
        return x;
    }

    public void rollAllDice(ArrayList<Roll> all){
        for(Roll i : all){
            roll(diceNum);
        }
    }
}
