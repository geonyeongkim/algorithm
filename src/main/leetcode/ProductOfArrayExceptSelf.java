package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-02-15
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int rightVal = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= rightVal;
            rightVal *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] ans = productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3 ,4});
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();

        ans = productOfArrayExceptSelf.productExceptSelf(new int[]{0, 0});
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();

        ans = productOfArrayExceptSelf.productExceptSelf(new int[]{1, 0});
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();

        ans = productOfArrayExceptSelf.productExceptSelf(new int[]{1, 1});
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();

        ans = productOfArrayExceptSelf.productExceptSelf(new int[]{1, -1});
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();

        ans = productOfArrayExceptSelf.productExceptSelf(new int[]{-1, -1});
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();

        ans = productOfArrayExceptSelf.productExceptSelf(new int[]{9, 0 , -2});
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }
}
