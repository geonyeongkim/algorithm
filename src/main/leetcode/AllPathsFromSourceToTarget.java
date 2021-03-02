package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    List<List<Integer>> answer;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        answer = new ArrayList<>();

        List<List<Integer>> connect = new ArrayList<>();

        // 연결정보 추가.
        for (int i = 0; i < graph.length; i++) {
            connect.add(i, new ArrayList<>());
            for (int val : graph[i]) {
                connect.get(i).add(val);
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(connect, 0, list, graph.length - 1);

        return answer;
    }

    private void dfs(List<List<Integer>> connect, int idx, List<Integer> list, int dst) {
        if(dst == idx) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int next : connect.get(idx)) {
            list.add(next);
            dfs(connect, next, list, dst);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget allPathsFromSourceToTarget = new AllPathsFromSourceToTarget();
        List<List<Integer>> ans = allPathsFromSourceToTarget.allPathsSourceTarget(new int[][]{{1,2, 3}, {2}, {3}, {}});
        System.out.println(ans);

        ans = allPathsFromSourceToTarget.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}});
        System.out.println(ans);

        ans = allPathsFromSourceToTarget.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
        System.out.println(ans);

        ans = allPathsFromSourceToTarget.allPathsSourceTarget(new int[][]{{1}, {}});
        System.out.println(ans);

        ans = allPathsFromSourceToTarget.allPathsSourceTarget(new int[][]{{1, 3}, {2}, {3}, {}});
        System.out.println(ans);

        ans = allPathsFromSourceToTarget.allPathsSourceTarget(new int[][]{{4, 3 ,1}, {3, 2, 4}, {}, {4}, {}});
        System.out.println(ans);
    }
}
