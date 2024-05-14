package easy;

import java.util.Arrays;

public class DuplicateZeros {
    // https://leetcode.com/problems/duplicate-zeros/submissions/1256175998/
    public static void duplicateZeros(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && (i + 1) < arr.length){
                int count = i + 2;
                int temp = 1;
                while ((arr.length - temp) >= count){
                    arr[arr.length - temp] = arr[arr.length - temp - 1];
                    temp++;
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] case1 = {1,0,2,3,0,4,5,0};
        int[] case2 = {1,2,3};
        duplicateZeros(case1);
        duplicateZeros(case2);
        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));
    }
}
