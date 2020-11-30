package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-11-30
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res1 = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(String.format("v1 -> %d, v2 -> %d", res1[0], res1[1]));

        int[] res2 = twoSum(new int[]{3,2,4}, 6);
        System.out.println(String.format("v1 -> %d, v2 -> %d", res2[0], res2[1]));

        int[] res3 = twoSum(new int[]{3,3}, 6);
        System.out.println(String.format("v1 -> %d, v2 -> %d", res3[0], res3[1]));

    }

}
