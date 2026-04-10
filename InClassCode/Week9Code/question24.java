import java.util.Stack;

public class question24 {
    public static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isBalanced("(())"));
        System.out.println(isBalanced("()()"));
        System.out.println(isBalanced("())("));
        System.out.println(isBalanced("((()"));
    }


}
