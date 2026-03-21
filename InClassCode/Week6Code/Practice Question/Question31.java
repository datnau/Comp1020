public class Question31 {
    public static void main(String[] args) {
        toBinary(80);
    }

    public static void toBinary(int n){
        if(n < 2){
            System.out.print(n);
            return;

        } 
        toBinary(n/2);
        System.out.print(n%2);
        


    }
}
