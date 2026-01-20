
public class Lab1Ex2 {

    public static void main(String[] args) {
        System.out.println("drawColumns(0, 10752, 256, 8, true):");
        drawColumns(0, 10752, 256, 8, true);

        System.out.println("\ndrawColumns(0, 10752, 256, 8, false):");
        drawColumns(0, 10752, 256, 8, false);

        System.out.println("\ndrawColumns(-1001, -10217, -256, 8, false):");
        drawColumns(-1001, -10217, -256, 8, false);

        // more test cases will be used
        System.out.println("\n*** End of program. ***");
    }

    public static void drawColumns(int start, int end, int increment, int columns, boolean rightAlign) {
        int countInRow = 0;
        if (increment == 0 || columns <= 0) {
            return;
        }
        if (increment > 0) {
            if (rightAlign == true) {
                while (start <= end) {
                    System.out.printf("%5d ", start);
                    start += increment;
                    countInRow++;
                    if (countInRow == columns) {
                        System.out.println();
                        countInRow = 0;
                    }
                }
            } else {
                while (start <= end) {
                    System.out.printf("%-5d ", start);
                    start += increment;
                    countInRow++;
                    if (countInRow == columns) {
                        System.out.println();
                        countInRow = 0;
                    }
                }
            }
        }
        if (increment < 0) {
            if (rightAlign == true) {
                while (start >= end) {
                    System.out.printf("%5d", start);
                    start += increment;
                    countInRow++;
                    if (countInRow == columns) {
                        System.out.println();
                        countInRow = 0;
                    }
                }
            } else {
                while (start >= end) {
                    System.out.printf("%-5d", start);
                    start += increment;
                    countInRow++;
                    if (countInRow == columns) {
                        System.out.println();
                        countInRow = 0;
                    }
                }
            }
        }
        if (countInRow != 0) {
            System.out.println();
        }
    }
}
