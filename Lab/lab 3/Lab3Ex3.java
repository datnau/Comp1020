import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Lab3Ex3 {
  public static final int MAX_INTEGERS = 20;
  public static String FILE_NAME = "numbers3.txt";

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
      
      while (sc.hasNext() && pos < numbers.length) {
        try{
            number = sc.next();
            int x = Integer.parseInt(number);
            numbers[pos] = x;
            pos++;
           //fr.close();
          
        }catch(NumberFormatException e){
        }
      }sc.close();
    } catch (FileNotFoundException fnf) {
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