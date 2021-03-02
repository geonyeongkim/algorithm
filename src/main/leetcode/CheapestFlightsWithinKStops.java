package main.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by geonyeong.kim on 2021-03-02
 */
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> connect = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            connect.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            // {타켓 노드번호, 타켓 노드까지 가는데 드는 비용}
            connect.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // { 노드 번호, 현재까지 이동한 거리, 거쳐갈 수 있는 도시 갯수 }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        queue.add(new int[]{src, 0, K + 1});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            // 우선순위 큐를 사용했기에, 도착지를 만나면 바로 리턴
            if (node[0] == dst) {
                return node[1];
            }
            // 더 거쳐갈 수 있으면 거쳐가면서 도착지를 갈 수 있는지 확인
            else if (node[2] > 0) {
                for (int[] targetNode : connect.get(node[0])) {
                    queue.add(new int[]{targetNode[0], node[1] + targetNode[1], node[2] - 1});
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        int ans = cheapestFlightsWithinKStops.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1);
        System.out.println(ans);

        ans = cheapestFlightsWithinKStops.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0);
        System.out.println(ans);

        ans = cheapestFlightsWithinKStops
                .findCheapestPrice(5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1);
        System.out.println(ans);

        ans = cheapestFlightsWithinKStops
                .findCheapestPrice(4, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1);
        System.out.println(ans);
    }
}
