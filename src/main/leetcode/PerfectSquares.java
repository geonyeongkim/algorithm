package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1; ; i++) {
            int tmp = i*i;
            if(tmp > n) break;
            list.add(tmp);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for (int val : list) {
            for(int i = val; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - val] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        int ans = perfectSquares.numSquares(12);
        System.out.println(ans);
        ans = perfectSquares.numSquares(13);
        System.out.println(ans);
    }
}
