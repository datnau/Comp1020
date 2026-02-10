public class exercise9 {
    public static void main(String[] args){
    
       
        System.out.println( isPalindrome(121));
        
    }
    public static boolean isPalindrome(int x) {
        String num = Integer.toString(x);
        String reverseNum = "";
        for(int i =  num.length()-1; i >=0 ;i--){
            reverseNum += num.charAt(i);
        }
        if(num.equals(reverseNum)){
            return true;
        }else{
            return false;
        }



    }
}
