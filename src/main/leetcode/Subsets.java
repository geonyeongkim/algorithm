package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-02-16
 */
public class Subsets {

    static int[] numsCopy;
    static boolean[] visit;
    static int size;
    static List<List<Integer>> answer;

    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        visit = new boolean[nums.length];
        size = nums.length;
        numsCopy = nums;

        dfs(0);

        return answer;
    }

    private void dfs(int idx) {

        if(idx == size) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < numsCopy.length; i++) {
                if(visit[i]) {
                    list.add(numsCopy[i]);
                }
            }
            answer.add(list);
            return;
        }

        visit[idx] = true;
        dfs(idx + 1);

        visit[idx] = false;
        dfs(idx + 1);
    }

    public static void main(String[] args) {
        Subsets leetCode_78_subsets = new Subsets();
        List<List<Integer>> ans = leetCode_78_subsets.subsets(new int[]{1, 2, 3});
        System.out.println(ans);

        ans = leetCode_78_subsets.subsets(new int[]{0});
        System.out.println(ans);
    }
}
