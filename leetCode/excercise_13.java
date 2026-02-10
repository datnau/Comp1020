package leetcode;

import java.util.Scanner;

//import java.util.*;
public class excercise_13{
    
    
    public static int getValue(char value) {
        switch(value) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        
        }
    }
    public static int romanToInt(String s){
        int value = 0;
        for(int i=0; i < s.length(); i++){
            int curr = getValue(s.charAt(i));
            if( i + 1 < s.length()){
                int next = getValue(s.charAt(i+1));
                if(curr < next){
                    value -= curr;
                    continue;
                }
            }
            
            value += curr;
            
        }
        return value;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Roman numeral: ");
        String str = sc.nextLine();

        int romanNum = romanToInt(str);
        System.out.println(romanNum);
        sc.close();
    }
}


