import java.io.*;

public class InClassBufferedReader {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("randomFile.txt");
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            readFile(br, bw);

            br.close();
            bw.close(); // flush luôn
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(BufferedReader reader, BufferedWriter output) throws IOException {
        String line = reader.readLine();
        String str = "";

        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch != 'a') {
                    output.write(ch);
                } 
            }
             
            line = reader.readLine();  
        }
    }
}
