
import java.util.Scanner;

public class Question25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int secret = 42;
            System.out.println("Enter your guessing number: ");
            int guessNum = sc.nextInt();
            if (guessNum > secret) {
                System.out.println("Too high");
            }
            if (guessNum < secret) {
                System.out.println("Too low");
            }
            if (guessNum == secret) {
                System.out.println("Correct");
                break;
            }
        }
        sc.close();
    }
}
