public class A3Phase1{
    public static String rulerSequence(int n){
        String prev;
        String result;
        if(n == 1){
            return "0";
        }if(n <= 0){
            return "";
        }
        prev = rulerSequence(n - 1);
        result = prev + (n-1) + prev;
        return  result;
    }
    public static void printAAN(String[] adjectives, String[] nouns){

    }

    public static

    public static void main(String[] args) {
        String result = rulerSequence(8);
        System.out.println(result);
    }
}