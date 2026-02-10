import java.util.Scanner;

public class Question24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) { 

            System.out.println("Enter postive numer: ");
            if(sc.hasNextInt()){
                int x = sc.nextInt();
                if( x < 0){
                    System.out.println("Number must be positive");
                    continue;
                }else{
                    System.out.println("End of Program");
                    break;
                }
            }if(sc.hasNext()){
                System.out.println("Not a number");
                continue;
            }
            sc.close();
            
        }
        
        
    }

}
