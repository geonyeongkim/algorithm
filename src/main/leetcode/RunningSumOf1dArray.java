package main.leetcode;

public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        RunningSumOf1dArray runningSumOf1dArray = new RunningSumOf1dArray();
        int[] ans = runningSumOf1dArray.runningSum(new int[]{1,2,3,4});
        print(ans);

        ans = runningSumOf1dArray.runningSum(new int[]{1,1,1,1,1});
        print(ans);

        ans = runningSumOf1dArray.runningSum(new int[]{3,1,2,10,1});
        print(ans);
    }

    private static void print(int[] ans) {
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }
}
