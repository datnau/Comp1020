//import java.util.Scanner;

public class palindrome{
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String num = sc.nextLine();

        int[] arr = {1,2,5,4,4,3,2,1};

        boolean check = isPalindrome(arr, 0, arr.length - 1);
        System.out.println(check);

        
        
    }

    public static boolean isPalindrome(int[] arr,int start, int end){
        boolean check = true;
        if(arr[start] != arr[end]){
            return false;
        }
        if(start == end){
            return check;
        }
    
        return check && isPalindrome(arr, start+1, end-1);
           
        
        
    }
}