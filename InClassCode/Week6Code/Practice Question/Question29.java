public class Question29 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("noom"));
    }

    public static boolean isPalindrome(String s){
        return isPalindromeHelper(s, 0, s.length() - 1);
        
    }

    public static boolean isPalindromeHelper(String s, int start, int end){
        if(start >= end) return true;
        if(s.charAt(start) != s.charAt(end)) return false;

        return isPalindromeHelper(s, start + 1, end - 1);
    }
}