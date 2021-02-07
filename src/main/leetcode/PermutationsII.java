package main.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by geonyeong.kim on 2021-02-03
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        boolean[] visit = new boolean[nums.length];
        Set<String> duplicateSet = new HashSet<>();
        List<Integer> subList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            visit[i] = true;
            subList.add(nums[i]);
            dfs(answer, duplicateSet, visit, subList, nums);
            subList.remove(subList.size() - 1);
            visit[i] = false;
        }

        return answer;
    }

    private void dfs(List<List<Integer>> answer, Set<String> duplicateSet, boolean[] visit, List<Integer> subList, int[] nums) {
        if(visit.length == subList.size()) {
            String s = subList.stream().map(String::valueOf).collect(Collectors.joining(""));
            if(!duplicateSet.contains(s)) {
                duplicateSet.add(s);
                answer.add(new ArrayList<>(subList));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                subList.add(nums[i]);
                dfs(answer, duplicateSet, visit, subList, nums);
                subList.remove(subList.size() - 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();

        List<List<Integer>> ans = permutationsII.permuteUnique(new int[]{1, 1, 2});
        System.out.println("ans => " + ans);

        ans = permutationsII.permuteUnique(new int[]{1, 2, 3});
        System.out.println("ans => " + ans);
    }
}
