package leetcode;

public class excercise_14 {
    public static String longestCommonPrefix(String[] strs){
        String word = "";
        for(int i = 0; i < strs.length-1; i++){
            if(strs[1].charAt(i) == strs[i+1].charAt(i)){
                word += strs[1].charAt(i);
            }
        }
        return word;
    }
    public static void main(String[] args) {
        String[] output = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(output));
    }
}
