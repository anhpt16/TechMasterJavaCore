package easy;

import java.util.Arrays;

public class RunningSum {
    public static int[] runningSum(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += sum;
            sum = nums[i];
        }
        return nums;
    }

    public static int[] runningSumV2(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] case1 = {1,2,3,4};
        int[] case2 = {1,1,1,1,1};
        int[] case3 = {3,1,2,10,1};
//        System.out.println(Arrays.toString(runningSum(case1)));
//        System.out.println(Arrays.toString(runningSum(case2)));
//        System.out.println(Arrays.toString(runningSum(case3)));
        System.out.println(Arrays.toString(runningSumV2(case1)));
        System.out.println(Arrays.toString(runningSumV2(case2)));
        System.out.println(Arrays.toString(runningSumV2(case3)));
    }
}
