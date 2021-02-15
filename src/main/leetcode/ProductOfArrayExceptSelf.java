package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-02-15
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int realTotal = 1;
        int zeroFlag = 0, oneFlag = 0;

        for (int num : nums) {
            if(num == 0) {
                zeroFlag++;
                realTotal *= num;
            } else if (num == 1) {
                oneFlag++;
            } else {
                realTotal *= num;
                total *= num;
            }
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && zeroFlag < 2) {
                answer[i] = total;
            } else if (nums[i] == 0 && zeroFlag >= 2) {
                answer[i] = 0;
            } else {
                int ans = realTotal / nums[i];
                if(nums[i] != -1 && ans == 1 && oneFlag < 2) {
                    answer[i] = 0;
                } else if (nums[i] != -1 && ans == 1 && oneFlag >= 2){
                    answer[i] = 1;
                } else answer[i] = ans;
            }
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
