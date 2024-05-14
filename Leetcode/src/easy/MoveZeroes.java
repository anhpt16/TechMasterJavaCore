package easy;

import java.util.Arrays;

public class MoveZeroes {
    // https://leetcode.com/problems/move-zeroes/submissions/1256206636/
    public static void moveZeroes(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                count++;
            }
            else {
                int temp = nums[i - count];
                nums[i - count] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] case1 = {0,1,0,3,12};
        int[] case2 = {0};
        moveZeroes(case1);
        moveZeroes(case2);
        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));
    }
}
