package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-02-02
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int sum;
        for(int i = 0; i < nums.length; i++) {
            sum = nums[i];
            answer = Math.max(answer, sum);
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                answer = Math.max(answer, sum);
            }


        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int ans = maximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println("ans = " + ans);

        ans = maximumSubarray.maxSubArray(new int[]{1});
        System.out.println("ans = " + ans);

        ans = maximumSubarray.maxSubArray(new int[]{0});
        System.out.println("ans = " + ans);

        ans = maximumSubarray.maxSubArray(new int[]{-1});
        System.out.println("ans = " + ans);

        ans = maximumSubarray.maxSubArray(new int[]{-10000});
        System.out.println("ans = " + ans);
    }
}
