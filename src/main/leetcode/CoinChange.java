package main.leetcode;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);

        // dp 기준은 amount, 0은 아무 동전도 필요 없으니 0 세팅
        dp[0] = 0;

        for (int coin : coins) {
            for(int i = coin; i <= amount; i++) {
                // 현재 구할려는 amount에 coin 만큼 뺐으니 현재 코인의 amount만 더하면 되니 +1 해줌.
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if(dp[amount] >= Integer.MAX_VALUE-1) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {

        CoinChange coinChange = new CoinChange();
        int ans = coinChange.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(ans);

        ans = coinChange.coinChange(new int[]{2}, 3);
        System.out.println(ans);

        ans = coinChange.coinChange(new int[]{1}, 0);
        System.out.println(ans);

        ans = coinChange.coinChange(new int[]{1}, 1);
        System.out.println(ans);

        ans = coinChange.coinChange(new int[]{1}, 2);
        System.out.println(ans);

        ans = coinChange.coinChange(new int[]{1,2147483647}, 2);
        System.out.println(ans);
    }
}
