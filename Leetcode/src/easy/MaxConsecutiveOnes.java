package easy;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums){
        int max = 0;
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                currentMax++;
                if (currentMax > max){
                    max = currentMax;
                }
            }
            else
                currentMax = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] case3 = {0};
        int[] case4 = {1};
        int[] case1 = {1,1,0,1,1,1};
        int[] case2 = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(case1));
        System.out.println(findMaxConsecutiveOnes(case2));
        System.out.println(findMaxConsecutiveOnes(case3));
        System.out.println(findMaxConsecutiveOnes(case4));
    }
}
