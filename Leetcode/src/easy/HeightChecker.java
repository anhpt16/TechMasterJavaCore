package easy;

import java.util.Arrays;

public class HeightChecker {
    // https://leetcode.com/problems/height-checker/submissions/1256833685/
    public static int heightChecker(int[] heights){
        int[] sortedArr = new int[heights.length];
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            sortedArr[i] = heights[i];
        }
        Arrays.sort(sortedArr);
        for (int i = 0; i < heights.length; i++) {
            if (sortedArr[i] != heights[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
