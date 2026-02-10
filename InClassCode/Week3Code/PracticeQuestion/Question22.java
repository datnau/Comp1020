public class Question22 {
    public static void main(String[] args) {
        String str = "HELLO WORLD";
        String reversedString = reverseAString(str);
        System.out.println(reversedString);

        
    }
    public static  String reverseAString(String str){
            StringBuilder sb = new StringBuilder();
            if(str == null){
               return null;
            }
            for(int i = str.length() - 1; i >= 0; i--){
                sb = sb.append(str.charAt(i));
            }

            return sb.toString();
    }
}
