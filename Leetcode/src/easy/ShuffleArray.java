package easy;

import java.util.Arrays;

public class ShuffleArray {
    public static int[] shuffle(int[] nums, int n){
        int[] result = new int[nums.length];
        int count = 0;
        for (int i = 0; i < n * 2; i += 2) {
            result[i] = nums[count];
            result[i + 1] = nums[n + count];
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] case1 = {2,5,1,3,4,7};
        int[] case2 = {1,2,3,4,4,3,2,1};
        int[] case3 = {1,1,2,2};
        System.out.println(Arrays.toString(shuffle(case1, 3)));
        System.out.println(Arrays.toString(shuffle(case2, 4)));
        System.out.println(Arrays.toString(shuffle(case3, 2)));
    }
}
