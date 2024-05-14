package medium;

import java.util.Arrays;

public class SortColors {
    // https://leetcode.com/problems/sort-colors/submissions/1256781107/
    public static void sortColors(int[] nums){
        int boundTwo = nums.length - 1;
        int boundZero = 0;
        int temp;
        for (int i = 0; i <= boundTwo; i++) {
            while ((nums[i] == 0 && i > boundZero) || (nums[i] == 2 && i < boundTwo)){
                if (nums[i] == 0){
                    temp = nums[i];
                    nums[i] = nums[boundZero];
                    nums[boundZero] = temp;
                    boundZero++;
                }
                else if (nums[i] == 2){
                    temp = nums[i];
                    nums[i] = nums[boundTwo];
                    nums[boundTwo] = temp;
                    boundTwo--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] case1 = {2,0,2,1,1,0};
        int[] case2 = {2,0,1};
        sortColors(case1);
        sortColors(case2);
        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));
    }
}
