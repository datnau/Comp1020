import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Lab3Ex4 {
  public static final int MAX_INTEGERS = 20;
  public static String FILE_NAME = "numbers4.txt";

  public static void main(String[] args) {
    int[] numbers = new int[MAX_INTEGERS];
    int numbersSize = 0;
    
    numbersSize = readNumbersToArray(FILE_NAME, numbers);
    
    if (numbersSize <= 0) {
      System.out.println("No array was read.");
    } else {
      System.out.println("The following array was read:");
      printNumbers(numbers, numbersSize);
    }
    
    System.out.println("\n*** End of program. ***");
  }
  
  public static int readNumbersToArray(String filename, int[] numbers) {
    String number; 
    int pos = 0;
    try { 
      FileReader fr = new FileReader(filename);
      Scanner sc = new Scanner(fr);
      
        while (sc.hasNextLine() && pos < numbers.length) {
           String line = sc.nextLine();
           String[] parts = line.split(",");
            for(int i = 0; i < parts.length && pos < numbers.length;i++){
                try{
                    int x = Integer.parseInt(parts[i].trim());
                    numbers[pos] = x;
                    pos++;

                }catch(NumberFormatException e){

                }
            }
        }
        sc.close();

    }catch (FileNotFoundException fnf) {
         System.out.println(fnf);
         fnf.printStackTrace();
         pos = -1;
    }
    return pos;
    
  }
  
  public static void printNumbers(int[] numbers, int size) {
    System.out.print("[ ");
    for (int i = 0; i < size; i++)
      System.out.print(numbers[i] + " ");
    System.out.println("]");
  }
}