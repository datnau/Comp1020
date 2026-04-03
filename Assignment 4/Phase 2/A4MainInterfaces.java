import java.util.Scanner;
public class A4MainInterfaces {

    public static void resolveCombat(Attacker a, Defender d){
        if(a.getAttackPower() >= 0 && d.getHealth() > 0){
            d.takeDamage(a.getAttackPower());
        }
        System.out.printf("Combat resolved: Defender (%s) took %d damage from Attacker (%s)\n",d.getName(),a.getAttackPower(),a.getName());
    }

    public static void runAdventureLoop(Scanner scanner, Player player, Wall wall, Trap Trap){
        
        while(true){
            System.out.println("\nEnter command (attack, step, status, quit): ");
            Scanner sc = new Scanner(System.in);
                String cmt = sc.nextLine();
                if(!cmt.equalsIgnoreCase("attack") && !cmt.equalsIgnoreCase("step") && !cmt.equalsIgnoreCase("status") && !cmt.equalsIgnoreCase("quit")){
                    System.out.println("Unknown command");
                    
                }
                //attack
                if(cmt.equalsIgnoreCase("attack")){
                    if(wall.isAlive() == false){
                         System.out.println("\nThe wall is already destroyed!");
                    }
                    if(wall.isAlive()){
                        resolveCombat(player, wall);
                        if(wall.getHealth() <= 0){
                            System.out.println("\nThe wall has been destroyed!");
                        }
                    }
                    
                   
                }

                //step
                if(cmt.equalsIgnoreCase("step")){
                    if(player.isAlive()){
                        resolveCombat(Trap, player);
                    }
                    if(player.getHealth() <= 0){
                        System.out.println("The player has stepped on a trap and died!");
                        break;
                    }
                }

                //status
                if(cmt.equalsIgnoreCase("status")){
                    System.out.printf("Player Health: %d\n" ,player.getHealth());
                    System.out.printf("Wall Health: %d\n" ,wall.getHealth());
                }

                //quit
                if(cmt.equalsIgnoreCase("quit")){
                    break;
                }
            sc.close();
        }
        

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player(20, 5);
        Wall wall = new Wall(15);
        Trap trap = new Trap(10);
        System.out.println("Welcome to the Text Adventure!");
        runAdventureLoop(sc, player, wall, trap);
        System.out.println("Game Over. End of adventure.");
        sc.close();
    }

}
