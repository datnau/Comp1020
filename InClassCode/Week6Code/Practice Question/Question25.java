public class Question25 {
    public static void main(String[] args) {
        System.out.println(pascal(10,6));
        
    }


    public static int pascal(int row, int col){
        if(col == 0 || col == row){
            return 1;
        }
        return pascal(row - 1, col - 1) + pascal(row - 1, col);
    }
}
