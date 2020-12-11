package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-11
 */
public class FindNumberswithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int res = 0;

        for (int num : nums) {
            int cnt = 0;
            while(num > 0) {
                num /= 10;
                cnt++;
            }
            if (cnt % 2 == 0) res++;
        }

        return res;
    }

    public static void main(String[] args) {
        FindNumberswithEvenNumberOfDigits findNumberswithEvenNumberOfDigits = new FindNumberswithEvenNumberOfDigits();

        int res1 = findNumberswithEvenNumberOfDigits.findNumbers(new int[]{12,345,2,6,7896});
        System.out.println("res1 => " + res1);

        int res2 = findNumberswithEvenNumberOfDigits.findNumbers(new int[]{555,901,482,1771});
        System.out.println("res2 => " + res2);
    }
}
