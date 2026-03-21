import java.util.ArrayList;
import java.util.Arrays;
public class question51{
    public static void main(String[] args) {
        String str = "xin chao toi ten la Brown";

        String reverseStr = reverse(str);

        System.out.println(reverseStr);

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Chips");
        list.add("Hello");
        list.add("Bonjour");
        list.add("Hello");
        list.add("Hi");
        removeDuplicates(list);
        System.out.println(list);
        int[][] a = {
        {1, 2, 3},
        {4, 5, 6}
        };

        int[][] b = {
        {10, 20, 30},
        {40, 50, 60}
        };

        int[][] sum = add(a, b);

        for (int i = 0; i < sum.length; i++) {
            System.out.println(Arrays.toString(sum[i]));
        }

        String palindrome = "noon";
        System.out.println(isPalindrome(palindrome));

    }
    public static String reverse(String s){
        if(s.length() <= 1) return s;
        return s.substring(s.length() - 1) + reverse(s.substring(0,s.length()-1));
    }
    public static void removeDuplicates(ArrayList<String> list){
        for(int i = 0; i < list.size();i++){
            for(int j = i + 1; j < list.size() ;j++){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                    j--;
                }
            }
        }
    }
    public static int[][] add(int[][]a, int[][] b){
        int[][] arr = new int[a.length][a[0].length];
        for(int i = 0; i < a.length;i++ ){
            for(int j = 0; j < a[i].length ;j++ ){
                arr[i][j] = a[i][j] + b[i][j];
            }
        }
        return arr;
    }

    public static boolean isPalindrome(String s){
        if(s == null) return false;
        s.toLowerCase();
        return isPalindromeHelper(s,0,s.length()-1);
    }

    public static boolean isPalindromeHelper(String s, int left, int right){
        if(left>= right) return true;
        if(s.charAt(left) != s.charAt(right))return false;
        return isPalindromeHelper(s, left + 1, right - 1);
    }
}