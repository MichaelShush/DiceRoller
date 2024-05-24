public class Roll {
    private int diceRoll;
    private int diceSides;
    private static int total;

    public Roll(int sides) {
        this.diceSides = sides;
        diceRoll = (int)(Math.random() * diceSides) + 1;
    }

    public int roll(int amount){
        int roll = diceRoll * amount;
        total += diceRoll;
        return roll;
    }

    public int returnTotal(){
        int x = total;
        total = 0;
        return x;
    }
}
