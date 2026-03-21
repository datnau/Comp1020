public class Question24 {
    public static void main(String[] args) {
        int count = countChars("banana", 'a');
        System.out.println(count);
        
    }

    public static int countChars(String str, char c){
        if(str.length() == 0){
            return 0;
        }
        if(str.charAt(0) == c){
            return 1 + countChars(str.substring(1), c);
        }
        return countChars(str.substring(1), c);
        
    }
}
