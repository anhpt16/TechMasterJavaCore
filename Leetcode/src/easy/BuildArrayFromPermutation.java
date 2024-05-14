package easy;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

public class BuildArrayFromPermutation {
    public static int[] buildArray(int[] nums){
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[nums[i]];
        }
        return nums;
    }

    public static void main(String[] args) {
//        int[] case1 = {0,2,1,5,3,4};
//        int[] case2 = {5,0,1,2,3,4};
//        System.out.println(Arrays.toString(buildArray(case1)));
//        System.out.println(Arrays.toString(buildArray(case2)));
        String str1 = "Hello";
        String str2 = new String("Hello");
//        str2.intern();
        System.out.println(str1 == str2.intern());
    }
}
