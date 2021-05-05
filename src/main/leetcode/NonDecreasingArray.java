package main.leetcode;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int lis = 0;
        int[] memo = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            lis = Math.max(lis, lis(i, nums, memo));
        }

        return lis >= nums.length - 1;
    }

    private int lis(int idx, int[] arr, int[] memo) {
        if(idx == arr.length -1) return 1;

        if(memo[idx] != 0) return memo[idx];

        memo[idx] = 1;

        for (int i = idx +1; i < arr.length; i++) {
            if(arr[idx] <= arr[i]) {
                memo[idx] = Math.max(memo[idx], lis(i, arr, memo) + 1);
            }
        }
        return memo[idx];
    }

    public static void main(String[] args) {
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean ans = nonDecreasingArray.checkPossibility(new int[]{4, 2, 3});
        System.out.println(ans);

        ans = nonDecreasingArray.checkPossibility(new int[]{4, 2, 1});
        System.out.println(ans);

        ans = nonDecreasingArray.checkPossibility(new int[]{1, 1, 1});
        System.out.println(ans);

        ans = nonDecreasingArray.checkPossibility(new int[]{3, 4, 2, 3});
        System.out.println(ans);

    }
}
