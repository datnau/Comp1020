public class Board {
    private int[][] board;
    private int players;
    private int width;
    private int height;
    private int connect;

    public Board(int players, int width, int height, int connect) {
        this.players = players;
        this.width = width;
        this.height = height;
        this.connect = connect;

        board = new int[height][width]; 
 
    }

    public void display() {
        for (int j = 0; j < width; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}