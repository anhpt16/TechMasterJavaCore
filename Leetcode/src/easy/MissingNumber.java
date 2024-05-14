package easy;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int sumResult = sum(nums.length);
        for (int i = 0; i < nums.length; i++) {
            sumResult = sumResult - nums[i];
        }
        return sumResult;
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sum(n - 1);
        }
    }

    public static void main(String[] args) {
        int[] case1 = {3, 0 ,1};
        int[] case2 = {0, 1};
        int[] case3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(case1));
        System.out.println(missingNumber(case2));
        System.out.println(missingNumber(case3));
    }
}
