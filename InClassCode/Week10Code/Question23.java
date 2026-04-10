public class Question23 {
    public static void main(String[] args) {
        int[] num = {4,6,5,5};

        countCombinations(num);
        

    }

    public static void countCombinations(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if(sum == 10){
                    count++;
                }

                
            }
        }
        System.out.println(count);
    }
}
