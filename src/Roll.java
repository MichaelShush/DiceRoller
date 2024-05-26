public class Roll {
    private int diceSides;
    private static int totalDice = 0;
    private static int total = 0;

    public Roll(int sides) {
        this.diceSides = sides;
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

    public int returnTotal(){
        int x = total;
        total = 0;
        totalDice = 0;
        return x;
    }
}
