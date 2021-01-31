package main.leetcode;

public class UniquePaths {

    int[] dirY = new int[]{-1, 0};
    int[] dirX = new int[]{0, -1};

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        memo[0][0] = 1;
        dp(memo, m, n);
        return memo[m-1][n-1];
    }

    private int dp(int[][] memo, int y, int x) {
        if (memo[y][x] != 0) return memo[y][x];

        int sum = 0;
        for (int i = 0; i < 2; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];
            if (nextY >= 0 && nextX >= 0) {
                sum += dp(memo, nextY, nextX);
            }
        }
        memo[y][x] = sum;

        return memo[y][x];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int ans = uniquePaths.uniquePaths(3, 7);
        System.out.println(ans);

        ans = uniquePaths.uniquePaths(3, 2);
        System.out.println(ans);

        ans = uniquePaths.uniquePaths(7, 3);
        System.out.println(ans);

        ans = uniquePaths.uniquePaths(3, 3);
        System.out.println(ans);

    }
}
