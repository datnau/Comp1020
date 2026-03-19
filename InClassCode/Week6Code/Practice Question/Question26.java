public class Question26 {
    public static void main(String[] args) {
        pattern(6);
    }

    public static void printStars(int n) {
        if (n <= 0) {
            return;
        }

        System.out.print("*");
        printStars(n - 1);
    }

    public static void pattern(int n) {
        patternHelper(1, n);
    }

    public static void patternHelper(int current, int n) {
        if (current > n) {
            return;
        }

        printStars(current);
        System.out.println();

        patternHelper(current + 1, n);

        if (current < n) {
            printStars(current);
            System.out.println();
        }
    }
}