package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-08
 */
public class NumberOfGoodPairs {

    public static int numIdenticalPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res1 = numIdenticalPairs(new int[]{1,2,3,1,1,3});
        int res2 = numIdenticalPairs(new int[]{1,1,1,1});
        int res3 = numIdenticalPairs(new int[]{1,2,3});
    }
}
