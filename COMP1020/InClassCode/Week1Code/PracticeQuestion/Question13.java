
public class Question13 {

    public static void main(String[] args) {
        String s = "Comp1020";
        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                index = i;
                break;

            }
        }
        System.out.println(index);
    }
}
