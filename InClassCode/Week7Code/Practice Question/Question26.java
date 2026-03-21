public class Question26 {
    public static void main(String[] args) {
       int[][] a = {
            {1, 3, 5, 7, 9, 2},
            {4, 6, 8, 1, 3, 5},
            {7, 9, 2, 4, 6, 8},
            {1, 0, 3, 5, 7, 9},
            {2, 4, 6, 8, 1, 3}
        };

        int[][] b = {
            {1, 2, 3},
            {2, 4, 5},
            {3, 5, 6}
        };

        System.out.println(isSymmetric(a)); // false
        System.out.println(isSymmetric(b)); // true
    }


    public static boolean isSymmetric(int[][] matrix) {
      
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length) {
                return false;
            }
        }

      
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

}
