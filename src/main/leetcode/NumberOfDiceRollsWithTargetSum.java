package main.leetcode;

public class NumberOfDiceRollsWithTargetSum {

    private static final int MOD = 1000000007;

    /*
    * DP 문제로 2차원 배열을 사용하여 풀이해야함.
    * 2차원 배열은 [dice 갯수][face * dice] -> dice 갯수마다 가능한 최대 값을 2차원 배열로 선언한다는 것임
    *
    * 전 dice 갯수에서 현재 face 값을 더해도 최대가 안넘으면 dp에 값을 채워줌
    * => 현재 dp 값에 face값을 더한 위치에 이전 다이스로 가능한 갯수를 더함.
    * */
    public int numRollsToTarget(int d, int f, int target) {
        if (d * f < target)
            return 0;

        if (d == 1) {
            return 1;
        }

        int[][] dp = new int[d + 1][d * f + 1];


        for (int i = 1; i <= f; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= d; i++) {
            for (int j = 1; j < d * f + 1; j++) {
                for (int q = 1; q <= f; q++) {
                    if (dp[i - 1][j] != 0 && j + q < d * f + 1) {
                        dp[i][j + q] = (dp[i][j + q] + dp[i - 1][j]) % MOD;
                    }
                }
            }
        }
        return dp[d][target] % MOD;
    }

    public static void main(String[] args) {

        NumberOfDiceRollsWithTargetSum numberOfDiceRollsWithTargetSum = new NumberOfDiceRollsWithTargetSum();
        int ans = numberOfDiceRollsWithTargetSum.numRollsToTarget(1, 6, 3);
        System.out.println(ans);

        ans = numberOfDiceRollsWithTargetSum.numRollsToTarget(2, 6, 7);
        System.out.println(ans);

        ans = numberOfDiceRollsWithTargetSum.numRollsToTarget(2, 5, 10);
        System.out.println(ans);

        ans = numberOfDiceRollsWithTargetSum.numRollsToTarget(1, 2, 3);
        System.out.println(ans);

        ans = numberOfDiceRollsWithTargetSum.numRollsToTarget(30, 30, 50);
        System.out.println(ans);
    }
}
