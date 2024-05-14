package easy;

public class SingleNumber {
    public static int singleNumber(int[] nums){
        int result = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == 0){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    nums[i] = 0;
                    nums[j] = 0;
                    break;
                }
                if (j == nums.length - 1){
                    result = nums[i];
                    return result;
                }
            }
            if (i == nums.length - 1){
                return nums[i];
            }
        }
        return result;
    }

    public static int singleNumberV2(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    count++;
                }
            }
            if (count < 2){
                return nums[i];
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] case1 = {2,2,1};
        int[] case2 = {4,1,2,1,2};
        int[] case3 = {1};
        System.out.println(singleNumber(case1));
        System.out.println(singleNumber(case2));
        System.out.println(singleNumber(case3));
    }
}
