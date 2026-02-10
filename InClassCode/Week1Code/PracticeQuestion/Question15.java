
public class Question15 {

    public static void main(String[] args) {
        int[] data = {3, -1, 0, 7, -2, 4};
        int write = 0;
        for (int read = 0; read < data.length; read++) {
            if (data[read] >= 0) {
                data[write] = data[read];
                write++;
            }
        }
        System.out.println(java.util.Arrays.toString(data));
    }
}
