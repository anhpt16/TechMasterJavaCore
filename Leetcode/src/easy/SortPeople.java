package easy;

import java.util.Arrays;
import java.util.List;

public class SortPeople {
    // https://leetcode.com/problems/sort-the-people/submissions/1256860361/
    public static String[] sortPeople(String[] names, int[] heights){
        int[] sortedHeights = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            sortedHeights[i] = heights[i];
        }
        Arrays.sort(sortedHeights);
        for (int i = 0; i < (heights.length) / 2; i++) {
            int temp = sortedHeights[i];
            sortedHeights[i] = sortedHeights[heights.length - 1 - i];
            sortedHeights[heights.length - 1 - i] = temp;
        }
        for (int i = 0; i < names.length; i++) {
            if (sortedHeights[i] != heights[i]){
                for (int j = i + 1; j < names.length; j++) {
                    if (sortedHeights[i] == heights[j]){
                        String temp = names[i];
                        names[i] = names[j];
                        names[j] = temp;
                        int tamp = heights[i];
                        heights[i] = heights[j];
                        heights[j] = tamp;
                        break;
                    }
                }
            }
        }
        return names;
    }

    public static void main(String[] args) {
        String[] name1 = {"Mary","John","Emma"};
        int[] height1 = {180,165,170};
        String[] name2 = {"Alice","Bob","Bob"};
        int[] height2 = {155,185,150};
        System.out.println(Arrays.toString(sortPeople(name1, height1)));
        System.out.println(Arrays.toString(sortPeople(name2, height2)));
    }
}
