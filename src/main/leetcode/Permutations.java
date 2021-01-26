package main.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-01-25
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> ans1 = permutations.permute(new int[]{1,2,3});
        System.out.println("ans1 = " + ans1);

        List<List<Integer>> ans2 = permutations.permute(new int[]{0, 1});
        System.out.println("ans2 = " + ans2);

        List<List<Integer>> ans3 = permutations.permute(new int[]{1});
        System.out.println("ans3 = " + ans3);
    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet();
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            dfs(answer, set, nums);
            set.remove(nums[i]);
        }

        return answer;
    }

    private void dfs(List<List<Integer>> answer, LinkedHashSet<Integer> set, int[] nums) {
        if(nums.length == set.size()) {
            answer.add(new ArrayList<>(set));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                dfs(answer, set, nums);
                set.remove(nums[i]);
            }
        }
    }
}
