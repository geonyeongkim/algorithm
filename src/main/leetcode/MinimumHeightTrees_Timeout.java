package main.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by geonyeong.kim on 2021-02-23
 */
public class MinimumHeightTrees_Timeout {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);

        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> connect = new HashMap<>();

        for (int i = 0; i < n; i++) {
            connect.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            connect.get(edge[0]).add(edge[1]);
            connect.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visit;

        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            queue.clear();
            int cnt = 0;

            // bfs 를 통해 확인
            visit[i] = true;
            cnt++;

            for (int node : connect.get(i)) {
                queue.add(node);
                visit[node] = true;
            }

            if(checkVisit(visit)) {
                list.add(i, cnt);
                continue;
            }

            while(!queue.isEmpty()) {
                int size = queue.size();
                while(size-- > 0) {
                    for(int connectNode: connect.get(queue.poll())) {
                        if(!visit[connectNode]) {
                            queue.add(connectNode);
                            visit[connectNode] = true;
                        }
                    }
                }

                cnt++;
                // visit check
                if(checkVisit(visit)) break;
            }
            list.add(i, cnt);
        }

        List<Integer> answer = new ArrayList<>();

        int minVal = Collections.min(list);

        for (int i = 0; i < list.size(); i++) {
            if (minVal == list.get(i)) {
                answer.add(i);
            }
        }

        return answer;
    }

    private boolean checkVisit(boolean[] visits) {
        for (boolean visit : visits) {
            if(!visit) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumHeightTrees_Timeout minimumHeightTrees = new MinimumHeightTrees_Timeout();
        List<Integer> ans = minimumHeightTrees.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
        System.out.println(ans);

        ans = minimumHeightTrees.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        System.out.println(ans);

        ans = minimumHeightTrees.findMinHeightTrees(2, new int[][]{{0, 1}});
        System.out.println(ans);
    }
}
