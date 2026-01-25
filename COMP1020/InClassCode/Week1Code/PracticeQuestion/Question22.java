
public class Question22 {

    public static void main(String[] args) {
        int[] steps = {5000, 6200, 4800, 7100, 7100, 3000, 9000};
        int numStep = 0;

        int maxStep = steps[0];
        int dayNum = 0;
        for (int i = 0; i < steps.length; i++) {
            numStep += steps[i];
        }
        double stepAvg = (double) numStep / 7;
        System.out.printf("The total number of step is %d\n", numStep);
        System.out.printf("The average of step is %.2f\n ", stepAvg);

        for (int i = 1; i < steps.length; i++) {
            if (steps[i] > maxStep) {
                maxStep = steps[i];
                dayNum = i;
            }
        }
        dayNum += 1;
        System.out.println("The maximum number of step is " + maxStep + " on day " + dayNum);

    }
}
