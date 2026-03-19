public class Question30 {
    public static void main(String[] args) {
        char[][] board = {
    {'X', 'O', 'O', 'O'},
    {'O', 'X', 'O', 'O'},
    {'O', 'O', 'X', 'O'},
    {'O', 'O', 'O', 'O'}
};
char[][] board2 = {
    {'X', 'X', 'X', 'O'},
    {'O', 'O', 'O', 'O'},
    {'O', 'O', 'O', 'O'},
    {'O', 'O', 'O', 'O'}
};
char[][] board3 = {
    {'O', 'X', 'O', 'O'},
    {'O', 'X', 'O', 'O'},
    {'O', 'X', 'O', 'O'},
    {'O', 'O', 'O', 'O'}
};
char[][] board4 = {
    {'O', 'X', 'O', 'O'},
    {'O', 'O', 'X', 'O'},
    {'O', 'O', 'O', 'X'},
    {'O', 'O', 'O', 'O'}
};
char[][] board5 = {
    {'O', 'O', 'O', 'X'},
    {'O', 'O', 'X', 'O'},
    {'O', 'X', 'O', 'O'},
    {'O', 'O', 'O', 'O'}
};

System.out.println(checkWin(board, 'X'));
System.out.println(checkWin(board2, 'X'));
System.out.println(checkWin(board3, 'X'));
System.out.println(checkWin(board4, 'X'));
System.out.println(checkWin(board5, 'X'));
        
    }

    public static boolean checkWin(char[][] board, char p){
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if(c + 2 < board[r].length && board[r][c] == p && board[r][c+1] == p && board[r][c+2] == p) return true;
                if(r + 2 < board.length && board[r][c] == p && board[r+1][c] == p && board[r+2][c] == p) return true;
                if(r + 2 < board.length && c + 2 < board[r].length && board[r][c] == p && board[r+1][c+1] == p && board[r+2][c+2] == p) return true;
                if(r + 2 < board.length && c - 2 >= 0 && board[r][c] == p && board[r+1][c-1] == p && board[r+2][c-2] == p) return true;
            }
        }
        return false;
    }
}
