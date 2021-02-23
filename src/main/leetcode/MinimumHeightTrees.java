package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by geonyeong.kim on 2021-02-23
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n == 1) return Arrays.asList(0);

        List<Integer> answer = new ArrayList<>();
        Map<Integer, List<Integer>> connect = new HashMap<>();
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) {
            connect.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            connect.get(edge[0]).add(edge[1]);
            connect.get(edge[1]).add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(degrees[i] == 1) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            answer.clear();
            while(size-- > 0) {
                int node = queue.poll();
                answer.add(node);
                for (int v : connect.get(node)) {
                    degrees[v]--;
                    if(degrees[v] == 1) {
                        queue.add(v);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        List<Integer> ans = minimumHeightTrees.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
        System.out.println(ans);

        ans = minimumHeightTrees.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        System.out.println(ans);

        ans = minimumHeightTrees.findMinHeightTrees(2, new int[][]{{0, 1}});
        System.out.println(ans);
    }
}
