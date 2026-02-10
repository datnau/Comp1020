
public class scopeExample {

    public static void main(String[] args) {
        int var = 10;
        System.out.println(var);

        for (int i = 0; i < 5; i++) {
            int x = i;
            System.out.println(x);
        }
        System.out.println(x);
    }
}
