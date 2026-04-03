public class Wall implements Defender {
    private int health;
    //Constructor
    public Wall(int health) {
    this.health = health;
    }
    public void takeDamage(int amount){
        if (amount> 0) {
            health -= amount;
            if (health < 0) {
                health = 0;
            }
        }

    }

    public int getHealth(){
        return this.health;
    }

    public boolean isAlive(){
        if(this.health > 0) return true;
        return false;
    }

    public String getName(){
        return "Wall";
    }
    public String toString() {
        return "Wall[health=" + health + "]";
    }
    
}
