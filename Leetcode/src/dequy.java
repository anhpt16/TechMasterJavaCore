public class dequy {
    public static int sum(int[] nums, int i){
        if (i < 0){
            return 0;
        }
        return nums[i] + sum(nums, i - 1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(sum(a, a.length - 1));
    }
}
