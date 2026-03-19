public class Question27 {
    public static void main(String[] args) {

        int[][] arr = generatePascal(4);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    public static int[][] generatePascal(int n) {
        int[][] pascal = new int[n][];

        for (int r = 0; r < n; r++) {
            pascal[r] = new int[r + 1];   // hàng r có r+1 phần tử
            pascal[r][0] = 1;             // phần tử đầu = 1
            pascal[r][r] = 1;             // phần tử cuối = 1

            for (int c = 1; c < r; c++) {
                pascal[r][c] = pascal[r - 1][c - 1] + pascal[r - 1][c];
            }
        }
        return pascal;
    }
}
