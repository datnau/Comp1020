public class Trap implements Attacker{
    private int attackPower;

    public Trap(int attackPower){
        this.attackPower = attackPower;
    }

    public int getAttackPower(){
        return this.attackPower;
    }

    public String getName(){
        return "Trap";
    }
    public String toString() {
        return "Trap[attackPower=" + attackPower + "]";
    }

}
