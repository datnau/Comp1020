public class Question28 {
    public static void main(String[] args) {
        String text1 = "Java is fun to learn";
        System.out.println(containsWord(text1, "fun"));   // true
        System.out.println(containsWord(text1, "FUN"));   // true
        System.out.println(containsWord(text1, "python"));// false

        String text2 = "Java   is\tfun   to   learn";
        System.out.println(containsWord(text2, "fun"));   // (depends on your split)

        String text3 = "Java is fun, to learn.";
        System.out.println(containsWord(text3, "fun"));   // (depends on your split)

        System.out.println(containsWord(null, "fun"));    // false
        System.out.println(containsWord(text1, null));    // false
    }

    public static boolean containsWord(String text, String keyword){
        if(text == null || keyword == null){
            return false;
        }
        String[] texts = text.split("[\\s,]+");
        for(int i = 0; i < texts.length ; i++ ){
            if(texts[i].equalsIgnoreCase(keyword)){
                return true;
            }
        }
        return false;
    }
}
