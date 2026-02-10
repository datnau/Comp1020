public class Question25 {
    public static void main(String[] args) {
        String str = "plolp";
        Boolean palineDrome = isPalinrome(str);
        System.out.println(palineDrome);
    }

    public static boolean isPalinrome(String str){
        if(str.trim() == null){
            return false;
        }
        str = str.toLowerCase();
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;

    }
}
