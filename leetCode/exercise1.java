import java.util.Arrays;

public class exercise1 {
    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {3,2,4};
        int[] nums3 = {3,3};

        System.out.println(Arrays.toString(twoSum(nums1, 9)));
        System.out.println(Arrays.toString(twoSum(nums2, 6)));
        System.out.println(Arrays.toString(twoSum(nums3, 6)));

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length;j++ ){
                if(nums[i] + nums[j] == target ){
                    result[0] = i;
                    result[1] = j;
                    break;
                   
                }
            }
        }return result;
    }
}
