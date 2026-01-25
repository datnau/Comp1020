
import java.util.Scanner;

public class Question21 {

    public static void calculateWeight(double assignment, double test, double finalExam) {
        if (assignment > 100 || test > 100 || finalExam > 100 || assignment < 0 || test < 0 || finalExam < 0) {
            System.out.println("INVALID INPUT!!!");
        }
        double weight = assignment * 0.4 + test * 0.3 + finalExam * 0.3;
        char grade = ' ';

        if (weight >= 90 && weight < 100) {
            grade = 'A';
        }
        if (weight >= 80 && weight < 90) {
            grade = 'B';
        }
        if (weight >= 70 && weight < 80) {
            grade = 'C';
        }
        if (weight >= 50 && weight < 70) {
            grade = 'D';
        }
        if (weight < 50) {
            grade = 'F';
        }
        System.out.printf("Your weights is %.1f \n ", weight);
        System.out.println("You get grade " + grade);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your assignment grade: ");
        double assignment = sc.nextDouble();

        System.out.println("Enter your test grade: ");
        double test = sc.nextDouble();

        System.out.println("Enter your final exam grade: ");
        double finalExam = sc.nextDouble();

        calculateWeight(assignment, test, finalExam);

        sc.close();
    }
}
