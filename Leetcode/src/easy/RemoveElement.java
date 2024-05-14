package easy;

import java.util.Arrays;

public class RemoveElement {
    // https://leetcode.com/problems/remove-element/submissions/1256039261/
    public static int removeElement(int[] nums, int val){
        int reIndexCount = nums.length - 1;
        int count = 0;
        for (int i = 0; i <= reIndexCount; i++) {
            if (nums[i] == val){
                count++;
                while (i < reIndexCount){
                    if (nums[reIndexCount] != val){
                        nums[i] = nums[reIndexCount];
                        nums[reIndexCount] = val;
                        reIndexCount--;
                        break;
                    }
                    else {
                        count++;
                        reIndexCount--;
                    }
                }
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] case1 = {3,2,2,3};

        System.out.println(removeElement(case1, 3));
        System.out.println(Arrays.toString(case1));
    }
}
