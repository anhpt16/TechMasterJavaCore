package medium;

public class LongestMountain {
    // https://leetcode.com/problems/longest-mountain-in-array/submissions/1256669057/
    public static int longestMountain(int[] arr) {
        if (arr.length >= 3) {
            int longest = 0;
            int mountaintTop = 0;
            int mountainSE = 0;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i == 0){
                    mountainSE = 1;
                    count++;
                }
                else if (i == arr.length - 1){
                    if (mountainSE == 1 && mountaintTop == 1){
                        count++;
                        if (longest < count){
                            longest = count;
                        }
                    }
                }
                else if ((arr[i - 1] < arr[i] && arr[i] < arr[i + 1]) || arr[i - 1] > arr[i] && arr[i] > arr[i + 1]){
                    count++;
                }
                else if (arr[i - 1] < arr[i] && arr[i] >= arr[i + 1]){
                    if (arr[i] == arr[i + 1]){
                        count = 1;
                    }
                    else {
                        mountaintTop = 1;
                        count++;
                    }
                }
                else if (arr[i - 1] > arr[i] && arr[i] <= arr[i + 1]){
                    if (mountainSE == 1 && mountaintTop == 1){
                        count++;
                        if (longest < count){
                            longest = count;
                        }
                        mountaintTop = 0;
                        count = 1;
                    }
                    else {
                        count = 1;
                    }
                }
            }
            return longest;
        } else
            return 0;
    }

    public static void main(String[] args) {
        int[] case1 = {2, 1, 4, 7, 3, 2, 5};
        int[] case2 = {2, 2, 2};
        int[] case3 = {0,1,2,3,4,5,4,3,2,1,0};
        int[] case4 = {3,3,1,0,1,0,1,0,2,1};
        int[] case5 = {2,1,4,7,3,2,5};
        int[] case6 = {8,3,7,3,4,10,1,1,2,8};
        int[] case7 = {1,2,3,3,4,5,3};
        System.out.println(longestMountain(case6));
        System.out.println(longestMountain(case1));
        System.out.println(longestMountain(case5));
//        System.out.println(longestMountain(case2));
//        System.out.println(longestMountain(case3));
        System.out.println(longestMountain(case4));
        System.out.println(longestMountain(case7));
    }
}
