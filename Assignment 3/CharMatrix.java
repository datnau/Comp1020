public class CharMatrix {
    private char[][] board;

    public CharMatrix(int rows, int cols, char fill){
        board = new char[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                board[r][c] = fill;
            }
        }
    }

    public void display(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    public void fillTopHalf(){
        int half = (board.length / 2) ;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(r < half){
                    board[r][c] = 'T';
                }
            }
        }
    }

    public void fillEvenRows(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(r%2 != 0){
                    board[r][c] = '-';
                }
            }
        }
    }

    public void fillEvenCols(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(c%2 != 0){
                    board[r][c] = '-';
                }
            }
        }
    }

    public void fillFrontDiagonal(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(r == c){
                    board[r][c] = 'X';
                }
            }
        }
    }

    public void fillAboveDiagonal(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                    if(c>r)board[r][c] = 'U';
                
            }
        }
    }

    public void fillBelowDiagonal(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                    if(c<r)board[r][c] = 'U';
                
            }
        }
    }

    public void fillChessBoard(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                int sum = r + c;
                    if(sum%2 == 0)board[r][c] = 'O';
                    if(sum%2 != 0)board[r][c] = 'X';
                
            }
        }
    }

    


}
