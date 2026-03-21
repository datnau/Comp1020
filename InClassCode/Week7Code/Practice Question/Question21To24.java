public class Question21To24 {
    public static void main(String[] args) {
        CharMatrix matrix1 = new CharMatrix(5, 5,'0');
        CharMatrix matrix2 = new CharMatrix(5, 5,'0');
        CharMatrix matrix3= new CharMatrix(5, 5,'0');
        CharMatrix matrix4 = new CharMatrix(5, 5,'0');
        CharMatrix matrix5 = new CharMatrix(5, 5,'0');
        CharMatrix matrix6 = new CharMatrix(5, 5,'0');
        CharMatrix matrix7 = new CharMatrix(5, 5,'0');
        matrix1.display();
        System.out.println();

        matrix1.fillTopHalf();
        matrix1.display();
        System.out.println();

        matrix2.fillEvenRows();
        matrix2.display();
        System.out.println();

        matrix3.fillEvenCols();
        matrix3.display();
        System.out.println();

        matrix4.fillFrontDiagonal();
        matrix4.display();
        System.out.println();

        matrix5.fillAboveDiagonal();
        matrix5.display();
        System.out.println();

        matrix6.fillBelowDiagonal();
        matrix6.display();
        System.out.println();

        matrix7.fillChessBoard();
        matrix7.display();
        System.out.println();

        

        
    }
}
