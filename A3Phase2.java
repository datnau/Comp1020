import java.util.Scanner;

public class A3Phase2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] result = new int[4];
        String setupInput = "";
        String setupError = "";
         
        // use setupCSV() to set a valid input for creating board
        while (true) {
            System.out.println("Enter # players,board width,board height,connect N:");
            setupInput = sc.nextLine();
            setupError = setupCSV(setupInput, result);

            if (setupError == null) {
                break;
            }

            System.out.println("Invalid input string: " + setupInput);
        }

        // create new board by using scanner
        int players = result[0];
        int width = result[1];
        int height = result[2];
        int n = result[3];

        int[][] board = new int[height][width];

        System.out.println();
        System.out.println("Welcome to Connect " + n + "!");
        printBoard(board);

        int currentPlayer = 1;

        while (true) {
            System.out.print("Player " + currentPlayer + "'s move? ");
            String moveInput = sc.nextLine();

            int column = 0;

            try {
                column = Integer.parseInt(moveInput.trim());
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid column: " + moveInput);
                printBoard(board);
                continue;
            }

            if (!playDisc(board, currentPlayer, column)) {
                System.out.println("Invalid column: " + column);
                printBoard(board);
                continue;
            }

            boolean[] winners = new boolean[players + 1];
            int winnerCount = 0;

            for (int player = 1; player <= players; player++) {
                if (checkPlayerWin(board, player, n)) {
                    winners[player] = true;
                    winnerCount++;
                }
            }

            if (winnerCount > 0) {
                for (int player = 1; player <= players; player++) {
                    if (winners[player]) {
                        System.out.println("Player " + player + " has won!");
                    }
                }

                printBoard(board);
                System.out.println("Game over.");
                break;
            }

            printBoard(board);

            currentPlayer++;
            if (currentPlayer > players) {
                currentPlayer = 1;
            }
        }

        sc.close();
    }






    public static String setupCSV (String input, int[] result){
        // check if input or result is null, if they are null, we cannot continue
        if (input == null || result == null){
            return "Error : Input or result is null";
        }
        // check if result array has exactly 4 elements
        if (result.length != 4){
            return "Error : Array must have 4 elements";
        }
        // split the array by ", ", in order to make it simpler to check arrays
        String[] parts = input.split(",");
        // check if we have enough 4 values
        if (parts.length != 4){
            return "CSV must have 4 values including : players, width, height, N";
        }
        // declare variables and store the value
        int players = 0;
        int width = 0;
        int height = 0;
        int N = 0;
        try {
            players = Integer.parseInt(parts[0].trim());
            width = Integer.parseInt(parts[1].trim());
            height = Integer.parseInt(parts[2].trim());
            N = Integer.parseInt(parts[3].trim());
        } catch (NumberFormatException nfe) {
            return "Error: invalid number format";
        }
        // check the validity of each variables, based on the limit that question give to us
        if (players < 2 || players > 9) {
            return "Invalid number of players";
        }

        if (width < 3 || width > 25) {
            return "Invalid width";
        }

        if (height < 3 || height > 12) {
            return "Invalid height";
        }

        if (N < 3 || N > Math.max(width, height)) {
            return "Invalid N";
        }
        // if all values are valid, then store them into result array
        result[0] = players;
        result[1] = width;
        result[2] = height;
        result[3] = N;
        // follow the question, return null if they are all valid
        return null; 
    }





    public static void printBoard(int[][] board) {

    // check if the board is null, according to assignment, if board is null, we should print nothing
    if (board == null) {
        return;
    }
    // get the number of rows from board
    int rows = board.length;
    // get the number of columns from board
    int cols = board[0].length;
    // if rows or columns are not positive, return. This prevents from invalid printing
    if (rows <= 0 || cols <= 0) {
        return;
    }
    // print the columns number
    for (int j = 0; j < cols; j++) {
        // assignment say column starts at 1, therefore, we should print j+1
        System.out.print(j + 1);
        // print two spaces between each number and not print extra spaces after last column
        if (j < cols - 1) {
            System.out.print("  ");
        }
    }
    // after printing all the columns, then we move to the next line
    System.out.println();
    // in this step, we print the board row by row
    // i print from rows - 1 to 0 so that the bottom row of the board appears first in the output
    for (int i = rows - 1; i >= 0; i--) {
        for (int j = 0; j < cols; j++) {
            // if the value is 0, that means the space is empty, we print "."
            if (board[i][j] == 0) {
                System.out.print(".");
            } else {
                // otherwise, we print the number player stored in each position
                System.out.print(board[i][j]);
            }
            // print two spaces between each elements, but not after the last elements in the row
            if (j < cols - 1) {
                System.out.print("  ");
            }
        }
        // after one full row has been printed, move to the next line
        System.out.println();
        // assignment says there should be a blank line between each row so i print one more extra line between rows
        System.out.println();
    }
  }

  public static boolean playDisc(int[][] board, int player, int column){
    // check if the board is null, if it is null, we cannot continue
    if (board == null){
        return false;
    }
    // get number of rows and columns
    int rows = board.length;
    int cols = board[0].length;
    // check the condition of these two : if there are no rows or no columns, return it false
    if (column < 1 || column > cols){
        return false;
    }
    // check if the column is in the range, it start at 1 so the range will be between 1 and # of column
    if (player < 1 || player > 9){
        return false;
    }

    // check if player is valid, ranging from 2 to 9
    // if (player < 2 || player > 9){
    //     return false;
    // }

    // convert column from 1-based to 0-based index
    int col = column - 1;
    // create a new variable to check if the disc is placed
    // boolean isPlaced = false;

    // traverse the loop from the bottom row to top row
    for (int i = 0; i < rows; i++){
        // check if the current element is empty and have we placed the disc yet
        if (board[i][col] == 0){
            // then, we placed the player's disc at this position
            board[i][col] = player;
            // and mark it we have placed the disc
            return true;
        }
    }
    // return true if the disc has been place, and false if has NOT
    return false;
  }
  public static boolean checkPlayerWin(int[][] board, int player, int n){
    // return false if the board does not exist
    if (board == null){
        return false;
    }
    // player 1 is also valid, so this accepts 1 to 9
     if (player < 1 || player > 9){
        return false;
    }
    // return false if the board is not structurally valid
    if (!isValidBoard(board)) {
        return false;
    }
    int rows = board.length;
    int cols = board[0].length;
    if(rows <= 0 || cols <= 0){
        return false;
    }
    // return false if n is not positive or larger than both dimensions
    if (n < 1 || n > Math.max(rows, cols)) {
        return false;
    }

    // check every position on the board as a possible starting point
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            // only continue checking directions if this cell belongs to the given player
            if (board[r][c] != player) {
                continue;
            }

            // check horizontal line
            if (hasLine(board, player, n, r, c, 0, 1)) {
                return true;
            }

            // check vertical line
            if (hasLine(board, player, n, r, c, 1, 0)) {
                return true;
            }

            // check diagonal down-right line
            if (hasLine(board, player, n, r, c, 1, 1)) {
                return true;
            }

            // check diagonal down-left line
            if (hasLine(board, player, n, r, c, 1, -1)) {
                return true;
            }
        }
    }

    return false;
  }



  public static boolean hasLine(int[][] board, int player, int n,
                                int startRow, int startCol,
                                int rowChange, int colChange) {
      for (int k = 0; k < n; k++) {
          int nextRow = startRow + k * rowChange;
          int nextCol = startCol + k * colChange;

          if (nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length) {
              return false;
          }

          if (board[nextRow][nextCol] != player) {
              return false;
          }
      }

      return true;
  }



  public static boolean isValidBoard(int[][] board) {
      if (board == null || board.length == 0) {
          return false;
      }

      if (board[0] == null || board[0].length == 0) {
          return false;
      }

      int cols = board[0].length;

      for (int i = 0; i < board.length; i++) {
          if (board[i] == null || board[i].length != cols) {
              return false;
          }
      }

      return true;
  }

}


