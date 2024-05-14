package easy;

import java.util.Arrays;

public class MergeSortedArray {
    /* Sắp xếp từ bé đến lớn các số ở hai mảng đã sắp xếp vào mảng thứ nhất */
    // https://leetcode.com/problems/merge-sorted-array/submissions/1256014975/
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int j = 0;
        if (n > 0){
            for (int i = m; i < nums1.length; i++) {
                nums1[i] = nums2[j];
                j++;
            }
            Arrays.sort(nums1);
        }
    }

    public static void mergeV2(int[] nums1, int m, int[] nums2, int n){
//        int ind1 = nums1.length - m - 1;
//        int ind2 = nums2.length - 1;
//        int i = nums1.length - 1;
//        while(ind2 >= 0 && ind1 >= 0){
//            if (nums1[ind1] >= nums2[ind2]){
//                nums1[i] = nums1[ind1];
//                ind1--;
//                i--;
//            }
//            else {
//                nums1[i] = nums2[ind2];
//                ind2--;
//                i--;
//            }
//        }
//        if (ind2 >= 0 && ind1 < 0){
//            nums1[0] = nums2[ind2];
//        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        mergeV2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

//        int[] nums1 = {1};
//        int[] nums2 = {};
//        int m = 1, n = 0;
//        mergeV2(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));

//        int[] nums1 = {0};
//        int[] nums2 = {1};
//        int m = 0, n = 1;
//        mergeV2(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));

//        int[] nums1 = {2,0};
//        int[] nums2 = {1};
//        int m = 1, n = 1;
//        mergeV2(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));
    }
}
