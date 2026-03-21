public class Question21{
    public static void main(String[] args) {

        int digits = 1234;

        System.out.println(sumOfDigits(digits));
        
    }


    public static int sumOfDigits(int num){
        if(num < 10){
            return num;
        }
        return (num%10) + sumOfDigits(num/10);
    }
}