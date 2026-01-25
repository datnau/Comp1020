
public class Question16 {

    public static void main(String[] args) {
        int x = -7;
        int clamped = Math.min(100, Math.max(0, x));
        System.out.println(clamped);
        System.out.println(x);
        int y = Math.min(Math.max(0, x), 100);
        System.out.println(y);

    }
}
