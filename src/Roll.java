import java.util.ArrayList;

public class Roll {
    private final int diceSides;
    private int diceTotal;
    private static int iteration = 0;
    private static int total;
    private static int totalDice = 0;
    private final ArrayList<Integer> rollNums = new ArrayList<>();
    private static final ArrayList<Integer> history = new ArrayList<>();

    public Roll(int sides) {
        if (history.size() != 10) {
            for(int i = 0; i < 10; i++){
                history.add(0);
            }
        }
        this.diceSides = sides;
    }

    public int roll(){
        int x = (int)(Math.random() * diceSides) + 1;
        diceTotal += x;
        total += x;
        totalDice++;
        return x;
    }

    //Rolls a certain amount of dice and saves each dice roll to the classes rollNums.
    public void roll(int amount){
        int x;
        for(int i = 0; i < amount; i++){
            x = roll();
            rollNums.add(x);
        }
    }

    public static int returnTotal(){
        return total;
    }

    public static void clearTotal(){
//        history.add(0, total);
        total = 0;
        totalDice = 0;
    }

    public static int getTotalDice(){
        return totalDice;
    }

    public String getRollNums(){
        String h = "";
        h  += rollNums.get(0);
        for(int i = 1; i < rollNums.size(); i++){
            h += ", " + rollNums.get(i);
        }
        return h;
    }

    public int getDiceTotal(){
        return diceTotal;
    }

    public void clearDiceTotal(){
        diceTotal = 0;
    }

    public void clearRollNums(){
        rollNums.clear();
    }

//    public static void bugSpray(){
//        for(int i = 0; i < 10; i++){
//            history.add(0);
//        }
//    }

    public static void clearHistory(){
        for(int i = 0; i < 10; i++){
            history.add(0);
        }
    }

    public static int getHistory(int num) {
        return history.get(num);
    }

    public static void addHistory(){
        history.add(0, total);
    }
}
