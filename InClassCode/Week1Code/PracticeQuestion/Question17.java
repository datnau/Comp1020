
import java.util.Scanner;

public class Question17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int spacePos = line.indexOf(" ");

        String name = line.substring(0, spacePos);
        String ageText = line.substring(spacePos + 1);
        int age = Integer.parseInt(ageText);

        System.out.println(name + " will be " + (age + 1) + " next year. ");
        sc.close();
    }

}
