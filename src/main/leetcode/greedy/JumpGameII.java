package main.leetcode.greedy;

public class JumpGameII {

    public int jump(int[] nums) {
        int[] jumps = new int[100000];

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i]; j++) {
                if(jumps[i + j + 1] != 0) jumps[i + j + 1] = Math.min(jumps[i + j + 1], jumps[i] + 1);
                else jumps[i + j + 1] = jumps[i] + 1;
            }

            if(jumps[nums.length-1] != 0) {
                break;
            }
        }

        return jumps[nums.length-1];
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int ans = jumpGameII.jump(new int[]{2,3,1,1,4});
        System.out.println(ans);

        ans = jumpGameII.jump(new int[]{2,3,0,1,4});
        System.out.println(ans);

        ans = jumpGameII.jump(new int[]{1});
        System.out.println(ans);

        ans = jumpGameII.jump(new int[]{1, 2, 1,1,1});
        System.out.println(ans);
    }
}
