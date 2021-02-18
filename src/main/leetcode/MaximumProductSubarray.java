package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-02-18
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int curMax = 1, curMin = 1;

        int answer = nums[0];
        for (int num : nums) {
            int tmp = curMax * num;

            curMax = Math.max(num, Math.max(tmp, num * curMin));
            curMin = Math.min(num, Math.min(tmp, num * curMin));

            answer = Math.max(answer, curMax);
        }

        return answer;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int ans = maximumProductSubarray.maxProduct(new int[]{2 ,3, -2, 4});
        System.out.println(ans);

        ans = maximumProductSubarray.maxProduct(new int[]{-2, 0, -1});
        System.out.println(ans);

        ans = maximumProductSubarray.maxProduct(new int[]{-2});
        System.out.println(ans);

        ans = maximumProductSubarray.maxProduct(new int[]{0, 2});
        System.out.println(ans);
    }
}
