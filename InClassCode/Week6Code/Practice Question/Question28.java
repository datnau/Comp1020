public class Question28 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(weirdSum(arr, 0));
    }
    public static int weirdSum(int[] arr, int index){
        if(index >= arr.length){
            return 0;
        }
        if(arr[index]%2 == 0){
            return arr[index] * 2 + weirdSum(arr, index+1);
        }
        return arr[index] + weirdSum(arr, index+1);
    }
}
