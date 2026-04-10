public class Board {
    private char[][] board;
    private int players;
    private int width;
    private int height;
    private int connect;

    public Board(int players, int width, int height, int connect) {
        this.players = players;
        this.width = width;
        this.height = height;
        this.connect = connect;

        board = new char[height][width];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void display() {
        for (int j = 0; j < board[0].length; j++) {
            System.out.print((j + 1) + "  ");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }
}