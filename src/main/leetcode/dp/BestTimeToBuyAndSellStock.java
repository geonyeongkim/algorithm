package main.leetcode.dp;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if(min > prices[i]) {
                min = prices[i];
            } else if(prices[i] - min > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int ans = bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(ans);

        ans = bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println(ans);
    }
}
