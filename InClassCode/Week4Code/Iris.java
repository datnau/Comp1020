import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

            ArrayList<Double> sepalLength = new ArrayList<>();
            ArrayList<Double> sepalWidth = new ArrayList<>();
            ArrayList<Double> petalLength = new ArrayList<>();
            ArrayList<Double> petalWidth = new ArrayList<>();
            ArrayList<String>  variety = new ArrayList<>();


            // 1. Using Scanner (Scanner for file + Scanner for line)
            System.out.println("Parsing with Scanner...");
            parseDataWithScanner(FILE_NAME, sepalLength, sepalWidth, petalLength, petalWidth, variety);
            printFirstAndLast(sepalLength.size(), sepalLength, variety);
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
    private static void printFirstAndLast(int size, ArrayList<Double> sepalLength, ArrayList<String> variety) {
        if (size > 0) {
            System.out.println("First entry: " + variety.get(0) + ", " + sepalLength.get(0));
            System.out.println("Last entry: " + variety.get(size-1) + ", " + sepalLength.get(size-1));
        }
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
        ArrayList<Double> sepalLength,
        ArrayList<Double> sepalWidth,
        ArrayList<Double> petalLength,
        ArrayList<Double> petalWidth,
        ArrayList<String>  variety
    ) {
        // Convert first four to double
        sepalLength.add(Double.parseDouble(parts[SEPAL_LENGTH_INDEX]));
        sepalWidth.add(Double.parseDouble(parts[SEPAL_WIDTH_INDEX]));
        petalLength.add(Double.parseDouble(parts[PETAL_LENGTH_INDEX]));
        petalWidth.add(Double.parseDouble(parts[PETAL_WIDTH_INDEX]));
        variety.add(parts[VARIETY_INDEX].trim());
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
        ArrayList<Double> sepalLength,
        ArrayList<Double> sepalWidth,
        ArrayList<Double> petalLength,
        ArrayList<Double> petalWidth,
        ArrayList<String>  variety
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

}
