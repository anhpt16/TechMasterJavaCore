package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ThirdMaximumNumber {
    // https://leetcode.com/problems/third-maximum-number/submissions/1256824743/
    public static int thirdMax(int[] nums){
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int count = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] != nums[i + 1]){
                count++;
            }
            if (count == 3){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] case1 = {3,2,1};
        int[] case2 = {1,2};
        int[] case3 = {2,2,3,1};
        int[] case4 = {5,2,2};
        System.out.println(thirdMax(case4));
        System.out.println(thirdMax(case1));
        System.out.println(thirdMax(case2));
        System.out.println(thirdMax(case3));
    }
}
