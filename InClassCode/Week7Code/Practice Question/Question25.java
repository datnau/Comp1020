public class Question25 {
    public static void main(String[] args) {
        int[][] a = {
    {1, 3, 5, 7, 9, 2},
    {4, 6, 8, 1, 3, 5},
    {7, 9, 2, 4, 6, 8},
    {1, 0, 3, 5, 7, 9},
    {2, 4, 6, 8, 1, 3}
};

int[][] b = {
    {9, 7, 5, 3, 1, 0},
    {8, 6, 4, 2, 9, 7},
    {5, 3, 1, 8, 6, 4},
    {2, 0, 7, 5, 3, 1},
    {9, 8, 6, 4, 2, 0}
};
     
        int[][] arr = add(a, b);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] add(int[][] a, int[][] b){
        int[][] arr = new int[a.length][a[0].length];

        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[r].length; c++){
                arr[r][c] = a[r][c] + b[r][c];
            }
        }
        return arr;
    }
}
