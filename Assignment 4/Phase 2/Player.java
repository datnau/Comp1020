public class Player implements Attacker, Defender{
    private int health;
    private int attackPower;

    public Player(int health,int attackPower){
        this.health = health;
        this.attackPower = attackPower;
    }

    public void takeDamage(int amount){
        if (amount > 0) {
            health -= amount;
            if (health < 0) {
                health = 0;
            }
        }
    }

    public boolean isAlive(){
        if(health > 0) return true;
        return false;
    }
    public String getName(){
        return "Player";
    }
    public int getAttackPower(){
        return this.attackPower;
    }
    public int getHealth(){
        return health;
    }

}    

