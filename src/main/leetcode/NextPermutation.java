package main.leetcode;

/**
 * Created by geonyeong.kim on 2021-02-19
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int idx = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                for(int j = nums.length - 1; j > i; j--) {
                    if(nums[i] < nums[j]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        idx = i;
                        break;
                    }
                }
                if(idx > -1) break;
            }
        }

        int left = 0, right = nums.length - 1;
        if(idx > -1) {
            left = idx + 1;
        }

        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    private void print(int[] nums) {
        for (int num : nums) {
            System.out.print("num = " + num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{1, 2, 3});

        nextPermutation.nextPermutation(new int[]{3, 2, 1});

        nextPermutation.nextPermutation(new int[]{1, 1, 5});

        nextPermutation.nextPermutation(new int[]{1});

        nextPermutation.nextPermutation(new int[]{1, 3, 2});
    }
}
