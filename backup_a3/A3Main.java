import java.util.Scanner;

public class A3Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter # players, board width, board height, connect N:");
            String input = sc.nextLine();

            String[] parts = input.split(",");

            if (parts.length != 4) {
                System.out.println("Invalid input string: " + input);
                continue;
            }

            try {
                int players = Integer.parseInt(parts[0].trim());
                int width = Integer.parseInt(parts[1].trim());
                int height = Integer.parseInt(parts[2].trim());
                int connect = Integer.parseInt(parts[3].trim());
                int startRow = height - 1;

                if (players < 2 || players > 9) {
                    System.out.println("Invalid players! Please enter a number from 2 to 9.");
                    continue;
                }

                if (width < 3 || width > 25) {
                    System.out.println("Invalid width! Please enter a number from 3 to 25.");
                    continue;
                }

                if (height < 3 || height > 12) {
                    System.out.println("Invalid height! Please enter a number from 3 to 12.");
                    continue;
                }

                if (connect < 3 || connect > Math.max(width, height)) {
                    System.out.println("Invalid connect! Please enter a number from 3 to max(width, height).");
                    continue;
                }

                Board b = new Board(players, width, height, connect);
                b.display();
                

            } catch (NumberFormatException e) {
                System.out.println("Invalid input string: " + input);
            }
        }

        
    }



    public static boolean checkPlayerWin(int[][] board, int player, int n) {
    if (board == null || board.length == 0 || board[0].length == 0) {
        return false;
    }

    if (player < 1 || n < 2) {
        return false;
    }

    int rows = board.length;
    int cols = board[0].length;

    // optional: reject ragged arrays
    for (int r = 0; r < rows; r++) {
        if (board[r] == null || board[r].length != cols) {
            return false;
        }
    }

    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            if (board[r][c] != player) {
                continue;
            }

            // horizontal
            if (c + n <= cols) {
                boolean win = true;
                for (int k = 0; k < n; k++) {
                    if (board[r][c + k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }

            // vertical
            if (r + n <= rows) {
                boolean win = true;
                for (int k = 0; k < n; k++) {
                    if (board[r + k][c] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }

            // diagonal down-right
            if (r + n <= rows && c + n <= cols) {
                boolean win = true;
                for (int k = 0; k < n; k++) {
                    if (board[r + k][c + k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }

            // diagonal down-left
            if (r + n <= rows && c - n + 1 >= 0) {
                boolean win = true;
                for (int k = 0; k < n; k++) {
                    if (board[r + k][c - k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
    }

    return false;
    }

    public static boolean playDisc(int[][] board, int player, int column) {
    if (board == null || board.length == 0 || board[0].length == 0) {
        return false;
    }

    if (player < 1) {
        return false;
    }

    if (column < 1 || column > board[0].length) {
        return false;
    }

    int colIndex = column - 1;

    for (int row = board.length - 1; row >= 0; row--) {
        if (board[row][colIndex] == 0) {
            board[row][colIndex] = player;
            return true;
        }
    }

    return false; // column full
    }

    public static void printBoard(int[][] board) {
    if (board == null) {
        return;
    }

    if (board.length == 0) {
        return;
    }

    if (board[0] == null) {
        return;
    }

    int cols = board[0].length;

    // Print column numbers, left-aligned
    for (int c = 0; c < cols; c++) {
        System.out.print((c + 1));
        if (c < cols - 1) {
            System.out.print("  ");
        }
    }
    System.out.println();

    // Print board rows
    for (int r = 0; r < board.length; r++) {
        if (board[r] == null) {
            System.out.println();
            System.out.println();
            continue;
        }

        for (int c = 0; c < board[r].length; c++) {
            if (board[r][c] == 0) {
                System.out.print(".");
            } else {
                System.out.print(board[r][c]);
            }

            if (c < board[r].length - 1) {
                System.out.print("  ");
            }
        }
        System.out.println();
        System.out.println();
    }
    }
}