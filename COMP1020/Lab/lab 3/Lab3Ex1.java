import java.io.File;
import java.util.Scanner;

public class Lab3Ex1 {
  public static final int MAX_INTEGERS = 20;
  public static String FILE_NAME = "numbers1.txt";

  public static void main(String[] args) {
    int[] numbers = new int[MAX_INTEGERS];
    int numbersSize = 0;
    
    numbersSize = readNumbersToArray(FILE_NAME, numbers);
    
    if (numbersSize < 0) {
      System.out.println("No array was read.");
    } else {
      System.out.println("The following array was read:");
      printNumbers(numbers, numbersSize);
    }
    
    System.out.println("\n*** End of program. ***");
  }
  
  public static int readNumbersToArray(String filename, int[] numbers) {
    File in = new File(filename);
    int number, pos = 0;
    try(Scanner myReader = new Scanner(in)) {
         while (myReader.hasNextInt()) {
         number = myReader.nextInt();
         numbers[pos] = number;
         pos++;
        }
    } catch (Exception fnf) {
      System.out.println("File not found");
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
