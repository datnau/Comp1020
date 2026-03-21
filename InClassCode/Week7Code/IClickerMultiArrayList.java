import java.util.ArrayList;
import java.util.Arrays;

public class IClickerMultiArrayList {
    public static void main(String[] args) {
        int [] row = {1,2,3};
        ArrayList<int[]> matrix = new ArrayList<>();
        matrix.add(row);
        matrix.add(row);

        System.out.println(Arrays.toString(row));
        System.out.println(matrix);

        matrix.get(0)[0] = 99;

        System.out.println(matrix.get(0)[0]);
        System.out.println(Arrays.toString(row));
        System.out.println(matrix);
    }
}
