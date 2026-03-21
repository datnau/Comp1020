public class Question27 {
    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int n){
        if(n > 0){
            System.out.print(n + " ");
            printPattern(n - 1);
            System.out.print(n + " ");
        }
    }
}
