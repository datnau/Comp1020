import java.util.Arrays;

public class IClickerMultiArray {
    public static void main(String[] args) {
        int [] row = {1,2,3};
        int[][] matrix = {row, row};

        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(matrix));

        matrix[0][0] = 99;

        System.out.println(matrix[1][0]);
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(matrix));
    }
}
