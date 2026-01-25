
import java.util.Scanner;

public class Question24 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your text: ");
        String text = sc.nextLine();
        String textLowerCase = text.toLowerCase();
        int vowels = 0;
        int consonant = 0;
        int other = 0;

        for (int i = 0; i < textLowerCase.length(); i++) {

            if (textLowerCase.charAt(i) >= 'a' && textLowerCase.charAt(i) <= 'z') {
                if (textLowerCase.charAt(i) == 'a' || textLowerCase.charAt(i) == 'e' || textLowerCase.charAt(i) == 'i' || textLowerCase.charAt(i) == 'o' || textLowerCase.charAt(i) == 'u') {
                    vowels++;
                } else {
                    consonant++;
                }

            } else {
                other++;
            }
        }
        System.out.println("Number of vowels is " + vowels);
        System.out.println("Numebr of consonant is " + consonant);
        System.out.println("Number of other is " + other);

        sc.close();

    }
}
