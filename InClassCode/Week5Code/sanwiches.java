public class sanwiches {
    public static void main(String[] args) {
        int sandwiches = countSmallSandwiches("ababa");
        System.out.println(sandwiches);
    }

    public static int countSmallSandwiches(String s){
        int count = countSmallSanwichesHelper(s, 0, s.length() - 1, 0);
        return  count;
    }

    public static int countSmallSanwichesHelper(String s, int left, int right, int count){
        if(left >= right){
            return count;
        }
        if(s.charAt(left) != s.charAt(right)){
            return count;
        }
        return countSmallSanwichesHelper(s, left + 1, right - 1, count + 1);
        
        
        
    }
} 