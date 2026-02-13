//import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class SUM_FILE_INTEGER {
    public static void main(String[] args) {
        int sumInt = sumFileIntegers("inputFile.txt");
        System.out.println(sumInt);
        
    }
    public static int sumFileIntegers(String filename){
        int sum = 0;
        try{
            FileReader fr = new FileReader(filename);
            Scanner sc = new Scanner(fr);
            
            while(sc.hasNextLine()){
                String[] tokens = sc.nextLine().split("[\\s,]+");
                for(int i = 0; i < tokens.length;i++){
                    try{
                        int x = Integer.parseInt(tokens[i]);
                        sum += x;
                    }catch(NumberFormatException e){
                        
                    }
                    
                }
            }
            sc.close();

        }catch(FileNotFoundException e){
            System.out.println("File not found!!!");
        }
        return sum;
    }
}
