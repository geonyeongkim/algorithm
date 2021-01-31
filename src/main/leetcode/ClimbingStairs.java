package main.leetcode;

public class ClimbingStairs {

    public int climbStairs(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;

        return dp(memo, n);
    }

    private int dp(int[] memo, int target) {
        if (memo[target] != 0) return memo[target];
        memo[target] = dp(memo, target - 1) + dp(memo, target - 2);
        return memo[target];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int ans = climbingStairs.climbStairs(2);
        System.out.println(ans);
        ans = climbingStairs.climbStairs(3);
        System.out.println(ans);
    }
}
