import java.util.Scanner;

public class A3Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] setup = new int[4];
        int players;
        int width;
        int height;
        int connect;

        while (true) {
            System.out.println("Enter # players,board width,board height,connect N:");
            String input = sc.nextLine();

            String error = setupCSV(input, setup);
            if (error == null) {
                break;
            } else {
                System.out.println("Invalid input string: " + input);
            }
        }

        players = setup[0];
        width = setup[1];
        height = setup[2];
        connect = setup[3];

        int[][] board = new int[height][width];
        int currentPlayer = 1;
        boolean finished = false;

        System.out.println();
        System.out.println("Welcome to Connect " + connect + "!");
        printBoard(board);

        while (!finished) {
            System.out.print("Player " + currentPlayer + "'s move? ");
            String moveInput = sc.nextLine().trim();

            int column;

            try {
                column = Integer.parseInt(moveInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid column: " + moveInput);
                printBoard(board);
                continue;
            }

            if (!playDisc(board, currentPlayer, column)) {
                System.out.println("Invalid column: " + column);
                printBoard(board);
                continue;
            }

            boolean someoneWon = false;

            for (int p = 1; p <= players; p++) {
                if (checkPlayerWin(board, p, connect)) {
                    System.out.println("Player " + p + " has won!");
                    someoneWon = true;
                }
            }

            printBoard(board);

            if (someoneWon) {
                System.out.println("Game over.");
                finished = true;
            } else {
                currentPlayer++;
                if (currentPlayer > players) {
                    currentPlayer = 1;
                }
            }
        }

        sc.close();
    }

    public static String setupCSV(String input, int[] result) {
        if (input == null) {
            return "Input is null.";
        }
        if (result == null || result.length != 4) {
            return "Result array must have length 4.";
        }

        String[] parts = input.split(",");
        if (parts.length != 4) {
            return "Input must contain exactly four comma-separated values.";
        }

        int players;
        int width;
        int height;
        int n;

        try {
            players = Integer.parseInt(parts[0].trim());
            width = Integer.parseInt(parts[1].trim());
            height = Integer.parseInt(parts[2].trim());
            n = Integer.parseInt(parts[3].trim());
        } catch (NumberFormatException e) {
            return "All four values must be integers.";
        }

        if (players < 2 || players > 9) {
            return "Number of players must be between 2 and 9.";
        }
        if (width < 3 || width > 25) {
            return "Board width must be between 3 and 25.";
        }
        if (height < 3 || height > 12) {
            return "Board height must be between 3 and 12.";
        }
        if (n < 3 || n > Math.max(width, height)) {
            return "Connect N must be between 3 and max(width,height).";
        }

        result[0] = players;
        result[1] = width;
        result[2] = height;
        result[3] = n;

        return null;
    }

    public static void printBoard(int[][] board) {
        if (board == null) {
            return;
        }
        if (board.length == 0 || board[0] == null) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            if (board[r] == null || board[r].length != cols) {
                return;
            }
        }

        for (int c = 1; c <= cols; c++) {
            System.out.printf("%-3d", c);
        }
        System.out.println();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String value = (board[r][c] == 0) ? "." : Integer.toString(board[r][c]);
                System.out.printf("%-3s", value);
            }
            System.out.println();

            if (r < rows - 1) {
                System.out.println();
            }
        }
    }

    public static boolean playDisc(int[][] board, int player, int column) {
        if (!isValidBoard(board)) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        if (column < 1 || column > cols) {
            return false;
        }
        if (player < 1) {
            return false;
        }

        int col = column - 1;

        for (int r = rows - 1; r >= 0; r--) {
            if (board[r][col] == 0) {
                board[r][col] = player;
                return true;
            }
        }

        for (int r = rows - 1; r >= 1; r--) {
            board[r][col] = board[r - 1][col];
        }
        board[0][col] = player;

        return true;
    }

    public static boolean checkPlayerWin(int[][] board, int player, int n) {
        if (!isValidBoard(board)) {
            return false;
        }
        if (player < 1 || n < 2) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] != player) {
                    continue;
                }

                if (countDirection(board, player, r, c, 0, 1) >= n) {
                    return true;
                }
                if (countDirection(board, player, r, c, 1, 0) >= n) {
                    return true;
                }
                if (countDirection(board, player, r, c, 1, 1) >= n) {
                    return true;
                }
                if (countDirection(board, player, r, c, 1, -1) >= n) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int countDirection(int[][] board, int player, int row, int col, int dr, int dc) {
        int count = 0;
        int rows = board.length;
        int cols = board[0].length;

        int r = row;
        int c = col;

        while (r >= 0 && r < rows && c >= 0 && c < cols && board[r][c] == player) {
            count++;
            r += dr;
            c += dc;
        }

        return count;
    }

    private static boolean isValidBoard(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }

        int cols = board[0].length;
        for (int r = 0; r < board.length; r++) {
            if (board[r] == null || board[r].length != cols) {
                return false;
            }
        }

        return true;
    }
}