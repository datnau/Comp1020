public class Lab7Ex12345 {
  public static void main(String args[]) {
    int[][] sq1 = {{ 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 }};
    int[][] sq2 = {{ 1, 1, 1 }, { 5, 5, 5 }, { 0, 9, 9 }};
    int[][] sq3 = {{ 10, 3, 13, 8 }, { 5, 16, 2, 11 }, { 4, 9, 7, 14 }, { 15, 6, 12, 1 }};
    int[][] sq4 = {{ 21, 3, 4, 12, 25 }, { 15, 17, 6, 19, 8 }, { 10, 24, 13, 2, 16 }, { 18, 7, 20, 9, 11 }, { 1, 14, 22, 5, 23 }};
    int[][] sq5 = {{ 1, 2, 3 }, { 3, 2, 1 }, { 1, 1, 11 }};

    System.out.println("sq1:");
    printSquare(sq1);
    System.out.println("\nsq2:");
    printSquare(sq2);
    System.out.println("\nsq3:");
    printSquare(sq3);
    System.out.println("\nsq4:");
    printSquare(sq4);
    System.out.println("\nsq5:");
    printSquare(sq5);

    System.out.println("\nTesting checkRows():");
    verify(3, checkRows(sq1), "checkRows(sq1)");
    verify(1, checkRows(sq2), "checkRows(sq2)");
    verify(4, checkRows(sq3), "checkRows(sq3)");
    verify(5, checkRows(sq4), "checkRows(sq4)");
    verify(0, checkRows(sq5), "checkRows(sq5)");

    System.out.println("\nTesting checkColumns():");
    verify(3, checkColumns(sq1), "checkColumns(sq1)");
    verify(2, checkColumns(sq2), "checkColumns(sq2)");
    verify(4, checkColumns(sq3), "checkColumns(sq3)");
    verify(3, checkColumns(sq4), "checkColumns(sq4)");
    verify(1, checkColumns(sq5), "checkColumns(sq5)");

    System.out.println("\nTesting checkDiagonals():");
    verify(2, checkDiagonals(sq1), "checkDiagonals(sq1)");
    verify(1, checkDiagonals(sq2), "checkDiagonals(sq2)");
    verify(2, checkDiagonals(sq3), "checkDiagonals(sq3)");
    verify(1, checkDiagonals(sq4), "checkDiagonals(sq4)");
    verify(0, checkDiagonals(sq5), "checkDiagonals(sq5)");

    System.out.println("\nTesting checkValues():");
    verify(0, checkValues(sq1), "checkValues(sq1)");
    verify(6, checkValues(sq2), "checkValues(sq2)");
    verify(0, checkValues(sq3), "checkValues(sq3)");
    verify(0, checkValues(sq4), "checkValues(sq4)");
    verify(6, checkValues(sq5), "checkValues(sq5)");

    System.out.println("\nEnd of processing.");
  }
  
  public static void printSquare(int[][] sq) {
    for (int r = 0; r < sq.length ; r++) {
      System.out.print("[ ");
      for (int c = 0; c < sq.length; c++) {
        System.out.printf("%3d ", sq[r][c]);
      }
      System.out.println("]");
    }
  }

  public static int checkRows(int[][] sq){
    int count = 0;
    for(int i = 0;i < sq.length; i++){
        int sum = 0;
        for(int j = 0; j < sq[i].length; j++ ){
            sum += sq[i][j];
            if(sum == magicConstant(sq)){
                count++;
            }
        }
    }
    return count;
   }

   public static int checkColumns(int[][] sq){
    int count = 0;
    for(int i = 0;i < sq.length; i++){
        int sum = 0;
        for(int j = 0; j < sq[i].length; j++ ){
            sum += sq[j][i];
            if(sum == magicConstant(sq)){
                count++;
            }
        }
    }
    return count;
   }
   public static int checkDiagonals(int[][] sq){
    int n = sq.length;
    int magic = magicConstant(sq);
    int count = 0;

    int sumMain = 0;
    int sumAnti = 0;

    for (int i = 0; i < n; i++) {
        sumMain += sq[i][i];           
        sumAnti += sq[i][n - 1 - i];   
    if (sumMain == magic){
        count++;
    } 
    if (sumAnti == magic){
        count++;
    } 
    }
    return count;
   }

   public static int checkValues(int[][] sq) {
    int n = sq.length;
    int max = n * n;
    int errors = 0;
    int[] seen = new int[max];   
    int current = 0;
    for (int i = 0; i< n; i++) {
        for (int j = 0; j < n; j++) {
            int value = sq[i][j];
            if (value < 1 || value > max) {
                errors++;
                continue;
            }
            int[] prefix = new int[current];
            for (int k = 0; k < current; k++) {
                prefix[k] = seen[k];
            }

            if (linearSearch(prefix, value)) {
                errors++;
            } else {
                seen[current] = value;
                current++;
            }
        }
    }
    return errors;
}

   public static boolean linearSearch(int[] arr, int key){
    for(int i = 0; i < arr.length; i++){
        if(arr[i] == key){
            return true;
        }
    }
    return false;
   }

  // Used in exercises 2-5:
  
  public static void verify(int expected, int result, String action) {
    if (expected == result) {
      System.out.printf("Test succeeded: %s\n", action);
    } else {
      System.out.printf("Test FAILED (expected %d, got %d): %s\n", expected, result, action);
    }
  }
  
  public static int magicConstant(int[][] sq) {
    int squareSize = sq.length;
    return (squareSize * (squareSize * squareSize + 1))/2;
  }
}
