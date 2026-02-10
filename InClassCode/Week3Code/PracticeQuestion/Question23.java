
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class Question23 {
    public static void main(String[] args) {
        String namePassed = processStudentData("studentData.txt");
        System.out.println(namePassed);
    }

    public static String processStudentData(String fileName){
        try {
        FileReader fr = new FileReader(fileName); 
        Scanner sc = new Scanner(fr);
        int PASS_CUTOFF = 50;
        String namePassed = " ";
        while(sc.hasNextLine()){
            String[] parts = sc.nextLine().split(",");
            int grade = Integer.parseInt(parts[1].trim());
            if(grade > PASS_CUTOFF){
                namePassed +=  parts[0].trim() + "\n";
            }
        }
        sc.close();
        return  namePassed;
        } catch (FileNotFoundException e) {
            return "File can not be found!!!";
        }
        
        
    }
}
