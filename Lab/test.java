
public class test {

    public static void drawColumns(int start, int end, int increment) {
        for (int i = start; i <= end; i += increment) {
            System.out.println(i);

        }
    }

    public static void main(String[] args) {
        drawColumns(0, 10752, 256);

    }
}
