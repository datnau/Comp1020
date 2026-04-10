public class excercise14 {
    public static String longestCommonPrefix(String[] strs){
        StringBuilder sb = new StringBuilder();
        String error = "";
        int count = 0;
        int lowest_length = 0;
        if(strs == null || strs.length == 0){
            return error;

        }
        if(strs.length == 1 ){
            return strs[0];
        } 
        for (int i = 0; i <strs.length; i++) {
            if(strs[i] == null) return error;
            if(strs[i].length() > lowest_length){
                lowest_length = i;
            }

            
        }

        if(strs.length >= 1){
            for(int  i = 0;  i < strs.length; i++){
                if(count < lowest_length){
                    if(strs[i].charAt(count) == strs[lowest_length].charAt(count) && i != lowest_length){
                        sb.append(strs[i].charAt(count));
                    }
                }
               

                  
            }
        }
        String result = sb.toString();
        if(result.length() > 0){
            return result;
        }         
        return error;
        
    }
    public static void main(String[] args) {
        String[] output = {"dog","racecar","car"};
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(output));
        System.out.println(longestCommonPrefix(strs));
    }
        

}
    

