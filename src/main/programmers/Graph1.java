package main.programmers;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;


/*
* dfs로 풀었다가 bfs로 변경
*
* 한 노드에서 다른 각 노드들까지의 거리를 구하는 경우 dfs보다는 bfs를 통해 전체 탐색을 하며 distance 를 구하는게 최적.
* */
public class Graph1 {

    Map<Integer, List<Integer>> map;
    boolean[] visits;
    Map<Integer, Integer> minMap;
    Queue<Integer> queue;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        // Map<node number, List<Integer>> : 각 노드들 간의 연결 관계를 담아내는 map
        map = new HashMap<>();
        for (int[] item : edge) {
            if (map.get(item[0]) == null) {
                map.put(item[0], new ArrayList<>());
            }
            if (map.get(item[1]) == null) {
                map.put(item[1], new ArrayList<>());
            }

            map.get(item[0]).add(item[1]);
            map.get(item[1]).add(item[0]);
        }

        visits = new boolean[n + 1];

        // 1부터 n까지 최단거리를 담고 있는 map
        minMap = new HashMap<>();
        // 초기화
        for (int i = 1; i <= n; i++) {
            minMap.put(i, 0);
        }

        queue = new LinkedList<>();
        // 시작점.
        queue.add(1);

        // 각 노드들을 bfs로 전체 한번 탐색하며
        // 1에서 떨어진 거리를 minMap에 저
        while(!queue.isEmpty()) {
            int start = queue.poll();

            for (int node : map.get(start)) {
                // 1 에서 target 을 찾은 경우
                if(!visits[node]) {
                    visits[node] = true;
                    minMap.put(node, minMap.get(start) + 1);
                    queue.add(node);
                }
            }
        }

        // 1에서 1의 거리는 제외해야하므로 삭제.
        minMap.remove(1);

        // 최단거리를 내림차순 정렬하여 가장 멀리있는 거리의 갯수를 취합.
        List<Integer> entries = minMap.entrySet().stream().sorted(Map.Entry.comparingByValue((o1, o2) -> o2 - o1))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        int max = entries.get(0);
        for (Integer entry : entries) {
            if (max > entry) {
                break;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Graph1 graph1 = new Graph1();
        int ans1 = graph1.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println("ans1 => " + ans1);
        int ans2 = graph1.solution(4, new int[][]{{1, 2}, {2, 4}, {3, 4}, {1, 3}});
        System.out.println("ans2 => " + ans2);
    }
}
