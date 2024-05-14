package easy;

public class MajorityElement {
    public static int majorityElement(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    count++;
                }
            }
            if (count > (nums.length / 2)){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] case1 = {3,2,3};
        int[] case2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(case1));
        System.out.println(majorityElement(case2));
    }
}
