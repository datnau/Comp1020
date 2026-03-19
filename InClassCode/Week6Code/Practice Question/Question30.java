public class Question30 {
    public static void main(String[] args) {
        System.out.println(indexOf("banana", 'a')); // 1
        System.out.println(indexOf("banana", 'n')); // 2
        System.out.println(indexOf("banana", 'z')); // -1
        
    }


    public static int indexOf(String text, char target){
        return indexOfHelper(text, target, 0);
        
    }

    public static int indexOfHelper(String text, char target, int index){
        if(index == text.length()) return -1;
        if(text.charAt(index) == target){
            return index;
        }
        return indexOfHelper(text, target, index + 1);

    }
}
