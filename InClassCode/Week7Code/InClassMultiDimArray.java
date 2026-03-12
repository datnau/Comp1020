import java.util.Arrays;

public class InClassMultiDimArray {
    public static void main(String[] args) {
        int [] row = {1,2,3};
        int [][] matrix = {row, row};
        int [][][] cube = {
            matrix, { row }, {{4,5,6}, {6,7,8}}, {row , { 8,9,10}}
        };
        int [][][][] hypercube = {
            cube, { matrix, {row}} , {{{1,2,3}}}, {{{4,5,6}, row}, matrix}
        };

        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(matrix));
        System.out.println(Arrays.toString(cube));
        System.out.println(Arrays.toString(hypercube));
    }
}
