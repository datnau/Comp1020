import java.util.Scanner;
public class A4MainInterfaces {

    public static void resolveCombat(Attacker a, Defender d){
        if(a.getAttackPower() >= 0 && d.getHealth() > 0){
            d.takeDamage(a.getAttackPower());
        }
        System.out.printf("Combat resolved: Defender (%s) took %d damage from Attacker (%s)\n",d.getName(),a.getAttackPower(),a.getName());
    }

    public static void runAdventureLoop(Scanner sc, Player player, Wall wall, Trap Trap){
        
        while(player.isAlive() && sc.hasNextLine()){
            System.out.println("\nEnter command (attack, step, status, quit): ");

            String cmt = sc.nextLine();

                
                if(!cmt.equalsIgnoreCase("attack") && !cmt.equalsIgnoreCase("step") && !cmt.equalsIgnoreCase("status") && !cmt.equalsIgnoreCase("quit")){
                    System.out.println("Unknown command.");
                    
                }
                //attack
                if(cmt.equalsIgnoreCase("attack")){
                    if(!wall.isAlive()){
                         System.out.println("The wall is already destroyed!");
                    }
                    if(wall.isAlive()){
                        resolveCombat(player, wall);
                        if(!wall.isAlive()){
                            System.out.println("The wall has been destroyed!");
                        }
                    }
                    
                   
                }

                //step
                if(cmt.equalsIgnoreCase("step")){
                    if(player.isAlive()){
                        resolveCombat(Trap, player);
                    }
                    if(!player.isAlive()){
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
