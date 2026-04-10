public class Question21{
    public static void main(String[] args) {
        System.out.println(countIterativeDivs(30));
        
    }

    public static int countIterativeDivs(int target){
        int count = 0;
        while(target > 1){
            target /= 3; 
            count++;
        }
        return count;
    }
}