public class Question28 {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {2, 4, 5},
            {3, 5, 6}
        };
        int[][] b = {
            {1, 2},
            {3, 4},
        };

        int[][] arr = rotateRight(a);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] arr2= rotateRight(b);
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    public static int[][] rotateRight(int[][] arr){
        int[][] matrix = new int[arr.length][arr[0].length];

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                matrix[c][arr.length - 1 - r] = arr[r][c];
            }
        }
        return matrix;


    }
}
