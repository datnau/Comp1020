
public class Lab1Ex7 {

    public static void main(String[] args) {
        String[] words = {"cat", "banana", "apple", "kiwi", "watermelon"};

        String longest = getMaxLength(words);

        System.out.println("Longest string: " + longest);
        System.out.println("Length: " + longest.length());
    }

    public static String getMaxLength(String[] strings) {
        if (strings == null || strings.length == 0) {
            return null;
        }
        int length = strings[0].length();
        String longestString = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (length < strings[i].length()) {
                length = strings[i].length();
                longestString = strings[i];
            }
        }
        return longestString;
    }
}
