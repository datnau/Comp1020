
public class Question19 {

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 10};
        boolean increasing = true;
        for (int i = 1; i < arr.length && increasing; i++) {
            if (arr[i] < arr[i - 1]) {
                increasing = false;
            }

        }

        System.out.println(increasing);
    }
}
