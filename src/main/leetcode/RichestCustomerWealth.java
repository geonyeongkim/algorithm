package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-03
 */
public class RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        int res = 0;
        for(int i = 0 ; i< accounts.length; i++) {
            int sum = 0;
            for(int j = 0 ; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        System.out.println(maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
        System.out.println(maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }

}
