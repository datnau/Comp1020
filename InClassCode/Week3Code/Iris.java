import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Iris {

    private static final String FILE_NAME = "iris.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final int SEPAL_LENGTH_INDEX = 0;
    private static final int SEPAL_WIDTH_INDEX = 1;
    private static final int PETAL_LENGTH_INDEX = 2;
    private static final int PETAL_WIDTH_INDEX = 3;
    private static final int VARIETY_INDEX = 4;
    private static final int EXPECTED_PARTS = 5;

    public static void main(String[] args) {
        try {
            int size = countLines(FILE_NAME);
            double[] sepalLength = new double[size];
            double[] sepalWidth = new double[size];
            double[] petalLength = new double[size];
            double[] petalWidth = new double[size];
            String [] variety = new String[size];

            System.out.println("Reading " + size + " lines of data...");
            System.out.println("--------------------------------------------------");

            // 1. Using Scanner (Scanner for file + Scanner for line)
            System.out.println("Parsing with Scanner...");
            parseDataWithScanner(FILE_NAME, sepalLength, sepalWidth, petalLength, petalWidth, variety);
            printFirstAndLast(size, sepalLength, variety);
            System.out.println("--------------------------------------------------");

            // 2. Using BufferedReader + String.split
            System.out.println("Parsing with BufferedReader + split...");
            parseDataWithBufferedReaderSplit(FILE_NAME, sepalLength, sepalWidth, petalLength, petalWidth, variety);
            printFirstAndLast(size, sepalLength, variety);
            System.out.println("--------------------------------------------------");

            // 3. Using BufferedReader + Manual Parsing
            System.out.println("Parsing with BufferedReader + Manual Substring...");
            parseDataWithBufferedReaderManual(FILE_NAME, sepalLength, sepalWidth, petalLength, petalWidth, variety);
            printFirstAndLast(size, sepalLength, variety);
            System.out.println("--------------------------------------------------");

            System.out.println("End of processing.");

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    /*
     * Prints the first and last entry of the parsed data to verify correctness.
     *
     * @param size The number of entries.
     * @param sepalLength The array of sepal lengths.
     * @param variety The array of varieties.
     */
    private static void printFirstAndLast(int size, double[] sepalLength, String[] variety) {
        if (size > 0) {
            System.out.println("First entry: " + variety[0] + ", " + sepalLength[0]);
            System.out.println("Last entry: " + variety[size - 1] + ", " + sepalLength[size - 1]);
        }
    }

    /*
     * Counts the number of lines in the file, excluding the header.
     *
     * @param fileName The path to the file.
     * @return The number of data lines.
     * @throws FileNotFoundException If the file is not found.
     */
    public static int countLines(String fileName) throws FileNotFoundException {
        FileReader fReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fReader);

        if (scanner.hasNextLine()) {
            scanner.nextLine(); // skip header line
        }

        int counter = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.trim().isEmpty()) {
                counter += 1;
            }
        }
        scanner.close();

        return counter;
    }

    /*
     * Helper method to populate the data arrays from a string array of parts.
     *
     * @param index The current row index.
     * @param parts The string parts parsed from a line.
     * @param sepalLength Array to store sepal lengths.
     * @param sepalWidth Array to store sepal widths.
     * @param petalLength Array to store petal lengths.
     * @param petalWidth Array to store petal widths.
     * @param variety Array to store varieties.
     */
    private static void addToArrays(
        int index,
        String[] parts,
        double[] sepalLength,
        double[] sepalWidth,
        double[] petalLength,
        double[] petalWidth,
        String [] variety
    ) {
        // Convert first four to double
        sepalLength[index] = Double.parseDouble(parts[SEPAL_LENGTH_INDEX]);
        sepalWidth[index] = Double.parseDouble(parts[SEPAL_WIDTH_INDEX]);
        petalLength[index] = Double.parseDouble(parts[PETAL_LENGTH_INDEX]);
        petalWidth[index] = Double.parseDouble(parts[PETAL_WIDTH_INDEX]);

        // Handle the variety string - removing quotes if present
        String val = parts[VARIETY_INDEX].trim();

        variety[index] = val;
    }

    /*
     * Parses the data file using a Scanner for reading lines and another Scanner for parsing lines.
     *
     * @param fileName The path to the file.
     * @param sepalLength Array to store sepal lengths.
     * @param sepalWidth Array to store sepal widths.
     * @param petalLength Array to store petal lengths.
     * @param petalWidth Array to store petal widths.
     * @param variety Array to store varieties.
     * @throws FileNotFoundException If the file is not found.
     */
    public static void parseDataWithScanner(
        String fileName,
        double[] sepalLength,
        double[] sepalWidth,
        double[] petalLength,
        double[] petalWidth,
        String [] variety
    ) throws FileNotFoundException {
        FileReader fReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fReader);

        if (scanner.hasNextLine()) {
            scanner.nextLine(); // skip header line
        }

        int counter = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (!line.trim().isEmpty()) {
                // to allow the default whitespace delimiter to work.
                // This assumes the data itself does not contain spaces.
                Scanner lineScanner = new Scanner(line.replace(COMMA_DELIMITER, " "));

                String[] parts = new String[EXPECTED_PARTS];
                int partIndex = 0;

                while (lineScanner.hasNext() && partIndex < EXPECTED_PARTS) {
                    parts[partIndex] = lineScanner.next();
                    partIndex++;
                }
                lineScanner.close();

                // Use the static helper to fill arrays
                addToArrays(counter, parts, sepalLength, sepalWidth, petalLength, petalWidth, variety);

                counter += 1;
            }
        }
        scanner.close();
    }

    /*
     * Parses the data file using BufferedReader and String.split().
     *
     * @param fileName The path to the file.
     * @param sepalLength Array to store sepal lengths.
     * @param sepalWidth Array to store sepal widths.
     * @param petalLength Array to store petal lengths.
     * @param petalWidth Array to store petal widths.
     * @param variety Array to store varieties.
     * @throws IOException If an I/O error occurs.
     */
    public static void parseDataWithBufferedReaderSplit(
        String fileName,
        double[] sepalLength,
        double[] sepalWidth,
        double[] petalLength,
        double[] petalWidth,
        String [] variety
    ) throws IOException {
        FileReader fReader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fReader);

        // Skip header
        br.readLine();

        String line = br.readLine();
        int counter = 0;

        while (line != null) {
            if (!line.trim().isEmpty()) {
                String[] parts = line.split(COMMA_DELIMITER);

                addToArrays(counter, parts, sepalLength, sepalWidth, petalLength, petalWidth, variety);

                counter++;
            }
            line = br.readLine();
        }
        br.close();
    }

    /*
     * Parses the data file using BufferedReader and manual substring logic.
     *
     * @param fileName The path to the file.
     * @param sepalLength Array to store sepal lengths.
     * @param sepalWidth Array to store sepal widths.
     * @param petalLength Array to store petal lengths.
     * @param petalWidth Array to store petal widths.
     * @param variety Array to store varieties.
     * @throws IOException If an I/O error occurs.
     */
    public static void parseDataWithBufferedReaderManual(
        String fileName,
        double[] sepalLength,
        double[] sepalWidth,
        double[] petalLength,
        double[] petalWidth,
        String [] variety
    ) throws IOException {
        FileReader fReader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fReader);

        // Skip header
        br.readLine();

        String line = br.readLine();
        int counter = 0;

        while (line != null) {
            if (!line.trim().isEmpty()) {
                String[] parts = manualSplit(line);

                addToArrays(counter, parts, sepalLength, sepalWidth, petalLength, petalWidth, variety);

                counter++;
            }
            line = br.readLine();
        }
        br.close();
    }

    /*
     * Manually splits a string by comma delimiter.
     *
     * @param line The line to split.
     * @return An array of strings containing the split parts.
     */
    private static String[] manualSplit(String line) {
        String[] parts = new String[EXPECTED_PARTS];
        int partIndex = 0;
        int start = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                parts[partIndex] = line.substring(start, i);
                partIndex++;
                start = i + 1;
            }
        }
        // Get the last part
        if (start < line.length()) {
            parts[partIndex] = line.substring(start);
        }

        return parts;
    }
}
