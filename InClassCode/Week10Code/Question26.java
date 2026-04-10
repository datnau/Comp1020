public class Question26 {
    public static void main(String[] args) {
        
    }
    public static void testWorstCase(int length) {
    int[] arr = new int[length];

    for (int i = 0; i < length; i++) {
        arr[i] = length - i;
    }

    System.out.println("Simulated Quick Sort Worst Case array allocated");
    }
}
