import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Question21 {
    public static void main(String[] args) {
        int countLine = 0;
        try {
             FileReader fr = new FileReader("input.txt");
             Scanner sc = new Scanner(fr);
            while(sc.hasNextLine()){
                sc.nextLine();
                countLine++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File can not be found!!!!");
        }
        System.out.println(countLine);
       
    }
}
