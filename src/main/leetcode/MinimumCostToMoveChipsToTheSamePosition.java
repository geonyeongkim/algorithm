package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-07
 */
public class MinimumCostToMoveChipsToTheSamePosition {

    public static int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        for(int i : position) {
            if(i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        int res1 = minCostToMoveChips(new int[]{1,2,3});
        System.out.println("res1 -> " + res1);
        int res2 = minCostToMoveChips(new int[]{2,2,2,3,3});
        System.out.println("res2 -> " + res2);
    }
}
