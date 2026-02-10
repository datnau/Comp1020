
public class Question23 {

    public static void main(String[] args) {
        for (int c = -20; c <= 40; c += 5) {
            double f = c * 9.0 / 5.0 + 32;
            System.out.printf("%3d C -> %5.1f F\n", c, f);
        }
    }
}
