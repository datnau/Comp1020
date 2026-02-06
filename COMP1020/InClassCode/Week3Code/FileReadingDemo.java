import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReadingDemo {

    public static void main(String[] args) {
        String filename = "file.txt";

        System.out.println("--- Method 1: FileReader (Char by Char) ---");
        readWithFileReader(filename);
        System.out.println("\n");

        System.out.println("--- Method 2: BufferedReader (Line by Line) ---");
        readWithBufferedReader(filename);
        System.out.println("\n");

        System.out.println("--- Method 3: Scanner (Token/Line) ---");
        readWithScanner(filename);
        System.out.println("\n");
    }

    /**
     * Method 1: FileReader
     * READS: One character at a time.
     * PROS: Simple for small data or character-level processing.
     * CONS: Very inefficient (many disk accesses) and tedious to reconstruct strings.
     */
    public static void readWithFileReader(String filename) {
        // FileReader uses "Checked Exceptions", so we must try-catch IOException
        try {
            FileReader fr = new FileReader(filename);
            int i;
            // .read() returns -1 when end of file is reached
            i = fr.read();
            while (i != -1) {
                // Cast the integer value to a char to print it
                System.out.print((char) i);
                i = fr.read();
            }
            // Always close the stream!
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method 2: BufferedReader
     * READS: Whole lines at a time.
     * PROS: Efficient (buffers input), easy to read text line-by-line.
     * CONS: Slightly more code to set up (wrapping the FileReader).
     */
    public static void readWithBufferedReader(String filename) {
        try {
            // BufferedReader wraps around FileReader to provide buffering
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line = br.readLine();
            // .readLine() returns null when end of file is reached
            while (line != null) {
                System.out.println(line);

                line = br.readLine();
            }

            br.close(); // Closing the wrapper also closes the inner FileReader
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method 3: Scanner
     * READS: Tokens (words, numbers) or Lines.
     * PROS: easiest to parse data (nextInt, nextDouble), very high-level.
     * CONS: Slower than BufferedReader for massive files. Throws unchecked exceptions during parsing.
     */
    public static void readWithScanner(String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            // standard while-loop pattern for Scanner
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            // Scanner specifically throws FileNotFoundException (subclass of IOException)
            // It suppresses general IOExceptions during reading and returns null/false instead.
            System.out.println("File not found: " + filename);
        }
    }
}
