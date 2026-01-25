
public class Question12 {

    public static void main(String[] args) {
        int[] marks = {72, 85, 90, 60};
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        double avg = sum / marks.length;
        int countAbove = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] > avg) {
                countAbove++;
            }

        }
        System.out.println(sum);
        System.out.println(avg);
        System.out.println(countAbove);

    }
}
