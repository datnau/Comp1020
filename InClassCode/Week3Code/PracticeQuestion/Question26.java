import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Question26 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("numbers.txt");
            Scanner sc = new Scanner(fileReader);
            int maxValue = 0;
            if(!sc.hasNextInt()){
                System.out.println("No data");
                return;
            }
            while(sc.hasNextInt()){
                int x = sc.nextInt();
                if(x >= maxValue){
                    maxValue = sc.nextInt();
                }
            }
            System.out.println(maxValue);
        } catch (FileNotFoundException e) {
        }
    }

}
