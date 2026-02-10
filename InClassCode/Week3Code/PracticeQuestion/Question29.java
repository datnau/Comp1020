
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
public class Question29 {
    public static void main(String[] args) {
        try{
             FileReader fileReader = new FileReader("source.txt");
             PrintWriter printWriter = new PrintWriter("dest.txt");
             Scanner sc = new Scanner(fileReader);
             while(sc.hasNextLine()){
                String str = sc.nextLine();
                printWriter.println(str);

             }
             printWriter.close();
             sc.close();
            
        }catch(FileNotFoundException e){

        }
       


    }
}
