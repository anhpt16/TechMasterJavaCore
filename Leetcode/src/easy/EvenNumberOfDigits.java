package easy;

public class EvenNumberOfDigits {
    /* Đưa ra các số có trong mảng mà số chữ số của nó là chẵn */
    /* https://leetcode.com/problems/find-numbers-with-even-number-of-digits/submissions/1255782774/ */
    public static int findNumbers(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isEven(nums[i]))
                count++;
        }
        return count;
    }

    public static boolean isEven(int num){
        int count = 0;
        while(num > 0){
            num /= 10;
            count++;
        }
        if (count % 2 == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] case1 = {12,345,2,6,7896};
        int[] case2 = {555,901,482,1771};
        System.out.println(findNumbers(case1));
        System.out.println(findNumbers(case2));
    }
}
